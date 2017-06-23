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

package com.uele.gotransitalert.android.di.module;

import android.app.Application;
import android.content.Context;

import com.uele.gotransitalert.android.BuildConfig;
import com.uele.gotransitalert.android.R;
import com.uele.gotransitalert.android.data.AppDataManager;
import com.uele.gotransitalert.android.data.DataManager;
import com.uele.gotransitalert.android.data.db.AppDbHelper;
import com.uele.gotransitalert.android.data.db.DbHelper;
import com.uele.gotransitalert.android.data.network.ApiHeader;
import com.uele.gotransitalert.android.data.network.ApiHelper;
import com.uele.gotransitalert.android.data.network.AppApiHelper;
import com.uele.gotransitalert.android.data.prefs.AppPreferencesHelper;
import com.uele.gotransitalert.android.data.prefs.PreferencesHelper;
import com.uele.gotransitalert.android.di.ApiInfo;
import com.uele.gotransitalert.android.di.DatabaseInfo;
import com.uele.gotransitalert.android.di.PreferenceInfo;
import com.uele.gotransitalert.android.di.qualifier.ApplicationContext;
import com.uele.gotransitalert.android.utils.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

@Module
public class ApplicationModule {

    private final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }

    @Provides
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @DatabaseInfo
    String provideDatabaseName() {
        return AppConstants.DB_NAME;
    }

    @Provides
    @ApiInfo
    String provideApiKey() {
        return BuildConfig.API_KEY;
    }

    @Provides
    @PreferenceInfo
    String providePreferenceName() {
        return AppConstants.PREF_NAME;
    }

    @Provides
    @Singleton
    DataManager provideDataManager(AppDataManager appDataManager) {
        return appDataManager;
    }

    @Provides
    @Singleton
    DbHelper provideDbHelper(AppDbHelper appDbHelper) {
        return appDbHelper;
    }

    @Provides
    @Singleton
    PreferencesHelper providePreferencesHelper(AppPreferencesHelper appPreferencesHelper) {
        return appPreferencesHelper;
    }

    @Provides
    @Singleton
    ApiHelper provideApiHelper(AppApiHelper appApiHelper) {
        return appApiHelper;
    }

    @Provides
    @Singleton
    ApiHeader.ProtectedApiHeader provideProtectedApiHeader(@ApiInfo String apiKey,
                                                           PreferencesHelper preferencesHelper) {
        return new ApiHeader.ProtectedApiHeader(
                apiKey,
                preferencesHelper.getCurrentUserId(),
                preferencesHelper.getAccessToken());
    }

    @Provides
    @Singleton
    CalligraphyConfig provideCalligraphyDefaultConfig() {
        return new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/source-sans-pro/SourceSansPro-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build();
    }
}


/*

    @Provides
    @PerApplication
    InputMethodManager provideInputMethodManager(@ApplicationContext Context context) {
        return (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    @Provides
    @PerApplication
    SearchManager provideSearchManager(@ApplicationContext Context context) {
        return (SearchManager) context.getSystemService(Context.SEARCH_SERVICE);
    }

    @Provides
    @PerApplication
    static RealmConfiguration provideRealmConfiguration(@ApplicationContext Context context) {
        RealmConfiguration.Builder builder = new RealmConfiguration.Builder(context);
        if (BuildConfig.DEBUG) {
            builder = builder.deleteRealmIfMigrationNeeded();
        }
        return builder.build();
    }

    @Provides
    @PerApplication
    static Realm provideRealm(RealmConfiguration realmConfiguration) {
        return Realm.getInstance(realmConfiguration);
    }
 */