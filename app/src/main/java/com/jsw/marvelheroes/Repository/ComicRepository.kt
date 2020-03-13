package com.jsw.marvelheroes.Repository

import com.jsw.marvelheroes.Model.Hero

class ComicRepository {

    /* -- VARS --*/
    private val superHeroes: ArrayList<Hero>

    /* -- FUNCTIONS --*/
    init {
        superHeroes = ArrayList()
    }

    fun getAll(): ArrayList<Hero> {
        return superHeroes
    }

    fun getFiltered(name: String): Hero {
        return superHeroes.first { it.getName() == name }
    }
}