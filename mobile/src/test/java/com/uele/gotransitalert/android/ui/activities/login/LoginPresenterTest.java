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

package com.uele.gotransitalert.android.ui.activities.login;

import com.uele.gotransitalert.android.data.DataManager;
import com.uele.gotransitalert.android.data.network.model.LoginRequest;
import com.uele.gotransitalert.android.data.network.model.LoginResponse;
import com.uele.gotransitalert.android.utils.rx.TestSchedulerProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.TestScheduler;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    public static final String VALID_PASSWORD = "123456";
    public static final String INVALID_PASSWORD = "12345";
    public static final String LONG_PASSWORD = "12345678912345678912";
    public static final String USERNAME = "Derp";
    public static final String INVALID_EMAIL = "userexample.com";
    public static final String VALID_EMAIL = "user@example.com";

    @Mock
    LoginAlertView mMockLoginAlertView;

    @Mock
    DataManager mMockDataManager;

    private LoginPresenter<LoginAlertView> mLoginPresenter;
    private TestScheduler mTestScheduler;

    @BeforeClass
    public static void onlyOnce() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        mTestScheduler = new TestScheduler();
        TestSchedulerProvider testSchedulerProvider = new TestSchedulerProvider(mTestScheduler);
        mLoginPresenter = new LoginPresenter<>(
                mMockDataManager,
                testSchedulerProvider,
                compositeDisposable);
        mLoginPresenter.onAttach(mMockLoginAlertView);
    }

    @Test
    public void testServerLoginSuccess() {

        LoginResponse loginResponse = new LoginResponse();

        doReturn(Observable.just(loginResponse))
                .when(mMockDataManager)
                .doServerLoginApiCall(new LoginRequest
                        .ServerLoginRequest(VALID_EMAIL, VALID_PASSWORD));

        mLoginPresenter.onServerLoginClick(VALID_EMAIL, VALID_PASSWORD);

        verify(mMockLoginAlertView).showLoading();
        verify(mMockLoginAlertView).hideLoading();
        verify(mMockLoginAlertView).openMainActivity();
    }
/*
    @Test
    public void whenLogInAuthSucceeds() throws Exception {
      //  when(mMockLoginAlertView.getEmail()).thenReturn(VALID_EMAIL);
       // when(mMockLoginAlertView.getPassword()).thenReturn(VALID_PASSWORD);
        mLoginPresenter.onServerLoginClick(VALID_EMAIL, VALID_PASSWORD);
        verify(mMockLoginAlertView).openMainActivity();
    }

    @Test
    public void whenEmailEmpty() throws Exception {
        when(mMockLoginAlertView.getInputEmailText()).thenReturn("");
        when(mMockLoginAlertView.getInputPasswordText()).thenReturn(VALID_PASSWORD);
        mLoginPresenter.onServerLoginClick("", VALID_PASSWORD);
        verify(mMockLoginAlertView).onError(R.string.error_empty_input);
    }

    @Test
    public void whenEmailInvalid() throws Exception {
        when(mMockLoginAlertView.getInputEmailText()).thenReturn(INVALID_EMAIL);
        when(mMockLoginAlertView.getInputPasswordText()).thenReturn(VALID_PASSWORD);
        mLoginPresenter.onServerLoginClick(VALID_EMAIL, VALID_PASSWORD);
        verify(mMockLoginAlertView).onError(R.string.error_invalid_email);
    }

    @Test
    public void whenPasswordEmpty() throws Exception {
        when(mMockLoginAlertView.getInputEmailText()).thenReturn(VALID_EMAIL);
        when(mMockLoginAlertView.getInputPasswordText()).thenReturn("");
        mLoginPresenter.onServerLoginClick(VALID_EMAIL, VALID_PASSWORD);
        verify(mMockLoginAlertView).onError(R.string.error_empty_input);
    }

    @Test
    public void whenPasswordTooLong() throws Exception {
        when(mMockLoginAlertView.getInputEmailText()).thenReturn(VALID_EMAIL);
        when(mMockLoginAlertView.getInputPasswordText()).thenReturn(LONG_PASSWORD);
        mLoginPresenter.onServerLoginClick(VALID_EMAIL, VALID_PASSWORD);
        verify(mMockLoginAlertView).onError(R.string.error_password_too_long);
    }
*/
    @After
    public void tearDown() throws Exception {
        mLoginPresenter.onDetach();
    }
}