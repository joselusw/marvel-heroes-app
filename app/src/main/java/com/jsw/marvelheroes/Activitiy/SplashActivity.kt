package com.jsw.marvelheroes.Activitiy

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.jsw.marvelheroes.Activitiy.HomeActivity
import com.jsw.marvelheroes.R

class SplashActivity : AppCompatActivity() {
    /* -- VARS --*/
    private val splashTime = 2000L // 3 seconds
    private lateinit var myHandler : Handler

    /* -- FUNCTIONS --*/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        myHandler = Handler()

        myHandler.postDelayed({
            goToMainActivity()
        },splashTime)
    }

    /**
     * Display the main activity and finish the current one
     */
    private fun goToMainActivity(){
        val mainActivityIntent = Intent(applicationContext, HomeActivity::class.java)
        startActivity(mainActivityIntent)
        finish()
    }
}