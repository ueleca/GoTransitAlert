package com.uele.gotransitalert.android.ui.activities.login;

import com.uele.gotransitalert.android.di.scope.PerActivity;
import com.uele.gotransitalert.android.ui.base.AlertPresenter;

@PerActivity
public interface LoginAlertPresenter<V extends LoginAlertView> extends AlertPresenter<V> {
    void onServerLoginClick(String email, String password);
}