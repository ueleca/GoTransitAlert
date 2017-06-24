/*
 * Copyright (C) 2017 Uele, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.uele.gotransitalert.android.ui.activities.info;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;

import com.uele.gotransitalert.android.R;
import com.uele.gotransitalert.android.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class InfoActivity
        extends BaseActivity implements InfoAlertView {

    private static final String EXTRA_EDIT = "EDIT";

    @Inject
    InfoAlertPresenter<InfoAlertView> mInfoPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, InfoActivity.class);
        return intent;
    }

    public static void start(Activity activity, Boolean edit) {
        Intent starter = new Intent(activity, InfoActivity.class);
        starter.putExtra(EXTRA_EDIT, edit);
        //noinspection unchecked
        ActivityCompat.startActivity(activity,
                starter,
                ActivityOptionsCompat.makeSceneTransitionAnimation(activity).toBundle());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mInfoPresenter.onAttach(this);
        setUp();
    }

    @Override
    protected void setUp() {

    }
}
