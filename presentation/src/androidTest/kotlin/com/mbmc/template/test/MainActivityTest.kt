package com.mbmc.template.test

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.mbmc.template.R
import com.mbmc.template.helper.nthChildOf
import com.mbmc.template.ui.MainActivity
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @Rule
    @JvmField
    val activity = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    fun testFields() {
        onView(withId(R.id.main_repo_btn)).check(matches(not(isEnabled())))
        onView(withId(R.id.main_repo_handle)).perform(typeText("testInput"))
        onView(withId(R.id.main_repo_btn)).check(matches(isEnabled()))
        onView(withId(R.id.main_repo_btn)).perform(click())
        onView(nthChildOf(withId(R.id.main_repo_list), 1))
            .check(matches(hasDescendant(withText("Repo 2"))))
    }
}