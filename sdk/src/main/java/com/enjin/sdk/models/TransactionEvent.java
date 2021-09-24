/* Copyright 2021 Enjin Pte Ltd.
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

import com.google.gson.JsonObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

/**
 * Models a blockchain transaction event.
 */
@EqualsAndHashCode
@Getter
public class TransactionEvent {

    /**
     * -- Getter --
     *
     * @return the name
     */
    private String name;

    /**
     * -- Getter --
     *
     * @return the parameters
     */
    private List<JsonObject> inputs;

    /**
     * -- Getter --
     *
     * @return the non-indexed parameters
     */
    private List<JsonObject> nonIndexedInputs;

    /**
     * -- Getter --
     *
     * @return the indexed parameters
     */
    private List<JsonObject> indexedInputs;

    /**
     * -- Getter --
     *
     * @return the event signature, or null if anonymous
     */
    private String signature;

    /**
     * -- Getter --
     *
     * @return the encoded signature
     */
    private String encodedSignature;

}
