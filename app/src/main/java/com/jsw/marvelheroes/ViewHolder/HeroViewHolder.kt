package com.jsw.marvelheroes.ViewHolder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jsw.marvelheroes.Model.Hero
import com.jsw.marvelheroes.Presenter.HeroesPresenter
import com.jsw.marvelheroes.R


class HeroViewHolder(itemView: View, private val presenter: HeroesPresenter) :
    RecyclerView.ViewHolder(itemView) {
    /* -- VARS --*/
    private val iv_image: ImageView = itemView.findViewById(R.id.iv_image)
    private val tv_name: TextView = itemView.findViewById(R.id.tv_name)
    private val tv_description: TextView = itemView.findViewById(R.id.tv_description)

    fun render(hero: Hero) {

        //Set listeners
        itemView.setOnClickListener(View.OnClickListener {
            presenter.onHeroClicked(hero)
        })

        //Fulfill info
        val url = hero.getThumbnail()?.getURL()
        iv_image.visibility = View.VISIBLE
        Glide.with(itemView.context).load(url).into(iv_image)
        tv_name.text = hero.getName()
        tv_description.text = hero.getDescription()
    }
}

