package com.enjin.enjincoin.sdk.graphql.api;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

public class Queries {

    // Identities
    public static final String CREATE_IDENTITY = "mutation createIdentity {\n" +
            "    CreateEnjinIdentity(%s) {\n" +
            "        id,\n" +
            "        app_id,\n" +
            "        ethereum_address,\n" +
            "        linking_code,\n" +
            "        linking_code_qr,\n" +
            "        fields {\n" +
            "            key,\n" +
            "            value\n" +
            "        },\n" +
            "        tokens {\n" +
            "            token_id,\n" +
            "            balance\n" +
            "        },\n" +
            "        eth_balance,\n" +
            "        enj_balance,\n" +
            "        enj_allowance,\n" +
            "        all_tokens_balance\n" +
            "    }\n" +
            "}";
    public static final String DELETE_IDENTITY = "mutation deleteIdentity {\n" +
            "    DeleteEnjinIdentity(%s){\n" +
            "        id,\n" +
            "        app_id,\n" +
            "        ethereum_address,\n" +
            "        linking_code,\n" +
            "        linking_code_qr,\n" +
            "        fields {\n" +
            "            key,\n" +
            "            value\n" +
            "        },\n" +
            "        tokens {\n" +
            "            token_id,\n" +
            "            balance\n" +
            "        },\n" +
            "        eth_balance,\n" +
            "        enj_balance,\n" +
            "        enj_allowance,\n" +
            "        all_tokens_balance\n" +
            "    }\n" +
            "}";
    public static final String GET_ALL_IDENTITIES = "query getAllIdentities {\n" +
            "    EnjinIdentities {\n" +
            "        id,\n" +
            "        app_id,\n" +
            "        ethereum_address,\n" +
            "        linking_code,\n" +
            "        linking_code_qr,\n" +
            "        fields {\n" +
            "            key,\n" +
            "            value\n" +
            "        },\n" +
            "        tokens {\n" +
            "            token_id,\n" +
            "            balance\n" +
            "        },\n" +
            "        eth_balance,\n" +
            "        enj_balance,\n" +
            "        enj_allowance,\n" +
            "        all_tokens_balance\n" +
            "    }\n" +
            "}";
    public static final String GET_IDENTITIES = "query getIdentities {\n" +
            "    EnjinIdentities(%s) {\n" +
            "        id,\n" +
            "        app_id,\n" +
            "        ethereum_address,\n" +
            "        linking_code,\n" +
            "        linking_code_qr,\n" +
            "        fields {\n" +
            "            key,\n" +
            "            value\n" +
            "        },\n" +
            "        tokens {\n" +
            "            token_id,\n" +
            "            balance\n" +
            "        },\n" +
            "        eth_balance,\n" +
            "        enj_balance,\n" +
            "        enj_allowance,\n" +
            "        all_tokens_balance\n" +
            "    }\n" +
            "}";
    public static final String UPDATE_IDENTITY = "mutation updateIdentity {\n" +
            "    UpdateEnjinIdentity(%s) {\n" +
            "        id,\n" +
            "        app_id,\n" +
            "        ethereum_address,\n" +
            "        linking_code,\n" +
            "        linking_code_qr,\n" +
            "        fields {\n" +
            "            key,\n" +
            "            value\n" +
            "        },\n" +
            "        tokens {\n" +
            "            token_id,\n" +
            "            balance\n" +
            "        },\n" +
            "        eth_balance,\n" +
            "        enj_balance,\n" +
            "        enj_allowance,\n" +
            "        all_tokens_balance\n" +
            "    }\n" +
            "}";

    // Platform
    public static final String GET_PLATFORM = "query getPlatform {\n" +
            "    EnjinPlatform {\n" +
            "        name,\n" +
            "        id,\n" +
            "        network,\n" +
            "        notifications\n" +
            "    }\n" +
            "}";

    // Requests
    public static final String CREATE_REQUEST = "mutation createRequest {\n" +
            "    CreateEnjinRequest(%s) {\n" +
            "        id,\n" +
            "        transaction_id,\n" +
            "        app_id,\n" +
            "        identity_id,\n" +
            "        type,\n" +
            "        recipient_id,\n" +
            "        recipient_address,\n" +
            "        token_id,\n" +
            "        encoded_data,\n" +
            "        signed_transaction,\n" +
            "        signed_backup_transaction,\n" +
            "        signed_cancel_transaction,\n" +
            "        nonce,\n" +
            "        retry_state,\n" +
            "        state,\n" +
            "        accepted\n" +
            "    }\n" +
            "}";
    public static final String GET_ALL_REQUESTS = "query getAllRequests {\n" +
            "    EnjinTransactions {\n" +
            "        id,\n" +
            "        transaction_id,\n" +
            "        app_id,\n" +
            "        identity_id,\n" +
            "        type,\n" +
            "        recipient_id,\n" +
            "        recipient_address,\n" +
            "        token_id,\n" +
            "        encoded_data,\n" +
            "        signed_transaction,\n" +
            "        signed_backup_transaction,\n" +
            "        signed_cancel_transaction,\n" +
            "        nonce,\n" +
            "        retry_state,\n" +
            "        state,\n" +
            "        accepted\n" +
            "    }\n" +
            "}";
    public static final String GET_REQUESTS = "query getRequests {\n" +
            "    EnjinTransactions(%s) {\n" +
            "        id,\n" +
            "        transaction_id,\n" +
            "        app_id,\n" +
            "        identity_id,\n" +
            "        type,\n" +
            "        recipient_id,\n" +
            "        recipient_address,\n" +
            "        token_id,\n" +
            "        encoded_data,\n" +
            "        signed_transaction,\n" +
            "        signed_backup_transaction,\n" +
            "        signed_cancel_transaction,\n" +
            "        nonce,\n" +
            "        retry_state,\n" +
            "        state,\n" +
            "        accepted\n" +
            "    }\n" +
            "}";
    public static final String UPDATE_REQUEST = "mutation updateRequest {\n" +
            "    UpdateEnjinRequest(%s) {\n" +
            "        id,\n" +
            "        transaction_id,\n" +
            "        app_id,\n" +
            "        identity_id,\n" +
            "        type,\n" +
            "        recipient_id,\n" +
            "        recipient_address,\n" +
            "        token_id,\n" +
            "        encoded_data,\n" +
            "        signed_transaction,\n" +
            "        signed_backup_transaction,\n" +
            "        signed_cancel_transaction,\n" +
            "        nonce,\n" +
            "        retry_state,\n" +
            "        state,\n" +
            "        accepted\n" +
            "    }\n" +
            "}";

