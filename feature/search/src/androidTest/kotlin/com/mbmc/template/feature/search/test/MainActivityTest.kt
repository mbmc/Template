package com.mbmc.template.feature.search.test

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.mbmc.template.feature.search.R
import com.mbmc.template.feature.search.di.Injector
import com.mbmc.template.feature.search.di.module.TestApiModule
import com.mbmc.template.feature.search.helper.nthChildOf
import com.mbmc.template.feature.search.presentation.ui.MainActivity
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Rule
    @JvmField
    val activity = ActivityTestRule(MainActivity::class.java, false, false)

    @Test
    fun testFields() {
        Injector.setApiModule(TestApiModule())
        activity.launchActivity(null)
        onView(withId(R.id.main_repo_btn)).check(matches(not(isEnabled())))
        onView(withId(R.id.main_repo_handle)).perform(typeText("testInput"))
        onView(withId(R.id.main_repo_btn)).check(matches(isEnabled()))
        onView(withId(R.id.main_repo_btn)).perform(click())
        onView(nthChildOf(withId(R.id.main_repo_list), 1))
            .check(matches(hasDescendant(withText("Repo 2"))))
    }
}