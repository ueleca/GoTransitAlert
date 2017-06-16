package com.uele.gotransitalert.android;

import com.uele.gotransitalert.android.di.module.ApplicationModule;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface AlertComponent {
}