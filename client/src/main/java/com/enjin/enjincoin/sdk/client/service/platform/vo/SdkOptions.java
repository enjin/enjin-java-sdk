package com.enjin.enjincoin.sdk.client.service.platform.vo;

import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Sdk Options class
 * </p>
 */
public class SdkOptions {

    @SerializedName("cluster")
    private String cluster;

    @SerializedName("encrypted")
    private Boolean encrypted;

    /**
     * Class constructor.
     * @param cluster
     * @param encrypted
     */
    public SdkOptions(String cluster, Boolean encrypted) {
        super();
        this.cluster = cluster;
        this.encrypted = encrypted;
    }

    /**
     * @return the cluster
     */
    public String getCluster() {
        return cluster;
    }

    /**
     * @return the encrypted
     */
    public Boolean getEncrypted() {
        return encrypted;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SdkOptions [cluster=" + cluster + ", encrypted=" + encrypted + "]";
    }
}
