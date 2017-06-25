/*
 * Copyright (C) 2017 Uele, Inc.
 *
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

package com.uele.gotransitalert.android.ui.activities.signUp;

import com.uele.gotransitalert.android.data.DataManager;
import com.uele.gotransitalert.android.ui.activities.signup.SignUpAlertView;
import com.uele.gotransitalert.android.ui.activities.signup.SignUpPresenter;
import com.uele.gotransitalert.android.utils.rx.TestSchedulerProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.TestScheduler;

/**
 * Unit tests for the implementation of {@link SignUpPresenter}.
 */

@RunWith(MockitoJUnitRunner.class)
public class SignUpPresenterTest {

    @Mock
    SignUpAlertView mMockSignUpAlertView;

    @Mock
    DataManager mMockDataManager;

    private SignUpPresenter<SignUpAlertView> mSignUpPresenter;
    private TestScheduler mTestScheduler;

    @BeforeClass
    public static void onlyOnce() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        mTestScheduler = new TestScheduler();
        TestSchedulerProvider testSchedulerProvider = new TestSchedulerProvider(mTestScheduler);
        mSignUpPresenter = new SignUpPresenter<>(
                mMockDataManager,
                testSchedulerProvider,
                compositeDisposable);
        mSignUpPresenter.onAttach(mMockSignUpAlertView);
    }

    @Test
    public void testDestroy() {

    }

    @After
    public void tearDown() throws Exception {
        mSignUpPresenter.onDetach();
    }
}