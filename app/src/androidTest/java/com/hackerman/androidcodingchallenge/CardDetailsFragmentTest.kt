package com.hackerman.androidcodingchallenge
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.hackerman.androidcodingchallenge.ui.CardDetailsFragment
import com.hackerman.androidcodingchallenge.ui.HomeFragment
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CardDetailsFragmentTest{
    @Test
    fun test_fragment_is_displayed() {
        val scenario = launchFragmentInContainer<CardDetailsFragment>()
        Espresso.onView(ViewMatchers.withId(R.id.cardDetailsFragment)).check(matches(isDisplayed()))
    }

    @Test
    fun test_fragment_views_are_displayed() {
        val scenario = launchFragmentInContainer<HomeFragment>()
        Espresso.onView(ViewMatchers.withId(R.id.fragment_card_details_bankHeader_tv)).check(matches(isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.fragment_card_details_bankInfo_tv)).check(matches(isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.fragment_card_details_cardBrandHeader_tv)).check(matches(isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.fragment_card_details_cardBrandInfo_tv)).check(matches(isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.fragment_card_details_cardTypeHeader_tv)).check(matches(isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.fragment_card_details_countryHeader_tv)).check(matches(isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.fragment_card_details_countryInfo_tv)).check(matches(isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.fragment_card_details_cardTypeInfo_tv)).check(matches(isDisplayed()))
    }

}