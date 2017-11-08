package com.enjin.coin.sdk.vo.identity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListIdentitiesRequestVO extends BaseIdentityRequestVO{


	@JsonProperty("linked")
	private Boolean linked;
	
	@JsonProperty("after_identity_id")
	private String afterIdentityId;
	
	@JsonProperty("limit")
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
