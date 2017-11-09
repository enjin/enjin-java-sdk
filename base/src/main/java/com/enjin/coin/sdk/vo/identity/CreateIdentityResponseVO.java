package com.enjin.coin.sdk.vo.identity;

import com.google.gson.annotations.SerializedName;

public class CreateIdentityResponseVO {

	@SerializedName("identity_id")
	private String identityId;

	@SerializedName("identity_code")
	private String identityCode;

	public String getIdentityId() {
		return identityId;
	}

	public void setIdentityId(String identityId) {
		this.identityId = identityId;
	}

	public String getIdentityCode() {
		return identityCode;
	}

	public void setIdentityCode(String identityCode) {
		this.identityCode = identityCode;
	}

	@Override
	public String toString() {
		return "CreateIdentityResponseVO [identityId=" + identityId + ", identityCode=" + identityCode + "]";
	}

	
}
