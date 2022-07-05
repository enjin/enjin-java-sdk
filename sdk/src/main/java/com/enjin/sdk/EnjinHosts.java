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

package com.enjin.sdk;

/**
 * The network hosts used by the Enjin Platform.
 */
public final class EnjinHosts {

    /**
     * The URL for the Enjin Platform on the main network.
     */
    public static final String MAIN_NET = "https://cloud.enjin.io/";

    /**
     * The URL for the Enjin Platform on the Goerli test network.
     */
    public static final String GOERLI = "https://goerli.cloud.enjin.io/";

    /**
     * The URL for the Enjin Platform on the JumpNet network.
     */
    public static final String JUMP_NET = "https://jumpnet.cloud.enjin.io/";

    private EnjinHosts() {
        throw new IllegalStateException("Utility class");
    }

}
