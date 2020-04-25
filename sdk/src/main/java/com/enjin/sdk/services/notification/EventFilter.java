package com.enjin.sdk.services.notification;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.enjin.sdk.models.notification.EventType;

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
    EventType[] value();

    /**
     * Whether the filtered types are whitelisted or blacklisted.
     *
     * @return true if the listener should only handle the filtered types, else types are ignored.
     */
    boolean allow() default true;

}
