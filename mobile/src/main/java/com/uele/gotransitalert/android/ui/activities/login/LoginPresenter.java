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

package com.uele.gotransitalert.android.ui.activities.login;

import com.uele.gotransitalert.android.data.DataManager;
import com.uele.gotransitalert.android.ui.base.BasePresenter;
import com.uele.gotransitalert.android.utils.rx.SchedulerProvider;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;

public class LoginPresenter<V extends LoginAlertView> extends BasePresenter<V>
        implements LoginAlertPresenter<V> {

    private static final String TAG = LoginPresenter.class.getSimpleName();

    @Inject
    public LoginPresenter(DataManager dataManager,
                          SchedulerProvider schedulerProvider,
                          CompositeDisposable compositeDisposable) {
        super(dataManager, schedulerProvider, compositeDisposable);
    }

    @Override
    public void onServerLoginClick(String email, String password) {

    }
}




/*

void getFields(String u, String p){
        if(validUsername(u)){
            mLoginView.setHasInputEmailText();
            return;
        }

        if(validPassword(p)){
            mLoginView.setHasInputPasswordText();
            return;
        }
        mLoginView.showProgress();
    }

    private boolean validUsername(String username) {
        return !TextUtils.isEmpty(username);
    }

    private boolean validPassword(String username) {
        return !StringUtils.isValidPassword(username);
    }
 */