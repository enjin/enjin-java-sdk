package com.enjin.sdk.models;

import lombok.Getter;

/**
 * Models a application on the platform.
 */
@Getter
public class Project {

    /**
     * -- Getter --
     * @return the ID of this app
     */
    private Integer id;

    /**
     * -- Getter --
     * @return the name of this app
     */
    private String name;

    /**
     * -- Getter --
     * @return the description of this app
     */
    private String description;

    /**
     * -- Getter --
     * @return the URL for the image of this app
     */
    private String image;

    /**
     * -- Getter --
     * <br>
     * <p>
     *     Formatted as an ISO 8601 string.
     * </p>
     *
     * @return the datetime when this was created
     */
    private String createdAt;

    /**
     * -- Getter --
     * <br>
     * <p>
     *     Formatted as an ISO 8601 string.
     * </p>
     *
     * @return the datetime when this was last updated
     */
    private String updatedAt;

}
