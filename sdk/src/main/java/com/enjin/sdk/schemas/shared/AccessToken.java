package com.enjin.sdk.schemas.shared;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.util.Objects;

/**
 * TODO
 */
@Getter
public class AccessToken {

    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    @SerializedName("accessToken")
    private String token;
    /**
     * -- Getter --
     * TODO
     *
     * @return
     */
    private long expiresIn;

    @Override
    public String toString() {
        return Objects.toString(this);
    }

}
