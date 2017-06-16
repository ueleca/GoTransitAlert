/*
 * Copyright 2016 Brian Donaldson
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

/*
 * Created by Brian Donaldson on 3/13/17.
 */

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;

import com.uele.gotransitalert.android.data.network.model.FeedResponse;
import com.uele.gotransitalert.android.di.qualifier.ActivityContext;
import com.uele.gotransitalert.android.di.scope.PerActivity;
import com.uele.gotransitalert.android.ui.activities.login.LoginAlertPresenter;
import com.uele.gotransitalert.android.ui.activities.login.LoginAlertView;
import com.uele.gotransitalert.android.ui.activities.login.LoginPresenter;
import com.uele.gotransitalert.android.ui.activities.main.MainAlertPresenter;
import com.uele.gotransitalert.android.ui.activities.main.MainAlertView;
import com.uele.gotransitalert.android.ui.activities.main.MainPresenter;
import com.uele.gotransitalert.android.ui.activities.profile.ProfileAlertPresenter;
import com.uele.gotransitalert.android.ui.activities.profile.ProfileAlertView;
import com.uele.gotransitalert.android.ui.activities.profile.ProfilePresenter;
import com.uele.gotransitalert.android.ui.activities.reset.ResetAlertPresenter;
import com.uele.gotransitalert.android.ui.activities.reset.ResetAlertView;
import com.uele.gotransitalert.android.ui.activities.reset.ResetPresenter;
import com.uele.gotransitalert.android.ui.activities.search.SearchAlertPresenter;
import com.uele.gotransitalert.android.ui.activities.search.SearchAlertView;
import com.uele.gotransitalert.android.ui.activities.search.SearchPresenter;
import com.uele.gotransitalert.android.ui.activities.settings.SettingsAlertPresenter;
import com.uele.gotransitalert.android.ui.activities.settings.SettingsAlertView;
import com.uele.gotransitalert.android.ui.activities.settings.SettingsPresenter;
import com.uele.gotransitalert.android.ui.activities.signup.SignUpAlertPresenter;
import com.uele.gotransitalert.android.ui.activities.signup.SignUpAlertView;
import com.uele.gotransitalert.android.ui.activities.signup.SignUpPresenter;
import com.uele.gotransitalert.android.ui.activities.splash.SplashAlertPresenter;
import com.uele.gotransitalert.android.ui.activities.splash.SplashAlertView;
import com.uele.gotransitalert.android.ui.activities.splash.SplashPresenter;
import com.uele.gotransitalert.android.ui.fragments.about.AboutAlertPresenter;
import com.uele.gotransitalert.android.ui.fragments.about.AboutAlertView;
import com.uele.gotransitalert.android.ui.fragments.about.AboutPresenter;
import com.uele.gotransitalert.android.ui.fragments.feed.FeedAdapter;
import com.uele.gotransitalert.android.ui.fragments.feed.FeedAlertPresenter;
import com.uele.gotransitalert.android.ui.fragments.feed.FeedAlertView;
import com.uele.gotransitalert.android.ui.fragments.feed.FeedPresenter;
import com.uele.gotransitalert.android.ui.fragments.setting.SettingAlertPresenter;
import com.uele.gotransitalert.android.ui.fragments.setting.SettingAlertView;
import com.uele.gotransitalert.android.ui.fragments.setting.SettingPresenter;
import com.uele.gotransitalert.android.utils.rx.AppSchedulerProvider;
import com.uele.gotransitalert.android.utils.rx.SchedulerProvider;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import io.reactivex.disposables.CompositeDisposable;

@Module
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return mActivity;
    }

    @Provides
    AppCompatActivity provideActivity() {
        return mActivity;
    }

    @Provides
    CompositeDisposable provideCompositeDisposable() {
        return new CompositeDisposable();
    }

    @Provides
    SchedulerProvider provideSchedulerProvider() {
        return new AppSchedulerProvider();
    }

    @Provides
    @PerActivity
    LoginAlertPresenter<LoginAlertView> provideLoginPresenter(LoginPresenter<LoginAlertView>
                                                                    presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    MainAlertPresenter<MainAlertView> provideMainPresenter(MainPresenter<MainAlertView>
                                                                 presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    ProfileAlertPresenter<ProfileAlertView> provideProfilePresenter(ProfilePresenter<ProfileAlertView>
                                                                   presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    ResetAlertPresenter<ResetAlertView> provideResetPresenter(ResetPresenter<ResetAlertView>
                                                                   presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    SearchAlertPresenter<SearchAlertView> provideSearchPresenter(SearchPresenter<SearchAlertView>
                                                                       presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    SettingsAlertPresenter<SettingsAlertView> provideSettingsPresenter(SettingsPresenter<SettingsAlertView>
                                                                             presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    SignUpAlertPresenter<SignUpAlertView> provideSignUpPresenter(SignUpPresenter<SignUpAlertView>
                                                                         presenter) {
        return presenter;
    }

    @Provides
    @PerActivity
    SplashAlertPresenter<SplashAlertView> provideSplashPresenter(SplashPresenter<SplashAlertView>
                                                                         presenter) {
        return presenter;
    }

    @Provides
    AboutAlertPresenter<AboutAlertView> provideAboutPresenter(AboutPresenter<AboutAlertView>
                                                                    presenter) {
        return presenter;
    }

    @Provides
    SettingAlertPresenter<SettingAlertView> provideSettingPresenter(SettingPresenter<SettingAlertView>
                                                                      presenter) {
        return presenter;
    }

    @Provides
    FeedAlertPresenter<FeedAlertView>
    provideFeedPresenter(FeedPresenter<FeedAlertView> presenter) {
        return presenter;
    }

    @Provides
    FeedAdapter provideFeedAdapter() {
        return new FeedAdapter(new ArrayList<FeedResponse.Blog>());
    }

    @Provides
    LinearLayoutManager provideLinearLayoutManager(AppCompatActivity activity) {
        return new LinearLayoutManager(activity);
    }
}

