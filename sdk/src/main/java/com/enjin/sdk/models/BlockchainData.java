package com.enjin.sdk.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Models the blockchain data of a {@link Request}.
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
