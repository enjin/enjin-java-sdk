package com.enjin.coin.sdk.vo.identity;

import com.google.gson.annotations.SerializedName;

public class ListIdentitiesRequestVO extends BaseIdentityRequestVO {


    @SerializedName("linked")
    private Boolean linked;

    @SerializedName("after_identity_id")
    private String afterIdentityId;

    @SerializedName("limit")
    private String limit;

    public Boolean getLinked() {
        return linked;
    }

    public void setLinked(Boolean linked) {
        this.linked = linked;
    }

    public String getAfterIdentityId() {
        return afterIdentityId;
    }

    public void setAfterIdentityId(String afterIdentityId) {
        this.afterIdentityId = afterIdentityId;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    @Override
    public String toString() {
        return "ListIdentitiesRequestVO [linked=" + linked + ", afterIdentityId=" + afterIdentityId
                + ", limit=" + limit + "]";
    }


}
