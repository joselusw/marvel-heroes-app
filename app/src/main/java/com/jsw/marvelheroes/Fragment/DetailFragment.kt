package com.jsw.marvelheroes.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.jsw.marvelheroes.Model.Comic
import com.jsw.marvelheroes.R

class DetailFragment(comic: Comic) : Fragment() {
    private var comic = comic

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        val iv_detail = view?.findViewById<ImageView>(R.id.iv_detail)
        var description = getString(R.string.description_placeholder)

        Glide.with(context!!).load(comic.getThumbnail()?.getURL()).into(iv_detail!!)
        view?.findViewById<TextView>(R.id.tv_detail_title)?.text = comic.geTitle()
        view?.findViewById<TextView>(R.id.tv_detail_year)?.text = comic.getDates()?.get(0)?.getDate()
        if (comic.getDescription() != null)
            description = comic.getDescription()!!
        view?.findViewById<TextView>(R.id.tv_detail_desc)?.text = description
        activity?.setTitle(R.string.title_details)
        return view
    }
}
