package com.uele.gotransitalert.android.di.component;

import com.uele.gotransitalert.android.di.module.ServiceModule;
import com.uele.gotransitalert.android.di.scope.PerService;
import com.uele.gotransitalert.android.service.SyncService;

import dagger.Component;

@PerService
@Component(dependencies = ApplicationComponent.class, modules = ServiceModule.class)
public interface ServiceComponent {
    void inject(SyncService service);
}
