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

package com.enjin.sdk.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Models Pusher settings for the platform.
 */
@EqualsAndHashCode
@Getter
public class Pusher {

    /**
     * -- Getter --
     * @return the key for the platform
     */
    private String key;

    /**
     * -- Getter --
     * @return the namespace the platform broadcasts on
     */
    private String namespace;

    /**
     * -- Getter --
     * @return the channels the platform broadcasts on
     */
    private PusherChannels channels;

    /**
     * -- Getter --
     * @return the Pusher options the platform uses
     */
    private PusherOptions options;

}
