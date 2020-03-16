package com.jsw.marvelheroes.Repository

import android.util.Log
import com.jsw.marvelheroes.Api.MarvelApi
import com.jsw.marvelheroes.Model.ApiResponse
import com.jsw.marvelheroes.Model.Hero
import com.jsw.marvelheroes.Presenter.HeroesPresenter
import com.jsw.marvelheroes.Utils.Utils
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import org.json.JSONArray
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.security.MessageDigest
import java.util.*
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.BlockingQueue
import kotlin.collections.ArrayList


class HeroesRepository constructor(val marvelApi: MarvelApi) {

    /* -- VARS --*/
    private var superHeroes: ArrayList<Hero>
    val timestamp = Date().time
    val defaultLimit = 100
    var offset = 0
    val hash = Utils().MD5(timestamp.toString() + Utils().private_key + Utils().public_key)
    /* -- FUNCTIONS --*/
    init {
        superHeroes = ArrayList()
    }

    fun getAll(callback: HeroesPresenter) {
        if (superHeroes.isEmpty()) {
            val call: Call<ApiResponse> =
                marvelApi.getCharacters(Utils().public_key, hash, timestamp, offset, defaultLimit)

            call.enqueue(object : Callback<ApiResponse?> {
                override fun onResponse(
                    call: Call<ApiResponse?>?,
                    response: Response<ApiResponse?>
                ) {
                    var list =
                        response.body()?.getData()?.getResults()?.toList() as? ArrayList<Hero>

                    if (list != null) {
                        superHeroes.addAll(list)
                        offset += 100
                    }

                    callback.displayHeroes(superHeroes)
                }

                override fun onFailure(call: Call<ApiResponse?>?, t: Throwable?) {
                    Log.e("HEROES PRESENTER: ", t?.message)
                }
            })
        } else {
            callback.displayHeroes(superHeroes)
        }
    }

    fun getFiltered(name: String): List<Hero>  {
        return superHeroes.filter { it.getName() == name }
    }
}
