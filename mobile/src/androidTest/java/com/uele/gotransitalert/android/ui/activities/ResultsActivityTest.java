
package com.uele.gotransitalert.android.ui.activities;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.uele.gotransitalert.android.ui.activities.search.SearchActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class ResultsActivityTest {

    @Rule
    public ActivityTestRule<SearchActivity> activityTestRule
            = new ActivityTestRule<>(SearchActivity.class);

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }
}