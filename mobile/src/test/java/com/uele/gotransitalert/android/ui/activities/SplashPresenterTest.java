/*
 * Copyright 2016 Brian Donaldson
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.uele.gotransitalert.android.ui.activities;

import com.uele.gotransitalert.android.ui.activities.splash.SplashAlertView;
import com.uele.gotransitalert.android.ui.activities.splash.SplashPresenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Unit tests for the implementation of {@link SplashPresenter}.
 */

@RunWith(MockitoJUnitRunner.class)
public class SplashPresenterTest {


    @Mock
    SplashAlertView mockSplashView;
    SplashPresenter mSplashPresenter;

    @Before
    public void setup() throws Exception {

    }

    @Test
    public void testDestroy() {

    }

    @After
    public void tearDown() {

    }
}