/*
 * Copyright 2017 Brian Donaldson
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

package com.uele.gotransitalert.android.ui.base;

/*
 * Created by Brian Donaldson on 3/13/17.
 */

import com.androidnetworking.error.ANError;

public interface AlertPresenter<V extends AlertView> {
    void onAttach(V alertView);
    void onDetach();
    void handleApiError(ANError error);
    void setUserAsLoggedOut();
}