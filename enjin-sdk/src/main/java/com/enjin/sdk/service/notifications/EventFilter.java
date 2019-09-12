package com.enjin.sdk.service.notifications;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.enjin.sdk.model.service.notifications.NotificationType;

/**
 * Annotation for filtering listener events.
 *
 * @author Evan Lindsay
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EventFilter {

    /**
     * Filtered types to allow.
     *
     * @return the filtered notification types.
     */
    NotificationType[] value();

    /**
     * Whether the filtered types are whitelisted or blacklisted.
     *
     * @return true if the listener should only handle the filtered types, else types are ignored.
     */
    boolean allow() default true;

}
