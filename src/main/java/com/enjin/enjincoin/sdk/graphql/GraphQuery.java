package com.enjin.enjincoin.sdk.graphql;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Used to instruct the {@link com.enjin.enjincoin.sdk.serialization.converter.GraphConverter}
 * to use the template file that matches {@link GraphQuery#value()}.
 *
 * @author Evan Lindsay
 * @see GraphQLProcessor
 */
@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GraphQuery {

    /**
     * The name of the query template file.
     *
     * @return the value.
     */
    String value() default "";
}
