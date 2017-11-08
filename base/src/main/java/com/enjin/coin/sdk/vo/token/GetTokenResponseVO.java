package com.enjin.coin.sdk.vo.token;

import com.enjin.coin.sdk.vo.BaseResponseVO;
import com.fasterxml.jackson.annotation.JsonProperty;

public class GetTokenResponseVO extends BaseResponseVO {

	@JsonProperty("token_id")
	private String tokenId;
	
	@JsonProperty("creator")
	private String creator;
	
	@JsonProperty("adapter")
	private String adapter;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("icon")
	private String icon;
	
	@JsonProperty("totalSupply")
	private String totalSupply;
	
	@JsonProperty("exchangeRate")
	private String exchangeRate;
	
	@JsonProperty("decimals")
	private String decimals;
	
	@JsonProperty("maxMeltFee")
	private String maxMeltFee;
	
	@JsonProperty("meltFee")
	private String meltFee;
	
	@JsonProperty("transferable")
	private String transferable;

	public String getTokenId() {
		return tokenId;
	}

	public void setTokenId(String tokenId) {
		this.tokenId = tokenId;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getAdapter() {
		return adapter;
	}

	public void setAdapter(String adapter) {
		this.adapter = adapter;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getTotalSupply() {
		return totalSupply;
	}

	public void setTotalSupply(String totalSupply) {
		this.totalSupply = totalSupply;
	}

	public String getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(String exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public String getDecimals() {
		return decimals;
	}

	public void setDecimals(String decimals) {
		this.decimals = decimals;
	}

	public String getMaxMeltFee() {
		return maxMeltFee;
	}

	public void setMaxMeltFee(String maxMeltFee) {
		this.maxMeltFee = maxMeltFee;
	}

	public String getMeltFee() {
		return meltFee;
	}

	public void setMeltFee(String meltFee) {
		this.meltFee = meltFee;
	}

	public String getTransferable() {
		return transferable;
	}

	public void setTransferable(String transferable) {
		this.transferable = transferable;
	}

	@Override
	public String toString() {
		return "GetTokenResponseVO [tokenId=" + tokenId + ", creator=" + creator + ", adapter=" + adapter + ", name="
				+ name + ", icon=" + icon + ", totalSupply=" + totalSupply + ", exchangeRate=" + exchangeRate
				+ ", decimals=" + decimals + ", maxMeltFee=" + maxMeltFee + ", meltFee=" + meltFee + ", transferable="
				+ transferable + "]";
	}

	
}
