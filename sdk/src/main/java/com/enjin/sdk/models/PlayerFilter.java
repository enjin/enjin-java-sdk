package com.enjin.sdk.models;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;

/**
 * Models a filter input for player queries.
 *
 * @see com.enjin.sdk.schemas.project.queries.GetPlayers
 */
public class PlayerFilter extends Filter<PlayerFilter> {

    private String id;
    @SerializedName("id_in")
    private List<String> idIn;

    /**
     * Sets the player ID to filter for.
     *
     * @param id the ID
     * @return this filter for chaining
     */
    public PlayerFilter id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Sets the player IDs to filter for.
     *
     * @param ids the IDs
     * @return this filter for chaining
     */
    public PlayerFilter idIn(String... ids) {
        idIn = ids == null
                ? null
                : Arrays.asList(ids);
        return this;
    }

}
