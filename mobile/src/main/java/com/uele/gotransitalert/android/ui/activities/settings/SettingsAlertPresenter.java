package com.uele.gotransitalert.android.ui.activities.settings;

import com.uele.gotransitalert.android.di.scope.PerActivity;
import com.uele.gotransitalert.android.ui.base.AlertPresenter;

@PerActivity
public interface SettingsAlertPresenter<V extends SettingsAlertView> extends AlertPresenter<V> {
}
