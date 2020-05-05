package com.enjin.sdk.models.app;

import com.enjin.sdk.models.identity.Identity;
import com.enjin.sdk.models.user.User;

import com.enjin.sdk.services.app.AppsService;
import lombok.Getter;
import lombok.ToString;

/**
 * Represents a Trusted Platform App.
 *
 * @see AppsService
 */
@Getter
@ToString
public class App {

    /**
     * -- GETTER --
     * Returns the application id.
     *
     * @return the app id
     */
    private int id;

    /**
     * -- GETTER --
     * Returns the secret of the application.
     *
     * @return the app secret
     */
    private String secret;

    /**
     * -- GETTER --
     * Returns the application's name.
     *
     * @return the app name
     */
    private String name;

    /**
     * -- GETTER --
     * Returns the application's description.
     *
     * @return the app description
     */
    private String description;

    /**
     * -- GETTER --
     * Returns the url to the application's image.
     *
     * @return the url to the image
     */
    private String image;

    /**
     * -- GETTER --
     * Returns the application's linking code.
     *
     * @return the linking code of the app
     */
    private String linkingCode;

    /**
     * -- GETTER --
     * Returns the url to the linking code's qr image.
     *
     * @return the url to the image
     */
    private String linkingCodeQr;

    /**
     * -- GETTER --
     * Returns the current user linked to the application.
     *
     * @return the current identity
     */
    private Identity identity;

    /**
     * -- GETTER --
     * Returns the user who owns the application.
     *
     * @return the owner
     */
    private User owner;

    /**
     * -- GETTER --
     * Returns the number of tokens created for the application.
     *
     * @return the number of tokens
     */
    private int tokenCount;

    /**
     * -- GETTER --
     * Returns the ISO 8601 datetime when the application was created.
     *
     * @return the time the app was created
     */
    private String createdAt;

    /**
     * -- GETTER --
     * Returns the ISO 8601 datetime when the application was last updated.
     *
     * @return the last time the app was updated
     */
    private String updatedAt;

}
