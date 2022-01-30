package com.enjin.sdk;

import java.util.EventListener;

/**
 * Listener interface to be used by platform clients to emit events related to authentication.
 */
public interface IAuthenticationListener extends EventListener {

    /**
     * Method to be invoked when a client's automatic reauthentication stops.
     */
    void onAutomaticReauthenticationStopped();

}
