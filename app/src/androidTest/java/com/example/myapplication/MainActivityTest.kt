package com.example.myapplication

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Rule
    @JvmField
    val activityRule = ActivityTestRule(MainActivity::class.java)


    @Test
    fun recyclerViewCheck() {

        // click on specific item and print it's title

        Espresso.onView((withId(R.id.recycler_view))).perform(
            RecyclerViewActions.actionOnItemAtPosition<MoviesAdapter.MyViewHolder>(
                2,
                click()
            )
        )

        // Scroll until the last item on recyclerView List

        var recyclerView = activityRule.activity.findViewById<RecyclerView>(R.id.recycler_view)
        var itemCount = recyclerView.adapter!!.itemCount

        Espresso.onView(withId(R.id.recycler_view)).perform(
            RecyclerViewActions.scrollToPosition<MoviesAdapter.MyViewHolder>(
                itemCount.minus(1)
            )
        )


        //Check if a String in list of RecyclerView

        Espresso.onView(ViewMatchers.withId(R.id.recycler_view)).perform(
            RecyclerViewActions.actionOnItemAtPosition<MoviesAdapter.MyViewHolder>(
                5,
                click()
            )
        )
        val nameItem: String = "Mission: Impossible Rogue Nation"
        Espresso.onView(withText(nameItem)).check(matches(isDisplayed()))

    }
}