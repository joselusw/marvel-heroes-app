package com.jsw.marvelheroes.ViewHolder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jsw.marvelheroes.Model.Comic
import com.jsw.marvelheroes.Presenter.ComicPresenter
import com.jsw.marvelheroes.R

class ComicViewHolder (itemView: View, private val presenter: ComicPresenter) : RecyclerView.ViewHolder(itemView) {
    /* -- VARS --*/
    private val iv_image: ImageView = itemView.findViewById(R.id.iv_image)
    private val tv_name: TextView = itemView.findViewById(R.id.tv_name)
    private val tv_description: TextView = itemView.findViewById(R.id.tv_description)

    fun render(comic: Comic) {

        //Set listeners
        itemView.setOnClickListener(View.OnClickListener {
            presenter.onComicClicked(comic)
        })

        //Fulfill info
        Glide.with(itemView.context).load(comic.getThumbnail()?.getURL()).into(iv_image)
        tv_name.text = comic.geTitle()
        tv_description.text = comic.getDescription()
    }
}