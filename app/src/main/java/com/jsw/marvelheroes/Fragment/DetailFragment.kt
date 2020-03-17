package com.jsw.marvelheroes.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.jsw.marvelheroes.Model.Comic

import com.jsw.marvelheroes.R
import org.w3c.dom.Text

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment(comic: Comic) : Fragment() {
    // TODO: Rename and change types of parameters
    private var comic = comic
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_detail, container, false)
        var iv_detail = view?.findViewById<ImageView>(R.id.iv_detail)
        Glide.with(context!!).load(comic.getThumbnail()?.getURL()).into(iv_detail!!)
        view?.findViewById<TextView>(R.id.tv_detail_title)?.text = comic.geTitle()
        view?.findViewById<TextView>(R.id.tv_detail_year)?.text = comic.getDates()?.get(0)?.getDate()
        view?.findViewById<TextView>(R.id.tv_detail_desc)?.text = comic.getDescription()
        return view
    }
}
