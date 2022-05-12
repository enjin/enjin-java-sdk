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

package com.enjin.sdk.schemas.shared.arguments;

import com.enjin.sdk.graphql.VariableHolder;
import com.enjin.sdk.models.AssetIdFormat;

/**
 * Fragment interface used to request certain information from transactions returned by the platform.
 *
 * @param <T> the type of the implementing class
 *
 * @see com.enjin.sdk.models.Request
 */
public interface TransactionFragmentArguments<T extends VariableHolder<T>> extends VariableHolder<T> {

    /**
     * Sets the request to include the blockchain data with the transaction.
     *
     * @return this request for chaining
     *
     * @see TransactionFragmentArguments#withEncodedData()
     * @see TransactionFragmentArguments#withSignedTxs()
     * @see TransactionFragmentArguments#withReceipt()
     * @see TransactionFragmentArguments#withError()
     * @see TransactionFragmentArguments#withNonce()
     */
    default T withBlockchainData() {
        return set("withBlockchainData", true);
    }

    /**
     * Sets the request to include the metadata with the transaction.
     *
     * @return this request for chaining
     */
    default T withMeta() {
        return set("withMeta", true);
    }

    /**
     * Sets the request to include the encoded data with the transaction when used with
     * {@link TransactionFragmentArguments#withBlockchainData()}.
     *
     * @return this request for chaining
     */
    default T withEncodedData() {
        return set("withEncodedData", true);
    }

    /**
     * Sets the request to include the asset data with the transaction.
     *
     * @return this request for chaining
     *
     * @see TransactionFragmentArguments#assetIdFormat(AssetIdFormat)
     */
    default T withAssetData() {
        return set("withAssetData", true);
    }

    /**
     * Sets the request to include the signed transactions with the transaction when used with
     * {@link TransactionFragmentArguments#withBlockchainData()}.
     *
     * @return this request for chaining
     */
    default T withSignedTxs() {
        return set("withSignedTxs", true);
    }

    /**
     * Sets the request to include the error with the transaction when used with
     * {@link TransactionFragmentArguments#withBlockchainData()}.
     *
     * @return this request for chaining
     */
    default T withError() {
        return set("withError", true);
    }

    /**
     * Sets the request to include the nonce with the transaction when used with
     * {@link TransactionFragmentArguments#withBlockchainData()}.
     *
     * @return this request for chaining
     */
    default T withNonce() {
        return set("withNonce", true);
    }

    /**
     * Sets the request to include the state with the transaction when used with
     * {@link TransactionFragmentArguments#withBlockchainData()}.
     *
     * @return this request for chaining
     */
    default T withState() {
        return set("withState", true);
    }

    /**
     * Sets the request to include the receipt with the transaction when used with
     * {@link TransactionFragmentArguments#withBlockchainData()}.
     *
     * @return this request for chaining
     *
     * @see TransactionFragmentArguments#withReceiptLogs()
     */
    default T withReceipt() {
        return set("withReceipt", true);
    }

    /**
     * Sets the request to include the logs in the receipt when used with
     * {@link TransactionFragmentArguments#withReceipt()}.
     *
     * @return this request for chaining
     *
     * @see TransactionFragmentArguments#withLogEvent()
     */
    default T withReceiptLogs() {
        return set("withReceiptLogs", true);
    }

    /**
     * Sets the request to include the event data in the receipt logs when used with
     * {@link TransactionFragmentArguments#withReceiptLogs()}.
     *
     * @return this request for chaining
     */
    default T withLogEvent() {
        return set("withLogEvent", true);
    }

    /**
     * Sets the request to include the {@link com.enjin.sdk.models.Project} with its UUID that the transaction belongs
     * to.
     *
     * @return this request for chaining.
     */
    default T withTransactionProjectUuid() {
        return set("withTransactionProjectUuid", true);
    }

    /**
     * Sets the request to include the {@link com.enjin.sdk.models.Wallet} with its Ethereum address that belongs to the
     * transaction.
     *
     * @return this request for chaining.
     */
    default T withTransactionWalletAddress() {
        return set("withTransactionWalletAddress", true);
    }

    /**
     * Sets the desired asset ID format when used with {@link TransactionFragmentArguments#withAssetData()}.
     *
     * @param assetIdFormat the format
     *
     * @return this request for chaining
     */
    default T assetIdFormat(AssetIdFormat assetIdFormat) {
        return set("assetIdFormat", assetIdFormat);
    }

}
