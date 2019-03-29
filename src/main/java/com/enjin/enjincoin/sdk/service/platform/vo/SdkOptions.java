package com.enjin.enjincoin.sdk.service.platform.vo;

import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Sdk Options class.
 * </p>
 */
public class SdkOptions {

    @SerializedName("cluster")
    private String cluster;

    @SerializedName("encrypted")
    private Boolean encrypted;

    public SdkOptions(final String cluster, final Boolean encrypted) {
        super();
        this.cluster = cluster;
        this.encrypted = encrypted;
    }

    /**
     * @return the cluster
     */
    public String getCluster() {
        return this.cluster;
    }

    /**
     * @return the encrypted
     */
    public Boolean getEncrypted() {
        return this.encrypted;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SdkOptions [cluster=" + this.cluster + ", encrypted=" + this.encrypted + "]";
    }
}
