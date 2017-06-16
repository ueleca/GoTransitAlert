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

package com.uele.gotransitalert.android.data.network;

/*
 * Created by Brian Donaldson on 3/13/17.
 */

import com.uele.gotransitalert.android.data.network.model.FeedResponse;
import com.uele.gotransitalert.android.data.network.model.LoginRequest;
import com.uele.gotransitalert.android.data.network.model.LoginResponse;
import com.uele.gotransitalert.android.data.network.model.LogoutResponse;

import io.reactivex.Observable;

public interface ApiHelper {

    ApiHeader getApiHeader();

    Observable<LoginResponse> doGoogleLoginApiCall(LoginRequest.GoogleLoginRequest request);

    Observable<LoginResponse> doFacebookLoginApiCall(LoginRequest.FacebookLoginRequest request);

    Observable<LoginResponse> doServerLoginApiCall(LoginRequest.ServerLoginRequest request);

    Observable<FeedResponse> getBlogApiCall();

    Observable<LogoutResponse> doLogoutApiCall();
}
