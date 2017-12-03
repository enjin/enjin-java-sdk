package com.enjin.coin.sdk.annotations.notifications;

import com.enjin.coin.sdk.enums.NotificationType;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EventFilter {

    /**
     * Filtered types to allow.
     *
     * @return NotifcationType[]
     */
    NotificationType[] value();

    boolean ignore() default false;

}
