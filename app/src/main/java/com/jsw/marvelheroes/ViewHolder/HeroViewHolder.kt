package com.jsw.marvelheroes.ViewHolder

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jsw.marvelheroes.Model.Hero
import com.jsw.marvelheroes.Presenter.HeroesPresenter
import com.squareup.picasso.Picasso


class HeroViewHolder(itemView: View, private val presenter: HeroesPresenter) : RecyclerView.ViewHolder(itemView) {
    /* -- VARS --*/
    private val iv_image: ImageView = itemView.findViewById(R.id.iv_image)
    private val tv_name: TextView = itemView.findViewById(R.id.tv_name)
    private val tv_description: TextView = itemView.findViewById(R.id.tv_description)

    fun render(hero: Hero) {
        //Set listeners
        itemView.setOnClickListener { presenter.onHeroClicked(hero) }

        //Fulfill info
        var url = hero.getThumbnail()?.getURL()

        Picasso.get().load(url).resize(75, 75).centerInside().into(iv_image)
        tv_name.text = hero.getName()
        tv_description.text = hero.getDescription()
    }
}

