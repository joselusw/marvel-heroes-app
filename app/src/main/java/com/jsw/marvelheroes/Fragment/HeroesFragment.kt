package com.jsw.marvelheroes.Fragment

import android.animation.Animator
import android.app.Activity
import android.os.Bundle
import android.view.*
import android.view.animation.AccelerateDecelerateInterpolator
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.jsw.marvelheroes.Activitiy.HomeActivity
import com.jsw.marvelheroes.Adapter.HeroesAdapter
import com.jsw.marvelheroes.Component.OnBottomReachedListener
import com.jsw.marvelheroes.Interfaces.IOnBackPressed
import com.jsw.marvelheroes.Model.Hero
import com.jsw.marvelheroes.Presenter.HeroesPresenter
import com.jsw.marvelheroes.R


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HeroesFragment : Fragment(), HeroesPresenter.View, IOnBackPressed {

    /* -- VARS --*/
    private lateinit var presenter: HeroesPresenter
    private lateinit var adapter: HeroesAdapter
    private var recycler: RecyclerView? = null
    private var progressBar: ProgressBar? = null
    private var search_bar: EditText? = null

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
        search_bar = view?.findViewById(R.id.et_searchbar)

        //Setup components
        setupRecycler()
        setupSearchBar()

        setHasOptionsMenu(true)
        activity?.setTitle(R.string.title_characters)

        //Finally return view
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.search_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (search_bar?.visibility == View.VISIBLE) {
            hideSearch()
            hideKeyboard()
        }
        else {
            search_bar?.show()
            search_bar?.requestFocus()
            showKeyboard()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed(): Boolean {
        if (search_bar?.visibility == View.VISIBLE) {
            hideSearch()
            return true
        }
        return false
    }


    /* -- PRESENTER FUNCTIONS --*/

    /**
     * Fill the adapter
     */
    override fun fillList(heroes: List<Hero>) {
        adapter.clearAdapter()
        adapter.fillAdapter(heroes)
        recycler?.post(Runnable { adapter.notifyDataSetChanged() })

    }

    /**
     * Hide the loading progressBar
     */
    override fun hideLoading() {
        progressBar?.visibility = View.GONE
    }

    /**
     * Call the activity to open ComicFragment
     */
    override fun openComics(hero: Hero) {
        (activity as HomeActivity).openComicFragment(hero)
    }

    /**
     * Show the loading progressBar
     */
    override fun showLoading() {
        progressBar?.visibility = View.VISIBLE
    }

    /* -- PRIVATE FUNCTIONS --*/

    /**
     * Setup the RecyclerView
     */
    private fun setupRecycler() {
        val layoutManager = LinearLayoutManager(context)
        adapter = HeroesAdapter(presenter)
        recycler?.adapter = adapter
        recycler?.layoutManager = layoutManager

        // Hide keyboard if user swipes
        recycler?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                hideKeyboard()
                super.onScrollStateChanged(recyclerView, newState)
            }
        })

        // Load more content if user is near of the bottom
        adapter.setOnBottomReachedListener(object : OnBottomReachedListener {
            override fun onBottomReached(position: Int) {
                if (search_bar?.text!!.isEmpty()) presenter.loadHeroes(null, true, true)
                else presenter.loadHeroes(search_bar?.text.toString(), true, true)
            }
        })
    }

    /**
     * Hide the soft keyboard
     */
    private fun hideKeyboard() {
        val inputMethodManager = activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view?.windowToken, 0)
    }

    /**
     * Show the soft keyboard
     */
    private fun showKeyboard() {
        val inputMethodManager = activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(search_bar, InputMethodManager.SHOW_IMPLICIT)
    }

    /**
     * Setup the search bar which filters
     */
    private fun setupSearchBar() {
        //Only filter when user press key instead of 'onTextChanged', so less calls will be executed
        search_bar?.setOnKeyListener(object : View.OnKeyListener {
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent): Boolean {
                // If the event is a key-down event on the "enter" button
                if (event.action == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    presenter.loadHeroes(search_bar?.text!!.toString())
                    hideKeyboard()
                    return true
                }
                return false
            }
        })
    }

    /**
     * Perform an animator to hide the search bar
     */
    fun hideSearch() {
        if (search_bar == null)
            return
        val cx: Int = search_bar!!.getRight()
        val cy: Int = (search_bar!!.getTop() + search_bar!!.getBottom()) / 2
        val dx = Math.max(cx, search_bar!!.getWidth() - cx)
        val dy = Math.max(cy, search_bar!!.getHeight() - cy)
        val finalRadius = Math.hypot(cx.toDouble(), cy.toDouble()).toFloat()

        // Android native animator
        val animator =
            ViewAnimationUtils.createCircularReveal(search_bar, cx, cy, finalRadius, 0f)
        animator.interpolator = AccelerateDecelerateInterpolator()
        animator.duration = 300
        animator.start()

        //Add a listener to set the view to GONE once animation finishes
        animator.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animator: Animator) {}
            override fun onAnimationEnd(animator: Animator) {
                search_bar!!.visibility = View.GONE
                search_bar?.text?.clear()
                presenter.loadHeroes(null)
            }
            override fun onAnimationCancel(animator: Animator) {}
            override fun onAnimationRepeat(animator: Animator) {}
        })
    }
}

/**
 * Shows the Editext with an animator
 */
private fun EditText.show() {
    // get the center for the clipping circle
    // get the center for the clipping circle
    val cx: Int = this.getRight()
    val cy: Int = (this.getTop() + this.getBottom()) / 2

    // get the final radius for the clipping circle

    // get the final radius for the clipping circle
    val dx = Math.max(cx, this.getWidth() - cx)
    val dy = Math.max(cy, this.getHeight() - cy)
    val finalRadius =
        Math.hypot(dx.toDouble(), dy.toDouble()).toFloat()

    this.setVisibility(View.VISIBLE)

    // Android native animator
    val animator: Animator =
        ViewAnimationUtils.createCircularReveal(this, cx, cy, 0f, finalRadius)
    animator.setInterpolator(AccelerateDecelerateInterpolator())
    animator.setDuration(300)
    animator.start()
}