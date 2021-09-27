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

import java.util.List;

/**
 * Models a receipt for a blockchain transaction.
 */
@EqualsAndHashCode
@Getter
public class TransactionReceipt {

    /**
     * -- Getter --
     *
     * @return the hash of the block where the transaction is
     */
    private String blockHash;

    /**
     * -- Getter --
     *
     * @return the block number where the transaction is
     */
    private Integer blockNumber;

    /**
     * -- Getter --
     *
     * @return the total amount of gas used when the transaction was executed in the block
     */
    private Integer cumulativeGasUsed;

    /**
     * -- Getter --
     *
     * @return the gas used by the specific transaction alone
     */
    private Integer gasUsed;

    /**
     * -- Getter --
     *
     * @return the sender address
     */
    private String from;

    /**
     * -- Getter --
     *
     * @return the receiver address, or null when the transaction is for contract creation
     */
    private String to;

    /**
     * -- Getter --
     *
     * @return the hash of the transaction
     */
    private String transactionHash;

    /**
     * -- Getter --
     *
     * @return the transaction index position in the block
     */
    private Integer transactionIndex;

    /**
     * -- Getter --
     *
     * @return the status of the transaction
     */
    private Boolean status;

    /**
     * -- Getter --
     *
     * @return list of log objects generated by the transaction
     */
    private List<TransactionLog> logs;

}
