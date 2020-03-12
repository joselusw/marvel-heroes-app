package com.jsw.marvelheroes.ViewHolder

import androidx.recyclerview.widget.RecyclerView
import com.jsw.marvelheroes.Model.Hero
import com.jsw.marvelheroes.Presenter.HeroesPresenter
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.jsw.marvelheroes.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.heroe_row.view.*

class HeroViewHolder(itemView: View, private val presenter: HeroesPresenter) : RecyclerView.ViewHolder(itemView) {
    /* -- VARS --*/
    private val iv_image: ImageView = itemView.findViewById(R.id.iv_image)
    private val tv_name: TextView = itemView.findViewById(R.id.tv_name)
    private val tv_description: TextView = itemView.findViewById(R.id.tv_description)

    fun render(hero: Hero) {
        //Set listeners
        itemView.setOnClickListener { presenter.onHeroClicked(hero) }

        //Fulfill info
        Picasso.get().load(hero.picture).into(iv_image)
        tv_name.text = hero.name
        tv_description.text = hero.description
    }
}

