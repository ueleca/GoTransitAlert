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

package com.uele.gotransitalert.android.di.component;

import com.uele.gotransitalert.android.di.module.ActivityModule;
import com.uele.gotransitalert.android.di.scope.PerActivity;
import com.uele.gotransitalert.android.ui.activities.about.AboutActivity;
import com.uele.gotransitalert.android.ui.activities.info.InfoActivity;
import com.uele.gotransitalert.android.ui.activities.login.LoginActivity;
import com.uele.gotransitalert.android.ui.activities.main.MainActivity;
import com.uele.gotransitalert.android.ui.activities.profile.ProfileActivity;
import com.uele.gotransitalert.android.ui.activities.reset.ResetActivity;
import com.uele.gotransitalert.android.ui.activities.search.SearchActivity;
import com.uele.gotransitalert.android.ui.activities.settings.SettingsActivity;
import com.uele.gotransitalert.android.ui.activities.signup.SignUpActivity;
import com.uele.gotransitalert.android.ui.activities.splash.SplashActivity;
import com.uele.gotransitalert.android.ui.fragments.feed.FeedFragment;
import com.uele.gotransitalert.android.ui.fragments.setting.SettingFragment;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(AboutActivity activity);
    void inject(InfoActivity activity);
    void inject(MainActivity activity);
    void inject(LoginActivity activity);
    void inject(SplashActivity activity);
    void inject(SignUpActivity activity);
    void inject(SearchActivity activity);
    void inject(ResetActivity activity);
    void inject(SettingsActivity activity);
    void inject(ProfileActivity activity);

    void inject(SettingFragment fragment);
    void inject(FeedFragment fragment);
}
