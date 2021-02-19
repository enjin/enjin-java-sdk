package com.enjin.sdk.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;

/**
 * Models a project on the platform.
 */
@EqualsAndHashCode
@Getter
public class Project {

    /**
     * -- Getter --
     * @return the ID of this project
     */
    private Integer id;

    /**
     * -- Getter --
     * @return the name of this project
     */
    private String name;

    /**
     * -- Getter --
     * @return the description of this project
     */
    private String description;

    /**
     * -- Getter --
     * @return the URL for the image of this project
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
