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
import android.support.annotation.StringRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.uele.gotransitalert.android.R;
import com.uele.gotransitalert.android.ui.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebViewFragment
        extends BaseFragment implements WebViewAlertView {

    @BindView(R.id.webview)
    WebView webView;

    @BindView(R.id.progress_bar)
    ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View fragmentView = inflater.inflate(R.layout.fragment_web, container, false);
        ButterKnife.bind(this, fragmentView);
        this.initWebView();
        return fragmentView;
    }

    private void initWebView() {
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int progress) {
                if (progress == 100) WebViewFragment.this.hideProgressBar();
            }
        });
        webView.loadUrl(((Listener)getActivity()).getUrl());
    }

    private void hideProgressBar() {
        this.progressBar.setVisibility(View.GONE);
    }

    public WebView getWebView() {
        return webView;
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

    @Override
    protected void setUp(View view) {

    }

    public interface Listener {
        String getUrl();
    }
}