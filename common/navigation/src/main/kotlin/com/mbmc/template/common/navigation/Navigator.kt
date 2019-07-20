package com.mbmc.template.common.navigation

import android.content.Context
import android.content.Intent
import android.widget.Toast

object Navigator {
    private const val SEARCH = "com.mbmc.template.feature.search.presentation.ui.SearchActivity"
    private const val WEATHER = "com.mbmc.template.feature.weather.presentation.ui.WeatherActivity"

    fun goToSearch(context: Context) {
        goTo(context, SEARCH)
    }

    fun goToWeather(context: Context) {
        goTo(context, WEATHER)
    }

    private fun getIntent(context: Context, target: String): Intent? {
        try {
            Class.forName(target).run {
                return Intent(context, this)
            }
        } catch (e: Throwable) {
            return null
        }
    }

    private fun goTo(context: Context, target: String) {
        getIntent(context, target)
            ?.let {
                context.startActivity(it)
            } ?: run {
            Toast.makeText(context, R.string.not_installed, Toast.LENGTH_SHORT).show()
        }
    }
}