package com.enjin.sdk.models;

import com.google.gson.annotations.SerializedName;

import java.util.Collection;

/**
 * TODO
 */
public class PlayerFilter {

    private String id;
    @SerializedName("id_in")
    private Collection<String> idIn;
    private Collection<PlayerFilter> and;
    private Collection<PlayerFilter> or;

    /**
     * TODO
     * @param id
     * @return
     */
    public PlayerFilter id(String id) {
        this.id = id;
        return this;
    }

    /**
     * TODO
     * @param ids
     * @return
     */
    public PlayerFilter idIn(Collection<String> ids) {
        idIn = ids;
        return this;
    }

    /**
     * TODO
     * @param filters
     * @return
     */
    public PlayerFilter and(Collection<PlayerFilter> filters) {
        and = filters;
        return this;
    }

    /**
     * TODO
     * @param filters
     * @return
     */
    public PlayerFilter or(Collection<PlayerFilter> filters) {
        or = filters;
        return this;
    }

}
