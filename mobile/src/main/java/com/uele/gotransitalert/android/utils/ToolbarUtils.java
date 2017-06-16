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

package com.uele.gotransitalert.android.utils;

import android.support.v7.widget.Toolbar;

import com.uele.gotransitalert.android.R;
import com.uele.gotransitalert.android.ui.base.BaseActivity;

public class ToolbarUtils {
    public static void initToolbar(Toolbar toolbar, BaseActivity activity){
        if (toolbar == null || activity == null)
            return;
        toolbar.setBackgroundColor(activity.getColorPrimary());
        toolbar.setTitle(R.string.app_name);
        toolbar.setTitleTextColor(activity.getCompactColor(R.color.action_bar_title_color));
        toolbar.collapseActionView();
        activity.setSupportActionBar(toolbar);
        if (activity.getSupportActionBar() != null){
            activity.getSupportActionBar().setHomeAsUpIndicator(R.drawable.abc_ic_ab_back_material);
            activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }
}

