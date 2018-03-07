package io.enjincoin.sdk.client.service.platform.vo;

import com.google.gson.annotations.SerializedName;

/**
 * <p>
 * App Detail class.
 * </p>
 */
public class AppDetail {

    @SerializedName("id")
    private String id;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("image")
    private String image;

    /**
     * Class constructor.
     * @param id
     * @param name
     * @param description
     * @param image
     */
    public AppDetail(String id, String name, String description, String image) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @return the image
     */
    public String getImage() {
        return image;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "AppDetail [id=" + id + ", name=" + name + ", description=" + description + ", image=" + image + "]";
    }
}
