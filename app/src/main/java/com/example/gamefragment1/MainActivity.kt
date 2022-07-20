package com.example.gamefragment1

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

const val STATE_FRAGMENT = "state_of_fragment"

class MainActivity : AppCompatActivity() {
    private var mButton: Button? = null
    private var isFragmentDisplayed = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mButton = findViewById(R.id.open_button);


    }

    fun displayFragment() {
        val simpleFragment = SimpleFragment()
        supportFragmentManager.beginTransaction().apply {
            add(R.id.fragment_container, simpleFragment).addToBackStack(null).commit()
            mButton?.setText(R.string.close);
            isFragmentDisplayed = true
        }
        // TODO: Add the SimpleFragment.
    }

    fun closeFragment() {
        val simpleFragment = supportFragmentManager.findFragmentByTag("1") ?: return
        supportFragmentManager.beginTransaction().apply {
            hide(simpleFragment)
            mButton?.setText(R.string.open)
            isFragmentDisplayed = false
            commit()
        }
    }
}
