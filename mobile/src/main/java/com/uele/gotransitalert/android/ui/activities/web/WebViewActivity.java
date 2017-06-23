/*
 * Copyright (C) 2017 Brian Donaldson
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

package com.uele.gotransitalert.android.ui.activities.web;

import android.os.Bundle;

import com.uele.gotransitalert.android.R;
import com.uele.gotransitalert.android.ui.base.BaseFragmentActivity;


public abstract class WebViewActivity
        extends BaseFragmentActivity implements WebViewFragment.Listener {

    @Override
    protected void initializeActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            addFragment(R.id.fragment_container, new WebViewFragment());
        }
    }
}
