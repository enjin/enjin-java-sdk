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

import com.enjin.sdk.models.BalanceFilter;

/**
 * Fragment interface used to request certain information from wallets returned by the platform.
 *
 * @param <T> the type of the implementing class
 *
 * @see com.enjin.sdk.models.Wallet
 */
public interface WalletFragmentArguments<T
        extends AssetFragmentArguments<T>
                & BalanceFragmentArguments<T>
                & TransactionFragmentArguments<T>>
        extends AssetFragmentArguments<T>,
        BalanceFragmentArguments<T>,
        TransactionFragmentArguments<T> {

    /**
     * Sets the balance filter to be used when used with when used with
     * {@link WalletFragmentArguments#withWalletBalances()}.
     *
     * @param filter the filter
     *
     * @return this request for chaining
     */
    default T walletBalanceFilter(BalanceFilter filter) {
        return set("walletBalanceFilter", filter);
    }

    /**
     * Sets the request to include the assets created by the wallet with the wallet.
     *
     * @return this request for chaining
     */
    default T withAssetsCreated() {
        return set("withAssetsCreated", true);
    }

    /**
     * Sets the request to include the asset balances with the wallet.
     *
     * @return this request for chaining
     *
     * @see WalletFragmentArguments#walletBalanceFilter
     */
    default T withWalletBalances() {
        return set("withWalletBalances", true);
    }

    /**
     * Sets the request to include the transactions signed by the wallet with the wallet.
     *
     * @return this request for chaining
     */
    default T withWalletTransactions() {
        return set("withWalletTransactions", true);
    }

}
