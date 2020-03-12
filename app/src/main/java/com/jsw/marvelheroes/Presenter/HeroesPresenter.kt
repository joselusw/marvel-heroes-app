package com.jsw.marvelheroes.Presenter

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.jsw.marvelheroes.Model.Hero
import com.jsw.marvelheroes.Repository.HeroesRepository
import kotlinx.coroutines.*

class HeroesPresenter(view: View, private val repository: HeroesRepository) : LifecycleObserver, CoroutineScope by MainScope() {
    /* -- VARS --*/
    private val view: View? = view

    /* -- FUNCTIONS --*/
    init {
        view.showLoading()
        loadHeroes()
    }

    private fun loadHeroes() = launch {
        val result = repository.getAll()
        view?.hideLoading()
        when {
            !result.isEmpty() -> view?.fillList(result)
        }
    }

    fun onHeroClicked(heroe: Hero) = view?.openComics(heroe.name)

    interface View {
        fun fillList(heroes: List<Hero>)
        fun hideLoading()
        fun openComics(heroName: String)
        fun showLoading()
    }
}