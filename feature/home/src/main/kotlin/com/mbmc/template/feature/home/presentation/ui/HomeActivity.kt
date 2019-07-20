package com.mbmc.template.feature.home.presentation.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.mbmc.template.feature.home.R
import com.mbmc.template.common.navigation.Navigator

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        findViewById<View>(R.id.home_search).setOnClickListener {
            Navigator.goToSearch(this)
        }

        findViewById<View>(R.id.home_weather).setOnClickListener {
            Navigator.goToWeather(this)
        }
    }
}