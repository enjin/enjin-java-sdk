package com.enjin.enjincoin.sdk.client.service.platform.vo;

import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Platform Details class.
 * </p>
 */
public class PlatformDetails {

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private String id;

    public PlatformDetails(final String name, final String id) {
        super();
        this.name = name;
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return the id
     */
    public String getId() {
        return this.id;
    }

    /**
     * @param name the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * @param id the id to set
     */
    public void setId(final String id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PlatformDetails [name=" + this.name + ", id=" + this.id + "]";
    }
}
