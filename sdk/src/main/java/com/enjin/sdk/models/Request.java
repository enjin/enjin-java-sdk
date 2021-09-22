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

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Models a transaction on the platform.
 */
@EqualsAndHashCode
@Getter
public class Request {

    /**
     * -- Getter --
     * @return the ID of this transaction
     */
    private Integer id;

    /**
     * -- Getter --
     * @return the hash ID of this transaction
     */
    private String transactionId;

    /**
     * -- Getter --
     * @return the title of this transaction
     */
    private String title;

    /**
     * -- Getter --
     * @return the contract address
     */
    private String contract;

    /**
     * -- Getter --
     * @return the transaction type
     */
    private RequestType type;

    /**
     * -- Getter --
     * @return the value of this transaction
     */
    private String value;

    /**
     * -- Getter --
     * @return the retry state
     */
    private String retryState;

    /**
     * -- Getter --
     * @return the transaction state
     */
    private RequestState state;

    /**
     * -- Getter --
     * @return whether the transaction was accepted
     */
    private Boolean accepted;

    /**
     * -- Getter --
     * @return whether the wallet is a project wallet.
     */
    private Boolean projectWallet;

    /**
     * -- Getter --
     * @return the blockchain data of this transaction
     */
    private BlockchainData blockchainData;

    /**
     * -- Getter --
     * @return the project this transaction belongs to
     */
    private Project project;

    /**
     * -- Getter --
     * <br>
     * <p>
     *     Formatted as an ISO 8601 string.
     * </p>
     *
     * @return the datetime when this was created
     */
    private String createdAt;

    /**
     * -- Getter --
     * <br>
     * <p>
     *     Formatted as an ISO 8601 string.
     * </p>
     *
     * @return the datetime when this was last updated
     */
    private String updatedAt;

}
