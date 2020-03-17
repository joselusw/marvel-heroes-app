package com.jsw.marvelheroes.Adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jsw.marvelheroes.Component.OnBottomReachedListener
import com.jsw.marvelheroes.Model.Comic
import com.jsw.marvelheroes.Presenter.ComicPresenter
import com.jsw.marvelheroes.R
import com.jsw.marvelheroes.ViewHolder.ComicViewHolder

internal class ComicAdapter(private val presenter: ComicPresenter) :
    RecyclerView.Adapter<ComicViewHolder>() {
    /* -- VARS --*/
    private val comics: ArrayList<Comic> = ArrayList()
    private var onBottomReachedListener: OnBottomReachedListener? = null

    /* -- OVERRIDE FUNCTIONS --*/
    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        val comic = comics[position]
        holder.render(comic)
        if (position == comics.size - 20) {
            onBottomReachedListener?.onBottomReached(position); }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.holder_row, parent, false)
        return ComicViewHolder(view, presenter)
    }

    override fun getItemCount(): Int {
        return comics.size
    }

    override fun getItemId(position: Int): Long {
        //return comics[position]
        return 0
    }

    /* -- ADAPTER FUNCTIONS --*/

    /**
     * Clean the collection
     */
    fun clearAdapter() {
        comics.clear()
    }

    /**
     * Fulfill the collection
     */
    fun fillAdapter(collection: List<Comic>) {
        comics.addAll(collection)
    }

    /**
     * Set the listener
     */
    fun setOnBottomReachedListener(onBottomReachedListener: OnBottomReachedListener?) {
        this.onBottomReachedListener = onBottomReachedListener
    }
}