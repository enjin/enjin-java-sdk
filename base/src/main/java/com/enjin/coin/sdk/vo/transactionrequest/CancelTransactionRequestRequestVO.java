package com.enjin.coin.sdk.vo.transactionrequest;

import com.google.gson.annotations.SerializedName;

public class CancelTransactionRequestRequestVO {

	@SerializedName("auth")
	private String auth;

	@SerializedName("txr_id")
	private String txrId;

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public String getTxrId() {
		return txrId;
	}

	public void setTxrId(String txrId) {
		this.txrId = txrId;
	}

	@Override
	public String toString() {
		return "CancelTransactionRequestRequestVO [auth=" + auth + ", txrId=" + txrId + "]";
	}

}
