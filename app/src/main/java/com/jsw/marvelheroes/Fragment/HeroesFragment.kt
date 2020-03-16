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
import com.jsw.marvelheroes.Adapter.HeroesAdapter
import com.jsw.marvelheroes.Api.HeroesAPI
import com.jsw.marvelheroes.Api.MarvelApi
import com.jsw.marvelheroes.Model.Hero
import com.jsw.marvelheroes.Presenter.HeroesPresenter
import com.jsw.marvelheroes.R
import com.jsw.marvelheroes.Repository.HeroesRepository


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HeroesFragment : Fragment(), HeroesPresenter.View {

    /* -- VARS --*/
    private lateinit var presenter: HeroesPresenter
    private lateinit var adapter: HeroesAdapter
    private var recycler: RecyclerView? = null
    private var progressBar: ProgressBar? = null

    /* -- LIFECYCLE FUNCTIONS --*/
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_heroes, container, false)

        //Initialize repo & presenter
        presenter = HeroesPresenter(this)

        //Initialize view (Old-school style)
        recycler = view?.findViewById(R.id.rv_heroes)
        progressBar = view?.findViewById(R.id.pb_progress)
        setupRecycler()

        //Finally return view
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    /* -- PRESENTER FUNCTIONS --*/
    override fun fillList(heroes: List<Hero>) {
        adapter.clearAdapter()
        adapter.fillAdapter(heroes)
        adapter.notifyDataSetChanged()
    }

    override fun hideLoading() {
        progressBar?.visibility = View.GONE
    }

    override fun openComics(hero: Hero) {
        (activity as HomeActivity).openComicFragment(hero)
    }

    override fun showLoading() {
        progressBar?.visibility = View.VISIBLE
    }

    /* -- PRIVATE FUNCTIONS --*/
    private fun setupRecycler() {
        val layoutManager = LinearLayoutManager(context)
        adapter = HeroesAdapter(presenter)
        recycler?.adapter = adapter
        recycler?.layoutManager = layoutManager
    }
}
