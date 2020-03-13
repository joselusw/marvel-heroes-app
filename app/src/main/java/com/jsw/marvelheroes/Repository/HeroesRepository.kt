package com.jsw.marvelheroes.Repository

import com.jsw.marvelheroes.Api.MarvelApi
import com.jsw.marvelheroes.Model.ApiResponse
import com.jsw.marvelheroes.Model.Hero
import com.jsw.marvelheroes.Presenter.HeroesPresenter
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
    private var private_key = "0e1daa77fd293f9f7050475e1925540e9d2e2d7c"
    private var public_key = "9cb2af5b08a272722e93f49c15eead15"
    private var superHeroes: ArrayList<Hero>
    val timestamp = Date().time
    val defaultLimit = 100
    var offset = 0
    val hash = MD5(timestamp.toString() + private_key + public_key)
    /* -- FUNCTIONS --*/
    init {
        superHeroes = ArrayList()
    }

    fun getAll(callback: HeroesPresenter) {
        val call: Call<ApiResponse> = marvelApi.getCharacters(public_key, hash, timestamp)

        call.enqueue(object : Callback<ApiResponse?> {
            override fun onResponse(call: Call<ApiResponse?>?, response: Response<ApiResponse?>) {
                superHeroes = response?.body()?.getData()?.getResults()?.toList() as ArrayList<Hero>
                callback.displayHeroes(superHeroes)
            }

            override fun onFailure(call: Call<ApiResponse?>?, t: Throwable?) {
                //Handle failure
            }
        })
    }

    fun getFiltered(name: String): List<Hero>  {
        return superHeroes.filter { it.getName() == name }
    }

    fun MD5(string: String): String {
        val bytes = MessageDigest.getInstance("MD5").digest(string.toByteArray())
        return bytes.joinToString("") { "%02x".format(it) }
    }

}
