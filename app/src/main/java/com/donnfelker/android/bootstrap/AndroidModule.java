package com.donnfelker.android.bootstrap;

import android.accounts.AccountManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.view.inputmethod.InputMethodManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Module for all Android related provisions
 */
@Module
public class AndroidModule {

    @Provides
    @Singleton
    @ForApplication
    Context provideAppContext() {
        return BootstrapApplication.getInstance().getApplicationContext();
    }

    @Provides
    SharedPreferences provideDefaultSharedPreferences(@ForApplication final Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Provides
    PackageInfo providePackageInfo(@ForApplication final Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Provides
    TelephonyManager provideTelephonyManager(@ForApplication final Context context) {
        return getSystemService(context, Context.TELEPHONY_SERVICE);
    }

    @Provides
    InputMethodManager provideInputMethodManager(@ForApplication final Context context) {
        return getSystemService(context, Context.INPUT_METHOD_SERVICE);
    }

    @Provides
    ApplicationInfo provideApplicationInfo(@ForApplication final Context context) {
        return context.getApplicationInfo();
    }

    @Provides
    AccountManager provideAccountManager(@ForApplication final Context context) {
        return AccountManager.get(context);
    }

    @Provides
    ClassLoader provideClassLoader(@ForApplication final Context context) {
        return context.getClassLoader();
    }

    @Provides
    NotificationManager provideNotificationManager(@ForApplication final Context context) {
        return getSystemService(context, Context.NOTIFICATION_SERVICE);
    }

    @SuppressWarnings("unchecked")
    private <T> T getSystemService(Context context, String serviceConstant) {
        return (T) context.getSystemService(serviceConstant);
    }
}
