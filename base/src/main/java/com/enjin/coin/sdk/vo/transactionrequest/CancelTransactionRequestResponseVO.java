package com.enjin.coin.sdk.vo.transactionrequest;

import com.google.gson.annotations.SerializedName;

public class CancelTransactionRequestResponseVO {

	@SerializedName("result")
	private Boolean result;

	public Boolean getResult() {
		return result;
	}

	public void setResult(Boolean result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "CancelTransactionRequestResponseVO [result=" + result + "]";
	}
}
