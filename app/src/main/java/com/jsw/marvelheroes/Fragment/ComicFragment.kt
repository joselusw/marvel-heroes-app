package com.jsw.marvelheroes.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jsw.marvelheroes.Activitiy.HomeActivity
import com.jsw.marvelheroes.Adapter.ComicAdapter
import com.jsw.marvelheroes.Component.OnBottomReachedListener
import com.jsw.marvelheroes.Model.Comic
import com.jsw.marvelheroes.Model.Hero
import com.jsw.marvelheroes.Presenter.ComicPresenter
import com.jsw.marvelheroes.R

class ComicFragment(private val hero: Hero)  : Fragment(), ComicPresenter.View {

    /* -- VARS --*/
    private lateinit var presenter: ComicPresenter
    private lateinit var adapter: ComicAdapter
    private var recycler: RecyclerView? = null
    private var progressBar: ProgressBar? = null

    /* -- LIFECYCLE FUNCTIONS --*/
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_comic, container, false)

        //Initialize repo & presenter
        presenter = ComicPresenter(this, hero)

        //Initialize view (Old-school style)
        recycler = view?.findViewById(R.id.rv_comics)
        progressBar = view?.findViewById(R.id.pb_comic_progress)

        setupRecycler()
        activity?.setTitle(R.string.title_comic)
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

    override fun hideLoading() {
        progressBar?.visibility = View.GONE
    }

    override fun showLoading() {
        progressBar?.visibility = View.VISIBLE
    }

    /* -- PRIVATE FUNCTIONS --*/
    private fun setupRecycler() {
        val layoutManager = LinearLayoutManager(context)
        adapter = ComicAdapter(presenter)
        recycler?.adapter = adapter
        recycler?.layoutManager = layoutManager

        adapter.setOnBottomReachedListener(object : OnBottomReachedListener {
            override fun onBottomReached(position: Int) {
               presenter.loadComics()
            }
        })
    }
}