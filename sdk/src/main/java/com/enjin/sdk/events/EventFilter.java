/* Copyright 2021 Enjin Pte. Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.enjin.sdk.events;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.enjin.sdk.models.EventType;

/**
 * Indicates the events to be filtered by the type. This annotation is intended to be used on classes implementing
 * {@link IEventListener}.
 *
 * @see IEventListener
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
