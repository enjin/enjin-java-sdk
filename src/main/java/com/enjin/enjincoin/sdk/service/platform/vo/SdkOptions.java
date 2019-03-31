package com.enjin.enjincoin.sdk.service.platform.vo;

/**
 * <p>
 * Sdk Options class.
 * </p>
 */
public class SdkOptions {

    private String cluster;

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
