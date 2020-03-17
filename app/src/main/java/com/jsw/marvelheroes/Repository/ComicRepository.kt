package com.jsw.marvelheroes.Repository

import android.util.Log
import com.jsw.marvelheroes.Api.MarvelApi
import com.jsw.marvelheroes.Model.Comic
import com.jsw.marvelheroes.Model.ComicDataWrapper
import com.jsw.marvelheroes.Presenter.ComicPresenter
import com.jsw.marvelheroes.Utils.Utils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList

class ComicRepository(val marvelApi: MarvelApi) {

    /* -- VARS --*/
    private var comics: ArrayList<Comic>
    val timestamp = Date().time
    val defaultLimit = 100
    var offset = 0
    val hash = Utils().MD5(timestamp.toString() + Utils().private_key + Utils().public_key)
    /* -- FUNCTIONS --*/
    init {
        comics = ArrayList()
    }

    fun getAll(callback: ComicPresenter, heroID: String) {
        val call: Call<ComicDataWrapper> = marvelApi.getComicsByCharacterId(heroID, Utils().public_key, hash, timestamp, offset, defaultLimit)

        call.enqueue(object : Callback<ComicDataWrapper?> {
            override fun onResponse(call: Call<ComicDataWrapper?>?, response: Response<ComicDataWrapper?>) {
                var list = response.body()?.getData()?.getComics()?.toList() as? ArrayList<Comic>

                if (list != null) {
                    comics.addAll(list)
                    offset +=  100
                }

                callback.displayComics(comics)
            }

            override fun onFailure(call: Call<ComicDataWrapper?>?, t: Throwable?) {
                Log.e("COMICS PRESENTER: ", t?.message)
            }
        })
    }
}