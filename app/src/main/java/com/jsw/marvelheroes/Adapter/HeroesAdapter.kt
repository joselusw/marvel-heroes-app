package com.jsw.marvelheroes.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jsw.marvelheroes.Component.OnBottomReachedListener
import com.jsw.marvelheroes.Model.Hero
import com.jsw.marvelheroes.Presenter.HeroesPresenter
import com.jsw.marvelheroes.R
import com.jsw.marvelheroes.ViewHolder.HeroViewHolder


internal class HeroesAdapter(private val presenter: HeroesPresenter) :
    RecyclerView.Adapter<HeroViewHolder>() {
    /* -- VARS --*/
    private val heroes: ArrayList<Hero> = ArrayList()
    private var onBottomReachedListener: OnBottomReachedListener? = null

    /* -- OVERRIDE FUNCTIONS --*/
    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        val superHero = heroes[position]
        holder.render(superHero)
        if (position == heroes.size - 20) {
            onBottomReachedListener?.onBottomReached(position); }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.holder_row, parent, false)
        return HeroViewHolder(view, presenter)
    }

    override fun getItemCount(): Int {
        return heroes.size
    }

    override fun getItemId(position: Int): Long {
        return heroes[position].getId()?.toLong()!!
    }

    /* -- ADAPTER FUNCTIONS --*/
    /**
     * Clean the heroes list
     */
    fun clearAdapter() {
        heroes.clear()
    }

    /**
     * Fulfill the heroes adapter
     */
    fun fillAdapter(collection: List<Hero>) {
        heroes.addAll(collection)
    }

    /**
     * Set the listener
     */
    fun setOnBottomReachedListener(onBottomReachedListener: OnBottomReachedListener?) {
        this.onBottomReachedListener = onBottomReachedListener
    }
}