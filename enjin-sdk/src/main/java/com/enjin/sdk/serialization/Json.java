package com.enjin.sdk.serialization;

import com.enjin.sdk.serialization.converter.JsonStringConverter;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Used to instruct the {@link JsonStringConverter}
 * that a parameter should be serialized to json format.
 *
 * @author Evan Lindsay
 * @see JsonStringConverter
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Json {
}
