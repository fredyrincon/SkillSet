package au.com.kamailio.skillset.backend.module;

import android.app.Application;
import android.content.res.Resources;

import javax.inject.Singleton;

import au.com.kamailio.skillset.base.DaggerApplication;
import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {
    private final DaggerApplication app;

    public MainModule(DaggerApplication application) {
        app = application;
    }

    @Provides
    @Singleton
    protected Application provideApplication() {
        return app;
    }

    @Provides
    @Singleton
    protected Resources provideResources() {
        return app.getResources();
    }
}