package com.jsw.marvelheroes.Repository

import android.util.Log
import com.jsw.marvelheroes.Model.Hero

class HeroesRepository {
    private val superHeroes: ArrayList<Hero>

    init {
        superHeroes = ArrayList()

        //TODO: Remove this dummy stuff
        superHeroes.add(Hero("Iron-Man", "Obviously the best superhero", ""))
    }

    fun getAll(): ArrayList<Hero> {
        return superHeroes
    }

    fun getFiltered(name: String): Hero {
        return superHeroes.first { it.name == name }
    }
}