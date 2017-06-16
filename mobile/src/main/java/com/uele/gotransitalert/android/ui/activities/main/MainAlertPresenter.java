package com.uele.gotransitalert.android.ui.activities.main;

import com.uele.gotransitalert.android.di.scope.PerActivity;
import com.uele.gotransitalert.android.ui.base.AlertPresenter;

@PerActivity
public interface MainAlertPresenter<V extends MainAlertView> extends AlertPresenter<V> {
}
