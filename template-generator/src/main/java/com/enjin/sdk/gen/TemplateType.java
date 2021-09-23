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

package com.enjin.sdk.gen;

public enum TemplateType {

    FRAGMENT,
    MUTATION,
    QUERY;

    public boolean matches(String token) {
        return token.toUpperCase().equals(name());
    }

    public static TemplateType fromKey(String name) {
        for (TemplateType type : values()) {
            if (name.toUpperCase().endsWith(type.name()))
                return type;
        }

        throw new RuntimeException(String.format("Could not find existing template type for file name: %s", name));
    }

}
