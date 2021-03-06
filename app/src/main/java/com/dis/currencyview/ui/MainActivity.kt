package com.dis.currencyview.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.dis.currencyview.R
import com.dis.currencyview.ui.main.HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, HomeFragment.newInstance())
                .commitNow()
        }
    }
}