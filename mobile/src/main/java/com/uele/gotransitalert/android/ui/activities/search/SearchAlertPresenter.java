package com.uele.gotransitalert.android.ui.activities.search;

import com.uele.gotransitalert.android.di.scope.PerActivity;
import com.uele.gotransitalert.android.ui.base.AlertPresenter;

@PerActivity
public interface SearchAlertPresenter  <V extends SearchAlertView> extends AlertPresenter<V> {
}
