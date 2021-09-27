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

import com.google.gson.JsonObject;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

/**
 * Models a blockchain transaction log.
 */
@EqualsAndHashCode
@Getter
public class TransactionLog {

    /**
     * -- Getter --
     *
     * @return the block number
     */
    private Integer blockNumber;

    /**
     * -- Getter --
     *
     * @return the originating address
     */
    private String address;

    /**
     * -- Getter --
     *
     * @return the hash of the transaction
     */
    private String transactionHash;

    /**
     * -- Getter --
     *
     * @return the list of data objects
     */
    private List<JsonObject> data;

    /**
     * -- Getter --
     *
     * @return the list of topics
     */
    private List<JsonObject> topics;

    /**
     * -- Getter --
     *
     * @return the transaction event
     */
    private TransactionEvent event;

}
