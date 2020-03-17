package com.jsw.marvelheroes.Activitiy

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.jsw.marvelheroes.Fragment.ComicFragment
import com.jsw.marvelheroes.Fragment.DetailFragment
import com.jsw.marvelheroes.Fragment.HeroesFragment
import com.jsw.marvelheroes.Interfaces.IOnBackPressed
import com.jsw.marvelheroes.Model.Comic
import com.jsw.marvelheroes.Model.Hero
import com.jsw.marvelheroes.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        setSupportActionBar(toolbar)

        var fragment: Fragment? = HeroesFragment()

        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.add(R.id.nav_host_fragment, fragment, "HERO-COMIC")
            transaction.commit()
        }
    }

    override fun onBackPressed() {
        val count = supportFragmentManager.backStackEntryCount
        if (count == 0) {
            var fragment = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment)
            if(fragment is IOnBackPressed)
                if (!fragment.onBackPressed())
                    super.onBackPressed()
        } else {
            supportFragmentManager.popBackStack()
        }
    }

    fun openComicFragment(hero: Hero) {
        var fragment: Fragment? = ComicFragment(hero)

        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.nav_host_fragment, fragment)
            transaction.addToBackStack("HERO-COMIC")
            transaction.commit()
        }
    }

    fun openDetailsFragment(comic: Comic) {
        var fragment: Fragment? = DetailFragment(comic)

        if (fragment != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.nav_host_fragment, fragment)
            transaction.addToBackStack("COMIC-DETAILS")
            transaction.commit()
        }
    }
}