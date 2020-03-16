package com.jsw.marvelheroes.Presenter

import androidx.lifecycle.LifecycleObserver
import com.jsw.marvelheroes.Api.HeroesAPI
import com.jsw.marvelheroes.Api.MarvelApi
import com.jsw.marvelheroes.Model.Comic
import com.jsw.marvelheroes.Model.Hero
import com.jsw.marvelheroes.Repository.ComicRepository
import com.jsw.marvelheroes.Repository.HeroesRepository
import kotlinx.coroutines.*

class ComicPresenter(view: View, hero: Hero) : LifecycleObserver, CoroutineScope by MainScope() {
    /* -- VARS --*/
    private val view: View? = view
    private val hero: Hero = hero
    private var repository: ComicRepository

    /* -- FUNCTIONS --*/
    init {
        repository = ComicRepository(HeroesAPI.getInstance().create(MarvelApi::class.java))
        loadComics()
    }

    fun loadComics() {
        hero.getId()?.let { repository.getAll(this, it) }
    }

    fun displayComics(collection: List<Comic>) {
        view?.fillList(collection)
    }

    fun onComicClicked(comic: Comic){
        view?.openComic(comic)
    }

    interface View {
        fun fillList(comics: List<Comic>)
        fun openComic(comic: Comic)
    }
}