package com.ujjwal.mobileShop

import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.filters.LargeTest
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@LargeTest
@RunWith(JUnit4::class)
class InstrumentedTest {
    @get:Rule
    val testRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testLoginUI(){
        onView(withId(R.id.etemail))
                .perform(typeText("sandy@gmail.com"))
        onView(withId(R.id.etpassword))
                .perform(typeText("ujjwal"))
        closeSoftKeyboard()

        onView(withId(R.id.btnLogin))
                .perform(click())
        Thread.sleep(4000)
        onView(withId(R.id.dashcontainer))
                .check(matches(isDisplayed()))
    }
}