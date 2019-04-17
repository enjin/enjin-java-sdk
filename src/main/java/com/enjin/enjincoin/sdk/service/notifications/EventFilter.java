package com.enjin.enjincoin.sdk.service.notifications;

import com.enjin.enjincoin.sdk.model.service.notifications.NotificationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for filtering events.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EventFilter {

    /**
     * Filtered types to allow.
     *
     * @return NotifcationType[]
     */
    NotificationType[] value();

    /**
     * Allow or not.
     *
     * @return boolean
     */
    boolean allow() default true;

}
