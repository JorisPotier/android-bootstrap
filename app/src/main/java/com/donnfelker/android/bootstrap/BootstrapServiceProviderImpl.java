
package com.donnfelker.android.bootstrap;

import android.accounts.AccountsException;
import android.app.Activity;

import com.donnfelker.android.bootstrap.authenticator.ApiKeyProvider;
import com.donnfelker.android.bootstrap.core.BootstrapService;

import java.io.IOException;

/**
 * Provider for a {@link com.donnfelker.android.bootstrap.core.BootstrapService} instance
 */
public class BootstrapServiceProviderImpl implements BootstrapServiceProvider {

    private final BootstrapService bootstrapService;
    private final ApiKeyProvider keyProvider;

    public BootstrapServiceProviderImpl(BootstrapService bootstrapService, ApiKeyProvider keyProvider) {
        this.bootstrapService = bootstrapService;
        this.keyProvider = keyProvider;
    }

    /**
     * Get service for configured key provider
     * <p/>
     * This method gets an auth key and so it blocks and shouldn't be called on the main thread.
     *
     * @return bootstrap service
     * @throws IOException
     * @throws AccountsException
     */
    @Override
    public BootstrapService getService(final Activity activity)
            throws IOException, AccountsException {
        // The call to keyProvider.getAuthKey(...) is what initiates the login screen. Call that now.
        keyProvider.getAuthKey(activity);

        return bootstrapService;
    }
}
