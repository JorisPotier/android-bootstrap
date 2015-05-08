package com.donnfelker.android.bootstrap;

import com.donnfelker.android.bootstrap.authenticator.BootstrapAuthenticatorActivity;
import com.donnfelker.android.bootstrap.core.TimerService;
import com.donnfelker.android.bootstrap.ui.BootstrapActivity;
import com.donnfelker.android.bootstrap.ui.BootstrapFragmentActivity;
import com.donnfelker.android.bootstrap.ui.CheckInsListFragment;
import com.donnfelker.android.bootstrap.ui.MainActivity;
import com.donnfelker.android.bootstrap.ui.NavigationDrawerFragment;
import com.donnfelker.android.bootstrap.ui.NewsListFragment;
import com.donnfelker.android.bootstrap.ui.UserListFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                AndroidModule.class,
                BootstrapModule.class
        }
)
public interface Injector {

    /***************************/
    /** Activities injections **/
    /***************************/

    void inject(BootstrapAuthenticatorActivity bootstrapAuthenticatorActivity);

    void inject(BootstrapActivity bootstrapActivity);

    void inject(BootstrapFragmentActivity bootstrapFragmentActivity);

    void inject(MainActivity mainActivity);


    /**************************/
    /** Fragments injections **/
    /**************************/

    void inject(NewsListFragment newsListFragment);

    void inject(NavigationDrawerFragment navigationDrawerFragment);

    void inject(CheckInsListFragment checkInsListFragment);

    void inject(UserListFragment userListFragment);


    /*************************/
    /** Services injections **/
    /*************************/

    void inject(TimerService timerService);
}
