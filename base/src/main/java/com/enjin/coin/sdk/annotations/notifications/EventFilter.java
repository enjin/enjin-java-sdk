package com.enjin.coin.sdk.annotations.notifications;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.enjin.coin.sdk.enums.NotificationType;

/**
 * Annotation for filtering events.
 *
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
     * @return boolean
     */
    boolean allow() default true;

}
