package com.enjin.enjincoin.sdk.serialization;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Used to instruct the {@link com.enjin.enjincoin.sdk.serialization.converter.JsonStringConverter}
 * that a parameter should be serialized to json format.
 *
 * @author Evan Lindsay
 * @see com.enjin.enjincoin.sdk.serialization.converter.JsonStringConverter
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Json {
}
