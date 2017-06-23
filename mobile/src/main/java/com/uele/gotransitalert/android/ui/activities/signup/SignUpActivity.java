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

package com.uele.gotransitalert.android.ui.activities.signup;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.widget.Button;
import android.widget.EditText;

import com.uele.gotransitalert.android.R;
import com.uele.gotransitalert.android.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity
        extends BaseActivity implements SignUpAlertView {

    private static final String EXTRA_EDIT = "EDIT";

    @BindView(R.id.signUpBtn) Button signUpBtn;
    @BindView(R.id.signUpEmailEdt) EditText signUpEmailEdt;
    @BindView(R.id.signUpPasswordEdt) EditText signUpPasswordEdt;

    @Inject
    SignUpAlertPresenter<SignUpAlertView> mSignUpPresenter;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, SignUpActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mSignUpPresenter.onAttach(SignUpActivity.this);
    }

    @Override
    protected void setUp() {

    }

    public static void start(Activity activity, Boolean edit) {
        Intent starter = new Intent(activity, SignUpActivity.class);
        starter.putExtra(EXTRA_EDIT, edit);
        //noinspection unchecked
        ActivityCompat.startActivity(activity,
                starter,
                ActivityOptionsCompat.makeSceneTransitionAnimation(activity).toBundle());
    }

    @OnClick(R.id.signUpBtn)
    public void signUp(){

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
