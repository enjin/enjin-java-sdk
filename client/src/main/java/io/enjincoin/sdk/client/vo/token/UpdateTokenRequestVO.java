package io.enjincoin.sdk.client.vo.token;

import java.util.Optional;

import com.google.gson.annotations.SerializedName;

/**
 * <p>Update Token Response class.
 * </p>
 */
public class UpdateTokenRequestVO {

    @SerializedName("token_id")
    private Optional<Integer> tokenId;

    @SerializedName("app_id")
    private Optional<Integer> appId;

    @SerializedName("name")
    private Optional<String> name;

    @SerializedName("icon")
    private Optional<String> icon;

    /**
     * Class constructor.
     * @param tokenId
     * @param appId
     * @param name
     * @param icon
     */
    public UpdateTokenRequestVO(Optional<Integer> tokenId, Optional<Integer> appId, Optional<String> name, Optional<String> icon) {
        super();
        this.tokenId = tokenId;
        this.appId = appId;
        this.name = name;
        this.icon = icon;
    }


    /**
     * @return the tokenId
     */
    public Optional<Integer> getTokenId() {
        return tokenId;
    }
    /**
     * @return the appId
     */
    public Optional<Integer> getAppId() {
        return appId;
    }
    /**
     * @return the name
     */
    public Optional<String> getName() {
        return name;
    }
    /**
     * @return the icon
     */
    public Optional<String> getIcon() {
        return icon;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "UpdateTokenRequestVO [tokenId=" + tokenId + ", appId=" + appId + ", name=" + name + ", icon=" + icon + "]";
    }


}
