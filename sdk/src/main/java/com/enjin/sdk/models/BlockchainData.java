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
 * Models the blockchain data of a {@link Transaction}.
 */
@EqualsAndHashCode
@Getter
public class BlockchainData {

    /**
     * -- Getter --
     * @return the encoded data of the transaction, ready for signing
     */
    private String encodedData;

    /**
     * -- Getter --
     * @return the signed string for the transaction
     */
    private String signedTransaction;

    /**
     * -- Getter --
     * @return the signed backup string for the transaction
     */
    private String signedBackupTransaction;

    /**
     * -- Getter --
     * @return the signed cancel string for the transaction
     */
    private String signedCancelTransaction;

    /**
     * -- Getter --
     * @return the receipt for the transaction
     */
    private TransactionReceipt receipt;

    /**
     * -- Getter --
     * @return the error message for the transaction
     */
    private String error;

    /**
     * -- Getter --
     * @return the nonce for the transaction
     */
    private String nonce;

}
