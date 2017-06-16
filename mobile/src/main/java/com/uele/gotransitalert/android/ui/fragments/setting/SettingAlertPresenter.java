package com.uele.gotransitalert.android.ui.fragments.setting;

import com.uele.gotransitalert.android.di.scope.PerActivity;
import com.uele.gotransitalert.android.ui.base.AlertPresenter;

@PerActivity
public interface SettingAlertPresenter<V extends SettingAlertView> extends AlertPresenter<V> {

}

