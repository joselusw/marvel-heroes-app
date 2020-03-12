package com.jsw.marvelheroes.Repository

import android.util.Log
import com.jsw.marvelheroes.Model.Hero

class HeroesRepository {
    /* -- VARS --*/
    private val superHeroes: ArrayList<Hero>

    /* -- FUNCTIONS --*/
    init {
        superHeroes = ArrayList()
        //TODO: Remove this dummy stuff
        superHeroes.add(Hero("Iron-Man", "Obviously the best superhero", "https://los40mx00.epimg.net/los40/imagenes/2016/04/27/actualidad/1461775947_581980_1461776328_noticia_normal.jpg"))
    }

    fun getAll(): ArrayList<Hero> {
        return superHeroes
    }

    fun getFiltered(name: String): Hero {
        return superHeroes.first { it.name == name }
    }
}