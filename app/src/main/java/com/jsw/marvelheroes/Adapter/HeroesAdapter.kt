package com.jsw.marvelheroes.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jsw.marvelheroes.Model.Hero
import com.jsw.marvelheroes.Presenter.HeroesPresenter
import com.jsw.marvelheroes.R
import com.jsw.marvelheroes.ViewHolder.HeroViewHolder

internal class HeroesAdapter(private val presenter: HeroesPresenter) : RecyclerView.Adapter<HeroViewHolder>() {
    /* -- VARS --*/
    private val heroes: ArrayList<Hero> = ArrayList()

    /* -- OVERRIDE FUNCTIONS --*/
    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        val superHero = heroes[position]
        holder.render(superHero)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.heroe_row, parent, false)
        return HeroViewHolder(view, presenter)
    }

    override fun getItemCount(): Int {
        return heroes.size
    }

    override fun getItemId(position: Int): Long {
        return heroes[position].getId()?.toLong()!!
    }

    /* -- ADAPTER FUNCTIONS --*/
    fun clearAdapter() {
        heroes.clear()
    }

    fun fillAdapter(collection: List<Hero>) {
        heroes.addAll(collection)
    }
}