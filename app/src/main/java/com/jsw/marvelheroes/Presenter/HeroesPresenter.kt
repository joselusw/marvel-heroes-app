package com.jsw.marvelheroes.Presenter

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.jsw.marvelheroes.Api.HeroesAPI
import com.jsw.marvelheroes.Api.MarvelApi
import com.jsw.marvelheroes.Model.Hero
import com.jsw.marvelheroes.Repository.HeroesRepository
import kotlinx.coroutines.*

class HeroesPresenter(view: View) : LifecycleObserver, CoroutineScope by MainScope() {
    /* -- VARS --*/
    private val view: View? = view
    private var repository: HeroesRepository

    /* -- FUNCTIONS --*/
    init {
        view.showLoading()
        repository = HeroesRepository(HeroesAPI.getInstance().create(MarvelApi::class.java))
        loadHeroes()
    }

    private fun loadHeroes() {
        val result = repository.getAll(this)
    }

    fun displayHeroes(collection: List<Hero>) {
        view?.fillList(collection)
        view?.hideLoading()
    }

    fun onHeroClicked(hero: Hero) = hero.getName()?.let { view?.openComics(it) }

    fun getFiltered(name: String) {
        view?.fillList(repository.getFiltered(name))
    }

    interface View {
        fun fillList(heroes: List<Hero>)
        fun hideLoading()
        fun openComics(heroName: String)
        fun showLoading()
    }
}