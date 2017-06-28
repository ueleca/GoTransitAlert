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

package com.uele.gotransitalert.android;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.interceptors.HttpLoggingInterceptor.Level;
import com.uele.gotransitalert.android.data.DataManager;
import com.uele.gotransitalert.android.di.component.ApplicationComponent;
import com.uele.gotransitalert.android.di.component.DaggerApplicationComponent;
import com.uele.gotransitalert.android.di.module.ApplicationModule;
import com.uele.gotransitalert.android.utils.AlertLogger;

import javax.inject.Inject;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public abstract class AlertApp
        extends Application {

    private ApplicationComponent mApplicationComponent;

    @Inject
    DataManager mDataManager;

    @Inject
    CalligraphyConfig mCalligraphyConfig;

    public AlertApp() {}

    @Override
    public void onCreate() {
        super.onCreate();

        init();
        initializeInjector();

        AlertLogger.init();
        AndroidNetworking.initialize(getApplicationContext());

        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(Level.BODY);
        }

        CalligraphyConfig.initDefault(mCalligraphyConfig);

        onAfterInjection();
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    // Needed to replace the component with a test
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }

    private void initializeInjector() {
        if (mApplicationComponent == null) {
            mApplicationComponent = DaggerApplicationComponent.builder()
                    .applicationModule(new ApplicationModule(this)).build();
            mApplicationComponent.inject(this);
        }
    }

    protected abstract void init();
    protected abstract void onAfterInjection();
}
