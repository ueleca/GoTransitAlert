/*
 * Copyright 2016 Brian Donaldson
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.uele.gotransitalert.android.ui.activities.login;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.uele.gotransitalert.android.R;
import com.uele.gotransitalert.android.ui.activities.main.MainActivity;
import com.uele.gotransitalert.android.ui.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity
        extends BaseActivity implements LoginAlertView {

        private static final String EXTRA_EDIT = "EDIT";

        @BindView(R.id.loginBtn) Button btnLogin;
        @BindView(R.id.loginResetPasswordBtn) Button btnResetPassword;
        @BindView(R.id.loginSignUpBtn) Button btnSignUp;
       // @BindView(R.id.btn_facebook) Button btnFacebook;

        @BindView(R.id.loginEmailEdt) EditText inputEmail;
        @BindView(R.id.loginPasswordEdt) EditText inputPassword;

        @BindView(R.id.progressBar) ProgressBar progressBar;

        @Inject
        LoginAlertPresenter<LoginAlertView> mLoginPresenter;

        public static Intent getStartIntent(Context context) {
                Intent intent = new Intent(context, LoginActivity.class);
                return intent;
        }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_login);
                getActivityComponent().inject(this);
                setUnBinder(ButterKnife.bind(this));
                mLoginPresenter.onAttach(LoginActivity.this);
        }

        @Override
        protected void setUp() {

        }

        @Override
        public void openMainActivity() {
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();
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


        @Override
        public void showProgress() {
                progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        public void hideProgress() {
                progressBar.setVisibility(View.GONE);
        }

        @Override
        public String getInputEmailText() {
                return inputEmail.getText().toString();
        }

        @Override
        public String getInputPasswordText() {
                return inputPassword.getText().toString();
        }

        @Override
        public void setHasInputEmailText() {
                inputEmail.setError(getApplicationContext().getString(R.string.error_enter_email));
        }

        @Override
        public void setHasInputPasswordText() {
                inputPassword.setError(getApplicationContext().getString(R.string.error_enter_password));
        }

        public static void start(Activity activity, Boolean edit) {
                Intent starter = new Intent(activity, LoginActivity.class);
                starter.putExtra(EXTRA_EDIT, edit);
                //noinspection unchecked
                ActivityCompat.startActivity(activity,
                        starter,
                        ActivityOptionsCompat.makeSceneTransitionAnimation(activity).toBundle());
        }

        @OnClick(R.id.loginBtn)
        public void onLogin(){
              //  mLoginPresenter.getFields(getInputEmailText(), getInputPasswordText());
        }

        @OnClick(R.id.loginResetPasswordBtn)
        public void onReset(){

        }

        @OnClick(R.id.loginSignUpBtn)
        public void onSignUp(){

        }
}