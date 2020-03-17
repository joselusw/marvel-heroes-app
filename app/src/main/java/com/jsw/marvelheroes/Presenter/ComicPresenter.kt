package com.jsw.marvelheroes.Presenter

import androidx.lifecycle.LifecycleObserver
import com.jsw.marvelheroes.Api.HeroesAPI
import com.jsw.marvelheroes.Api.MarvelApi
import com.jsw.marvelheroes.Model.Comic
import com.jsw.marvelheroes.Model.Hero
import com.jsw.marvelheroes.Repository.ComicRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope

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

    fun loadComics(hideHint: Boolean = false) {
        if (!hideHint)
            view?.showLoading()
        hero.getId()?.let { repository.getAll(this, it) }
    }

    fun displayComics(collection: List<Comic>) {
        view?.fillList(collection)
        view?.hideLoading()
    }

    fun onComicClicked(comic: Comic) {
        view?.openComic(comic)
    }

    interface View {
        fun fillList(comics: List<Comic>)
        fun openComic(comic: Comic)
        fun hideLoading()
        fun showLoading()
    }
}