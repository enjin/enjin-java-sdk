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

/**
 * Fragment interface used to request certain information from players returned by the platform.
 *
 * @param <T> the type of the implementing class
 * @see com.enjin.sdk.models.Player
 */
public interface PlayerFragmentArguments<T extends WalletFragmentArguments<T>>
        extends WalletFragmentArguments<T> {

    /**
     * Sets the request to include the linking information with the player.
     *
     * @return this request for chaining
     * @see PlayerFragmentArguments#qrSize(Integer) 
     */
    default T withLinkingInfo() {
        return set("withLinkingInfo", true);
    }

    /**
     * Sets the desired size of the QR image in pixels. To be used with
     * {@link PlayerFragmentArguments#withLinkingInfo()}.
     *
     * @param size the size
     * @return this request for chaining
     */
    default T qrSize(Integer size) {
        return set("linkingCodeQrSize", size);
    }

    /**
     * Sets the request to include the wallet with the player.
     *
     * @return this request for chaining
     */
    default T withWallet() {
        return set("withPlayerWallet", true);
    }

}
