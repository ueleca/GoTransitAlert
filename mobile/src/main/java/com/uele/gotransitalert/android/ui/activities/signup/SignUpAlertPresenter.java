package com.uele.gotransitalert.android.ui.activities.signup;

import com.uele.gotransitalert.android.di.scope.PerActivity;
import com.uele.gotransitalert.android.ui.base.AlertPresenter;

@PerActivity
public interface SignUpAlertPresenter <V extends SignUpAlertView> extends AlertPresenter<V> {
}

