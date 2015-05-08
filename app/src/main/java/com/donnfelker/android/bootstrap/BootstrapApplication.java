

package com.donnfelker.android.bootstrap;

import android.app.Application;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;

/**
 * Android Bootstrap application
 */
public abstract class BootstrapApplication extends Application {

    private static BootstrapApplication instance;
    private static Injector injector;

    /**
     * Create main application
     */
    public BootstrapApplication() {
    }


    @Override
    public void onCreate() {
        super.onCreate();
        Fabric.with(this, new Crashlytics());

        init();

        instance = this;

        // Perform injection
        injector = DaggerInjector.create();

        onAfterInjection();
    }

    protected abstract void onAfterInjection();

    protected abstract void init();

    public static BootstrapApplication getInstance() {
        return instance;
    }

    public static Injector injector() {
        return injector;
    }
}
