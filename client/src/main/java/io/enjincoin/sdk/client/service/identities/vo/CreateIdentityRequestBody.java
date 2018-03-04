package io.enjincoin.sdk.client.service.identities.vo;

import com.google.gson.annotations.SerializedName;

import java.util.Optional;

public class CreateIdentityRequestBody {

    @SerializedName("ethereum_address")
    public Optional<String> ethereumAddress;

    @SerializedName("fields")
    public Optional<IdentityField[]> fields;

    public CreateIdentityRequestBody() {
    }

    public CreateIdentityRequestBody(String ethereumAddress, IdentityField[] fields) {
        this.ethereumAddress = Optional.ofNullable(ethereumAddress);
        this.fields = Optional.ofNullable(fields);
    }

}
