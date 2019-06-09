package com.enjin.enjincoin.sdk.service.notifications.impl;

import com.enjin.enjincoin.sdk.http.HttpResponse;
import com.enjin.enjincoin.sdk.graphql.GraphQLResponse;
import com.enjin.enjincoin.sdk.model.service.notifications.NotificationType;
import com.enjin.enjincoin.sdk.model.service.platform.PlatformDetails;
import com.enjin.enjincoin.sdk.service.notifications.EventMatcher;
import com.enjin.enjincoin.sdk.service.notifications.NotificationListener;
import com.enjin.enjincoin.sdk.service.notifications.NotificationListenerRegistration;
import com.enjin.enjincoin.sdk.service.notifications.NotificationsService;
import com.enjin.enjincoin.sdk.service.notifications.ThirdPartyNotificationService;
import com.enjin.enjincoin.sdk.service.platform.PlatformService;
import com.enjin.java_commons.BooleanUtils;
import com.enjin.java_commons.ObjectUtils;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class NotificationsServiceImpl implements NotificationsService {

    private static final Logger LOGGER = Logger.getLogger(NotificationsServiceImpl.class.getName());

    private ThirdPartyNotificationService          thirdPartyNotificationService;
    private List<NotificationListenerRegistration> notificationListeners = new ArrayList<>();
    private PlatformService                        service;
    private int                                    clientId;

    public NotificationsServiceImpl(PlatformService service, Integer clientId) {
        this.service = service;
        this.clientId = clientId;
    }

    @Override
    public boolean start() {

        //Call out to the reinitialize method in order to initialize the pusher notifications
        return this.restart();
    }

    @Override
    public boolean restart() {
        HttpResponse<GraphQLResponse<PlatformDetails>> result;
        try {
            result = this.service.getPlatformSync();
            if (result == null || result.body() == null) {
                LOGGER.warning("Failed to get platform details");
                return false;
            }

            GraphQLResponse<PlatformDetails> body = result.body();
            if (body == null || body.getData() == null) {
                LOGGER.warning("Failed to get platform details");
                return false;
            }

            PlatformDetails   details = body.getData();
            if (details == null) {
                LOGGER.warning("Platform details are null.");
                return false;
            }
            // Setup the thirdPartyNotificationService to use the pusher service.
            if (this.thirdPartyNotificationService == null) {
                this.thirdPartyNotificationService = new PusherNotificationServiceImpl(details, this.clientId);
            }

            boolean initPusherResult = this.thirdPartyNotificationService.init();
            if (BooleanUtils.isFalse(initPusherResult)) {
                LOGGER.warning("A problem occured initializing the pusher library");
                return false;
            }
        } catch (IOException e) {
            LOGGER.warning(String.format("An IOException has occured. Exception: %s.", e.getMessage()));
        }


        return true;
    }

    @Override
    public void shutdown() {
        if (this.thirdPartyNotificationService != null) {
            this.thirdPartyNotificationService.shutdown();
        }
    }

    @Override
    public NotificationListenerRegistration.RegistrationListenerConfiguration configureListener(NotificationListener listener) {
        return NotificationListenerRegistration.configure(this, listener);
    }

    @Override
    public synchronized NotificationListenerRegistration addNotificationListener(NotificationListener listener) {
        NotificationListenerRegistration registration = null;
        if (ObjectUtils.isNull(listener)) {
            LOGGER.warning("Could not add a NotificationListener because it was null.");
            return null;
        } else {
            long count = this.notificationListeners.stream().filter(r -> r.getListener() == listener).count();

            if (count == 0) {
                registration = NotificationListenerRegistration.configure(this, listener).register();
            } else {
                LOGGER.warning("Could not add a NotificationListener because it was already registered.");
            }
        }
        return registration;
    }

    @Override
    public NotificationListenerRegistration addNotificationListener(NotificationListener listener,
                                                                    EventMatcher eventMatcher) {
        return this.configureListener(listener).withMatcher(eventMatcher).register();
    }

    @Override
    public NotificationListenerRegistration addAllowedTypesNotificationListener(NotificationListener listener,
                                                                                NotificationType... allowed) {
        return this.configureListener(listener).withAllowedEvents(allowed).register();
    }

    @Override
    public NotificationListenerRegistration addIgnoredTypesNotificationListener(NotificationListener listener,
                                                                                NotificationType... ignored) {
        return this.configureListener(listener).withIgnoredEvents(ignored).register();
    }

    @Override
    public synchronized void removeNotificationListener(NotificationListener listener) {
        if (ObjectUtils.isNull(listener)) {
            LOGGER.warning("Could not remove a NotificationListener because it was null.");
            return;
        }

        List<NotificationListenerRegistration> matching =
                this.notificationListeners.stream()
                                          .filter(registration -> registration
                                                  .getListener() == listener)
                                          .collect(Collectors.toList());

        if (matching.size() > 0) {
            matching.forEach(this::removeNotificationListenerRegistration);
        } else {
            LOGGER.warning("Could not remove a NotificationListener because it wasn't already registered.");
        }
    }

    @Override
    public void addNotificationListenerRegistration(NotificationListenerRegistration registration) {
        if (registration != null) {
            this.notificationListeners.add(registration);
            this.thirdPartyNotificationService.setNotificationListeners(this.notificationListeners);
        } else {
            LOGGER.warning("Could not add a NotificationListenerRegistration because it was null.");
        }
    }

    @Override
    public void removeNotificationListenerRegistration(NotificationListenerRegistration registration) {
        if (registration != null) {
            this.notificationListeners.remove(registration);
            this.thirdPartyNotificationService.setNotificationListeners(this.notificationListeners);
        } else {
            LOGGER.warning("Could not add a NotificationListenerRegistration because it was null.");
        }
    }

    @Override
    public void listenForLink(BigInteger identityId) {
        this.thirdPartyNotificationService.listenForLink(identityId);
    }

    @Override
    public void stopListeningForLink(BigInteger identityId) {
        this.thirdPartyNotificationService.stopListeningForLink(identityId);
    }

    @Override
    public boolean isListeningForLink(BigInteger identityId) {
        return this.thirdPartyNotificationService.isListeningForLink(identityId);
    }

    @Override
    public void startAsync(CompletableFuture<Boolean> future) {
        this.restartAsync(future);
    }

    @Override
    public void restartAsync(CompletableFuture<Boolean> future) {
        this.service.getPlatformAsync(response -> {
            boolean result = false;
            if (response.body() != null) {
                GraphQLResponse<PlatformDetails> body = response.body();

                shutdown();

                PlatformDetails   details = body.getData();
                NotificationsServiceImpl.this.thirdPartyNotificationService =
                        new PusherNotificationServiceImpl(details,
                                                          NotificationsServiceImpl.this.clientId);
                result = NotificationsServiceImpl.this.thirdPartyNotificationService.init();
            } else {
                LOGGER.warning("An error occurred while retrieving platform details.");
            }
            future.complete(result);
        });
    }
}
