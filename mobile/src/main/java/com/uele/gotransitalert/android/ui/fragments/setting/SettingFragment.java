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

package com.uele.gotransitalert.android.ui.fragments.setting;

import android.os.Bundle;
import android.support.annotation.StringRes;
import android.view.View;

import com.uele.gotransitalert.android.R;
import com.uele.gotransitalert.android.ui.base.BasePreferenceFragment;

import javax.inject.Inject;

public class SettingFragment
        extends BasePreferenceFragment implements SettingAlertView {

    public static final String TAG = "SettingsFragment";
    private static final String PREFERENCE_FILE_NAME = "gotransitalert.settings";

    @Inject
    SettingAlertPresenter<SettingAlertView> mSettingPresenter;

    public static SettingFragment newInstance() {
        Bundle args = new Bundle();
        SettingFragment fragment = new SettingFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void setUp(View view) {

    }

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        getActivityComponent().inject(this);
        addPreferencesFromResource(R.xml.settings);
        getPreferenceManager().setSharedPreferencesName(PREFERENCE_FILE_NAME);
        mSettingPresenter.onAttach(this);
    }

    @Override
    public void onDestroyView() {
        mSettingPresenter.onDetach();
        super.onDestroyView();
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