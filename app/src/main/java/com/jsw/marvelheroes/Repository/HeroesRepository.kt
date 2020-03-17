package com.jsw.marvelheroes.Repository

import android.util.Log
import com.jsw.marvelheroes.Api.MarvelApi
import com.jsw.marvelheroes.Model.CharacterDataWrapper
import com.jsw.marvelheroes.Model.Hero
import com.jsw.marvelheroes.Presenter.HeroesPresenter
import com.jsw.marvelheroes.Utils.Utils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList


class HeroesRepository constructor(val marvelApi: MarvelApi) {

    /* -- VARS --*/
    private var superHeroes: ArrayList<Hero>
    val timestamp = Date().time
    val defaultLimit = 50
    var offset = 0
    val hash = Utils().MD5(timestamp.toString() + Utils().private_key + Utils().public_key)
    var getAllRequest: Boolean = false
    /* -- FUNCTIONS --*/
    init {
        superHeroes = ArrayList()
    }

    fun getAll(name: String?, pagination: Boolean, callback: HeroesPresenter) {

        if (!pagination) {
            superHeroes.clear()
            offset = 0
        }

            val call: Call<CharacterDataWrapper> =
                marvelApi.getCharacters(Utils().public_key, hash, timestamp, offset, defaultLimit, name)

            call.enqueue(object : Callback<CharacterDataWrapper?> {
                override fun onResponse(
                    call: Call<CharacterDataWrapper?>?,
                    response: Response<CharacterDataWrapper?>
                ) {
                    var list =
                        response.body()?.getData()?.getResults()?.toList() as? ArrayList<Hero>

                    if (list != null) {
                        superHeroes.addAll(list)
                        offset += 50
                    }

                    callback.displayHeroes(superHeroes)
                }

                override fun onFailure(call: Call<CharacterDataWrapper?>?, t: Throwable?) {
                    Log.e("HEROES PRESENTER: ", t?.message)
                }
            })
        }
}
