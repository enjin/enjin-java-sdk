package com.enjin.coin.sdk.config;

/**
 * <p>Config used throughout the sdk</p>
 * @author damien
 *
 */
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
}
