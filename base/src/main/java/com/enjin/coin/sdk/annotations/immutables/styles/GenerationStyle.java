package com.enjin.coin.sdk.annotations.immutables.styles;

import org.immutables.value.Value;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation used by the immutable functionality.
 */
@Target({ElementType.PACKAGE, ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
@Value.Style(
        get = {"is*", "get*"},
        init = "set*",
        typeAbstract = "Abstract*",
        visibility = Value.Style.ImplementationVisibility.PUBLIC,
        optionalAcceptNullable = true,
        jdkOnly = true
)
public @interface GenerationStyle {

}
