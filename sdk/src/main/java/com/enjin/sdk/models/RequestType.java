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

/**
 * Represents the transaction type when creating or updating a transaction.
 *
 * @see Request
 */
public enum RequestType {

    UNKNOWN,
    APPROVE,
    CREATE,
    MINT,
    SEND,
    SEND_ENJ,
    ADVANCED_SEND,
    CREATE_TRADE,
    COMPLETE_TRADE,
    CANCEL_TRADE,
    MELT,
    UPDATE_NAME,
    SET_ITEM_URI,
    SET_WHITELISTED,
    SET_TRANSFERABLE,
    SET_MELT_FEE,
    DECREASE_MAX_MELT_FEE,
    SET_TRANSFER_FEE,
    DECREASE_MAX_TRANSFER_FEE,
    RELEASE_RESERVE,
    ADD_LOG,
    SET_APPROVAL_FOR_ALL,
    MANAGER_UPDATE,
    SET_DECIMALS,
    SET_SYMBOL,
    MESSAGE,
    ACCEPT_ASSIGNMENT,
    ASSIGN,

}