    // Tokens
    public static final String GET_ALL_TOKENS = "query getAllTokens {\n" +
            "    EnjinTokens {\n" +
            "        token_id\n" +
            "        app_id\n" +
            "        name\n" +
            "        creator\n" +
            "        meltValue,\n" +
            "        meltFeeRatio,\n" +
            "        meltFeeMaxRatio,\n" +
            "        supplyModel,\n" +
            "        totalSupply,\n" +
            "        circulatingSupply,\n" +
            "        reserve,\n" +
            "        transferable,\n" +
            "        transferFeeSettings {\n" +
            "            type\n" +
            "            token_id\n" +
            "            value\n" +
            "        },\n" +
            "        nonFungible,\n" +
            "        firstBlock,\n" +
            "        blockHeight,\n" +
            "        markedForDelete,\n" +
            "        balance,\n" +
            "        index,\n" +
            "        icon\n" +
            "    }\n" +
            "}";
    public static final String GET_TOKENS = "query getTokens {\n" +
            "    EnjinTokens(%s) {\n" +
            "        token_id\n" +
            "        app_id\n" +
            "        name\n" +
            "        creator\n" +
            "        meltValue,\n" +
            "        meltFeeRatio,\n" +
            "        meltFeeMaxRatio,\n" +
            "        supplyModel,\n" +
            "        totalSupply,\n" +
            "        circulatingSupply,\n" +
            "        reserve,\n" +
            "        transferable,\n" +
            "        transferFeeSettings {\n" +
            "            type\n" +
            "            token_id\n" +
            "            value\n" +
            "        },\n" +
            "        nonFungible,\n" +
            "        firstBlock,\n" +
            "        blockHeight,\n" +
            "        markedForDelete,\n" +
            "        balance,\n" +
            "        index,\n" +
            "        availableToMint,\n" +
            "        itemURI,\n" +
            "        icon\n" +
            "    }\n" +
            "}";
    public static final String IMPORT_TOKEN = "mutation importToken {\n" +
            "    CreateEnjinToken(%s) {\n" +
            "        token_id\n" +
            "        app_id\n" +
            "        name\n" +
            "        creator\n" +
            "        meltValue,\n" +
            "        meltFeeRatio,\n" +
            "        meltFeeMaxRatio,\n" +
            "        supplyModel,\n" +
            "        totalSupply,\n" +
            "        circulatingSupply,\n" +
            "        reserve,\n" +
            "        transferable,\n" +
            "        transferFeeSettings {\n" +
            "            type\n" +
            "            token_id\n" +
            "            value\n" +
            "        },\n" +
            "        nonFungible,\n" +
            "        firstBlock,\n" +
            "        blockHeight,\n" +
            "        markedForDelete,\n" +
            "        balance,\n" +
            "        index,\n" +
            "        availableToMint,\n" +
            "        itemURI,\n" +
            "        icon\n" +
            "    }\n" +
            "}";
    public static final String UPDATE_TOKEN = "mutation updateToken {\n" +
            "    UpdateEnjinToken(%s) {\n" +
            "        token_id\n" +
            "        app_id\n" +
            "        name\n" +
            "        creator\n" +
            "        meltValue,\n" +
            "        meltFeeRatio,\n" +
            "        meltFeeMaxRatio,\n" +
            "        supplyModel,\n" +
            "        totalSupply,\n" +
            "        circulatingSupply,\n" +
            "        reserve,\n" +
            "        transferable,\n" +
            "        transferFeeSettings {\n" +
            "            type\n" +
            "            token_id\n" +
            "            value\n" +
            "        },\n" +
            "        nonFungible,\n" +
            "        firstBlock,\n" +
            "        blockHeight,\n" +
            "        markedForDelete,\n" +
            "        balance,\n" +
            "        index,\n" +
            "        availableToMint,\n" +
            "        itemURI,\n" +
            "        icon\n" +
            "    }\n" +
            "}";

    public static Map<String, String> getQueryMap() {
        Map<String, String> queryMap = new HashMap<>();
        for (Field field : Queries.class.getDeclaredFields()) {
            if (field.getType() == String.class && Modifier.isPublic(field.getModifiers())
                    && Modifier.isStatic(field.getModifiers())
                    && Modifier.isFinal(field.getModifiers())) {
                try {
                    queryMap.put(field.getName(), (String) field.get(null));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return queryMap;
    }

}
