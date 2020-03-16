package com.jsw.marvelheroes.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jsw.marvelheroes.Activitiy.HomeActivity
import com.jsw.marvelheroes.Adapter.ComicAdapter
import com.jsw.marvelheroes.Model.Comic
import com.jsw.marvelheroes.Model.Hero
import com.jsw.marvelheroes.Presenter.ComicPresenter
import com.jsw.marvelheroes.R

class ComicFragment(private val hero: Hero)  : Fragment(), ComicPresenter.View {

    /* -- VARS --*/
    private lateinit var presenter: ComicPresenter
    private lateinit var adapter: ComicAdapter
    private var recycler: RecyclerView? = null

    /* -- LIFECYCLE FUNCTIONS --*/
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_comic, container, false)

        //Initialize repo & presenter
        presenter = ComicPresenter(this, hero)

        //Initialize view (Old-school style)
        recycler = view?.findViewById(R.id.rv_comics)
        setupRecycler()

        //Finally return view
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    /* -- PRESENTER FUNCTIONS --*/
    override fun fillList(comics: List<Comic>) {
        if (adapter != null) {
            adapter.clearAdapter()
            adapter.fillAdapter(comics)
            adapter.notifyDataSetChanged()
        }
    }

    override fun openComic(comic: Comic) {
        (activity as HomeActivity).openDetailsFragment(comic)
    }

    /* -- PRIVATE FUNCTIONS --*/
    private fun setupRecycler() {
        val layoutManager = LinearLayoutManager(context)
        adapter = ComicAdapter(presenter)
        recycler?.adapter = adapter
        recycler?.layoutManager = layoutManager
    }
}