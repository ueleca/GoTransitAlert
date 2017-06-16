package com.uele.gotransitalert.android.ui.activities.reset;

import com.uele.gotransitalert.android.di.scope.PerActivity;
import com.uele.gotransitalert.android.ui.base.AlertPresenter;

@PerActivity
public interface ResetAlertPresenter <V extends ResetAlertView> extends AlertPresenter<V> {
}

