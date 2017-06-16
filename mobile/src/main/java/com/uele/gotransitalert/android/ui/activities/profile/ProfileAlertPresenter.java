package com.uele.gotransitalert.android.ui.activities.profile;

import com.uele.gotransitalert.android.di.scope.PerActivity;
import com.uele.gotransitalert.android.ui.base.AlertPresenter;

@PerActivity
public interface ProfileAlertPresenter<V extends ProfileAlertView> extends AlertPresenter<V> {
}
