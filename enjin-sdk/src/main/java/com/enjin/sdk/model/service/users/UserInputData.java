package com.enjin.sdk.model.service.users;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UserInputData {

    private String name;
    private String email;

    public UserInputData(String name, String email) {
        this.name = name;
        this.email = email;
    }

}
