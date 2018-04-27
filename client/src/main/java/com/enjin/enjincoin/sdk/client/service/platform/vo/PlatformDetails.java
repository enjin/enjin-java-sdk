package com.enjin.enjincoin.sdk.client.service.platform.vo;

import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * Platform Details class
 * </p>
 */
public class PlatformDetails {

    @SerializedName("name")
    private String name;

    @SerializedName("id")
    private String id;


    /**
     * Class constructor.
     * @param name
     * @param id
     */
    public PlatformDetails(String name, String id) {
        super();
        this.name = name;
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "PlatformDetails [name=" + name + ", id=" + id + "]";
    }
}
