package com.uele.gotransitalert.android.ui.activities.search;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;

import com.uele.gotransitalert.android.R;
import com.uele.gotransitalert.android.ui.activities.splash.SplashActivity;
import com.uele.gotransitalert.android.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class SearchActivity
        extends BaseActivity implements SearchAlertView {

        @Inject
        SearchAlertPresenter<SearchAlertView> mSearchPresenter;

        public static Intent getStartIntent(Context context) {
                Intent intent = new Intent(context, SplashActivity.class);
                return intent;
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_search);
                getActivityComponent().inject(this);
                setUnBinder(ButterKnife.bind(this));
                mSearchPresenter.onAttach(SearchActivity.this);
        }
        @Override
        protected void setUp() {

        }

        @Override
        public void showMessage(String message) {

        }

        @Override
        public void showMessage(@StringRes int resId) {

        }

        @Override
        public void showOfflineMessage(boolean isCritical) {

        }

        @Override
        public void showErrorMessage(Throwable throwable) {

        }
}
