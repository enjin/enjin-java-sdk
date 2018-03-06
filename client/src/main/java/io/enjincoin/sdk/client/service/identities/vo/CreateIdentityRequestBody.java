package io.enjincoin.sdk.client.service.identities.vo;

import java.util.Optional;

import com.google.gson.annotations.SerializedName;

public class CreateIdentityRequestBody {

    @SerializedName("app_id")
    private Optional<Integer> appId;

    @SerializedName("ethereum_address")
    public Optional<String> ethereumAddress;

    @SerializedName("fields")
    public Optional<IdentityField[]> fields;

    public CreateIdentityRequestBody() {
    }

    public CreateIdentityRequestBody(Integer appId, String ethereumAddress, IdentityField[] fields) {
        this.appId = Optional.ofNullable(appId);
        this.ethereumAddress = Optional.ofNullable(ethereumAddress);
        this.fields = Optional.ofNullable(fields);
    }

}
