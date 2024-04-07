package com.corbin.msu.criminalintent

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CrimeDetailFragmentTest {

    @Test
    fun testCrimeDetailFragment() {
        // Launch the fragment
        val scenario: FragmentScenario<CrimeDetailFragment> = launchFragmentInContainer()

        // Use Espresso to find the CheckBox and EditText views and perform actions on them
        onView(withId(R.id.crime_solved)).perform(click())
        onView(withId(R.id.crime_title)).perform(typeText("New Crime Title"))

        // Verify that the Crime object has been updated correctly
        scenario.onFragment { fragment ->
            assertEquals(true, fragment.crime.isSolved)
            assertEquals("New Crime Title", fragment.crime.title)
        }
    }
}