/*
 * Copyright 2016 Brian Donaldson
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.uele.gotransitalert.android.ui.activities;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.uele.gotransitalert.android.R;
import com.uele.gotransitalert.android.ui.activities.signup.SignUpActivity;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class SignUpActivityTest {

    @Rule
    public ActivityTestRule<SignUpActivity> ActivityTestRule
            = new ActivityTestRule<>(SignUpActivity.class);

    @Before
    public void setUp() throws Exception {

    }

    /**
     * Tests sign up error scenario, perform sign up with empty fields
     * Checks for the visibility and text of error messages
     */
    @Test
    public void testSignUpErrorScenarioWithEmptyFields(){

        //Clear text email and password
        onView(withId(R.id.signUpEmailEdt)).perform(ViewActions.clearText());
        onView(withId(R.id.signUpPasswordEdt)).perform(ViewActions.clearText());

        //Click login button
        onView(withId(R.id.signUpBtn)).perform(ViewActions.click());

        //We should get an error label
        onView(withId(R.id.signUpEmailEdt))
                .check(matches(isDisplayed()))
                .check(matches(withText(R.string.authentication_sign_up_error_email_empty)));

        onView(withId(R.id.signUpPasswordEdt))
                .check(matches(isDisplayed()))
                .check(matches(withText(R.string.authentication_sign_up_error_password_empty)));
    }

    @After
    public void tearDown() throws Exception {

    }
}
