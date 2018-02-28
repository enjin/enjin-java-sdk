package io.enjincoin.sdk.client;

import com.enjin.java_commons.ObjectUtils;
import io.enjincoin.sdk.client.config.Config;
import io.enjincoin.sdk.client.service.events.EventsService;
import io.enjincoin.sdk.client.service.events.impl.EventsServiceImpl;
import io.enjincoin.sdk.client.service.identities.IdentitiesService;
import io.enjincoin.sdk.client.service.identities.impl.IdentitiesServiceImpl;
import io.enjincoin.sdk.client.service.notifications.NotificationsService;
import io.enjincoin.sdk.client.service.notifications.impl.NotificationsServiceImpl;
import io.enjincoin.sdk.client.service.platform.PlatformService;
import io.enjincoin.sdk.client.service.platform.impl.PlatformServiceImpl;
import io.enjincoin.sdk.client.service.tokens.TokensService;
import io.enjincoin.sdk.client.service.tokens.impl.TokensServiceImpl;
import io.enjincoin.sdk.client.service.transactionrequests.TransactionRequestsService;
import io.enjincoin.sdk.client.service.transactionrequests.impl.TransactionRequestsServiceImpl;

import java.util.logging.Logger;

/**
 * <p>Enjin Coin SyncClient - Synchronous.</p>
 * <p>All services will be instantiated from this class that will be called in a synchronous fashion.</p>
 */
public class ClientImpl implements Client {

    /**
     * Logger used by this class.
     */
    private static final Logger LOGGER = Logger.getLogger(ClientImpl.class.getName());

    /**
     * SDK configuration for this client.
     */
    private Config config;
    /**
     * Events create service.
     */
    private EventsService eventsService;
    /**
     * Identities create service.
     */
    private IdentitiesService identitiesService;
    /**
     * Tokens create service.
     */
    private TokensService tokensService;
    /**
     * TransactionRequests create service.
     */
    private TransactionRequestsService transactionRequestsService;

    /**
     * Notifications create service.
     */
    private NotificationsService notificationsService;

    /**
     * Platform create service.
     */
    private PlatformService platformService;

    /**
     * Class constructor.
     *
     * @param config - config to use
     */
    public ClientImpl(final Config config) {
        if (ObjectUtils.isNull(config)) {
            LOGGER.warning("The supplied config is null.");
            return;
        }

        this.config = config;
    }

    /**
     * Method to get the EventService.
     *
     * @return - SynchronousEventsService
     */
    @Override
    public EventsService getEventsService() {
        if (this.eventsService == null) {
            this.eventsService = new EventsServiceImpl(this.config);
        }
        return this.eventsService;
    }

    /**
     * Method to get the IdentitiesService.
     *
     * @return - IdentitiesService
     */
    @Override
    public IdentitiesService getIdentitiesService() {
        if (this.identitiesService == null) {
            this.identitiesService = new IdentitiesServiceImpl(this.config);
        }
        return this.identitiesService;
    }

    /**
     * Method to get the TokensService.
     *
     * @return - TokensService
     */
    @Override
    public TokensService getTokensService() {
        if (this.tokensService == null) {
            this.tokensService = new TokensServiceImpl(this.config);
        }
        return this.tokensService;
    }

    /**
     * Method to get the TransactionRequestsService.
     *
     * @return - TransactionRequestsService
     */
    @Override
    public TransactionRequestsService getTransactionRequestsService() {
        if (this.transactionRequestsService == null) {
            this.transactionRequestsService = new TransactionRequestsServiceImpl(this.config);
        }
        return this.transactionRequestsService;
    }

    /**
     * Method to get the notificationsService.
     *
     * @return NotificationsService
     */
    @Override
    public NotificationsService getNotificationsService() {
        if (this.notificationsService == null) {
            this.notificationsService = new NotificationsServiceImpl(this.config);
        }
        return this.notificationsService;
    }

    /**
     * Method to get the platformService.
     *
     * @return PlatformService
     */
    @Override
    public PlatformService getPlatformService() {
        if (this.platformService == null) {
            this.platformService = new PlatformServiceImpl(this.config);
        }
        return this.platformService;
    }

    @Override
    public void close() {
        if (this.notificationsService != null) {
            this.notificationsService.shutdown();
            this.notificationsService = null;
        }
    }
}
