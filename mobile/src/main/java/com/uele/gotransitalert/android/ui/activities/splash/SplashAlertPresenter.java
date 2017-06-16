package com.uele.gotransitalert.android.ui.activities.splash;

/*
 * Created by Brian Donaldson on 3/13/17.
 */

import com.uele.gotransitalert.android.di.scope.PerActivity;
import com.uele.gotransitalert.android.ui.base.AlertPresenter;

@PerActivity
public interface SplashAlertPresenter <V extends SplashAlertView> extends AlertPresenter<V> {
}
