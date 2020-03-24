package com.enjin.sdk.models.app;

import com.enjin.sdk.models.identity.Identity;
import com.enjin.sdk.models.user.User;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class App {

    private int id;

    private String secret;

    private String name;

    private String description;

    private String image;

    private String linkingCode;

    private String linkingCodeQr;

    private Identity identity;

    private User owner;

    private int tokenCount;

    private String createdAt;

    private String updatedAt;

}
