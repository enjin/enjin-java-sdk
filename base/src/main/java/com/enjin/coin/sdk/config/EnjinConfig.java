package com.enjin.coin.sdk.config;

public class EnjinConfig {

	private String trustedPlatformUrl;
	private boolean inTestMode = false;
	public String getTrustedPlatformUrl() {
		return trustedPlatformUrl;
	}
	public void setTrustedPlatformUrl(String trustedPlatformUrl) {
		this.trustedPlatformUrl = trustedPlatformUrl;
	}
	public boolean isInTestMode() {
		return inTestMode;
	}
	public void setInTestMode(boolean inTestMode) {
		this.inTestMode = inTestMode;
	}
	@Override
	public String toString() {
		return "EnjinConfig [trustedPlatformUrl=" + trustedPlatformUrl + ", inTestMode=" + inTestMode + "]";
	}
	
	
}
