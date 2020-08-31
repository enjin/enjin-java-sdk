package com.enjin.sdk.events;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.enjin.sdk.models.EventType;

/**
 * Indicates the events to be filtered by the type. This annotation is intended to be used on the
 * {@link NotificationListener} class type.
 *
 * @author Evan Lindsay
 * @see NotificationListener
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EventFilter {

    /**
     * Event types used by the filter.
     *
     * @return the filtered types
     */
    EventType[] value();

    /**
     * Whether the filtered types are whitelisted or blacklisted.
     *
     * @return true if the types are handled, else types are ignored
     */
    boolean allow() default true;

}
