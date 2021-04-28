package com.enjin.sdk;

import com.enjin.sdk.models.Platform;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PlatformUtils {

    private static final Gson GSON = new GsonBuilder()
            .setLenient()
            .create();

    public final Platform FAKE_PLATFORM = createFakePlatform("fake");

    public TrustedPlatformMiddleware createMiddleware(String baseUri) {
        return new TrustedPlatformMiddleware(baseUri, false);
    }

    public Platform createFakePlatform(String network) {
        return createFakePlatform(network, "a826ad9293ce1ae1a036", "mt1", true);
    }

    @SneakyThrows
    public Platform createFakePlatform(String network,
                                       String key,
                                       String cluster,
                                       boolean encrypted) {
        StringBuilder builder = new StringBuilder()
                .append("{\"network\": ")
                .append(network)
                .append(", \"notifications\": {")
                .append("\"pusher\": {")
                .append("\"key\":")
                .append(key)
                .append(", \"options\": {")
                .append("\"cluster\": ")
                .append(cluster)
                .append(", \"encrypted\": ")
                .append(encrypted)
                .append("}}}}");
        return GSON.fromJson(builder.toString(), Platform.class);
    }

}
