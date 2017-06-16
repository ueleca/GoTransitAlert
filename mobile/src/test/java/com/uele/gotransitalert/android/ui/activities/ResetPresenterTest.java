package com.uele.gotransitalert.android.ui.activities;

import android.content.Context;

import com.uele.gotransitalert.android.ui.activities.reset.ResetAlertView;
import com.uele.gotransitalert.android.ui.activities.reset.ResetPresenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Unit tests for the implementation of {@link ResetPresenter}.
 */

@RunWith(MockitoJUnitRunner.class)
public class ResetPresenterTest {

    @Mock
    Context mContext;
    ResetAlertView mockResetPasswordView;
    ResetPresenter mResetPasswordPresenter;


    @Before
    public void setup() {

    }

    @Test
    public void testDestroy() {

    }

    @After
    public void tearDown() {

    }
}
