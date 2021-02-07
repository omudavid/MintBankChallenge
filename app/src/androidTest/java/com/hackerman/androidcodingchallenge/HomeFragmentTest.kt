package com.hackerman.androidcodingchallenge

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.hackerman.androidcodingchallenge.ui.HomeFragment
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeFragmentTest{
    @Test
    fun test_fragment_is_displayed() {
        val scenario = launchFragmentInContainer<HomeFragment>()
        Espresso.onView(ViewMatchers.withId(R.id.homeFragment)).check(matches(isDisplayed()))
    }

    @Test
    fun test_fragment_views_are_displayed() {
        val scenario = launchFragmentInContainer<HomeFragment>()
        Espresso.onView(ViewMatchers.withId(R.id.fragment_home_background_img)).check(matches(isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.fragment_home_container_cv)).check(matches(isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.fragment_home_header_tv)).check(matches(isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.textInputLayout)).check(matches(isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.fragment_home_text_field)).check(matches(isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.fragment_home_submit_btn)).check(matches(isDisplayed()))
    }

}