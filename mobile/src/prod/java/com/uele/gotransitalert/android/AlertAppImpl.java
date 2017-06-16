package com.uele.gotransitalert.android;

import timber.log.Timber;

public class AlertAppImpl
        extends AlertApp {
    @Override
    protected void init() {
        Timber.plant(new Timber.DebugTree());
    }

    @Override
    protected void onAfterInjection() {

    }
}
