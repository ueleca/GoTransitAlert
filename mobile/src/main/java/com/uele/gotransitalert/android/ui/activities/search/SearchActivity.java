package com.uele.gotransitalert.android.ui.activities.search;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;

import com.uele.gotransitalert.android.R;
import com.uele.gotransitalert.android.ui.activities.splash.SplashActivity;
import com.uele.gotransitalert.android.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class SearchActivity
        extends BaseActivity implements SearchAlertView {

        private static final String EXTRA_EDIT = "EDIT";

        @Inject
        SearchAlertPresenter<SearchAlertView> mSearchPresenter;

        public static Intent getStartIntent(Context context) {
                Intent intent = new Intent(context, SplashActivity.class);
                return intent;
        }

        public static void start(Activity activity, Boolean edit) {
                Intent starter = new Intent(activity, SearchActivity.class);
                starter.putExtra(EXTRA_EDIT, edit);
                //noinspection unchecked
                ActivityCompat.startActivity(activity,
                        starter,
                        ActivityOptionsCompat.makeSceneTransitionAnimation(activity).toBundle());
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
}
