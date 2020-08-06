package com.enjin.sdk.models;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * TODO
 */
public class PlayerFilter extends Filter<PlayerFilter> {

    private String id;
    @SerializedName("id_in")
    private List<String> idIn;

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
    public PlayerFilter idIn(String... ids) {
        idIn = Arrays.asList(ids);
        return this;
    }

}
