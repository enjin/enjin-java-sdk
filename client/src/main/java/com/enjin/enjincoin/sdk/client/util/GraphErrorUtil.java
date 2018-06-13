package com.enjin.enjincoin.sdk.client.util;

import com.enjin.enjincoin.sdk.client.model.attribute.GraphError;
import com.enjin.enjincoin.sdk.client.model.body.GraphQLResponse;
import com.enjin.java_commons.StringUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import okhttp3.ResponseBody;
import retrofit2.Response;

import java.lang.reflect.Type;
import java.util.List;

public class GraphErrorUtil {

    private static final String TAG = "GraphErrorUtil";

    /**
     * Converts the response error response into an object.
     *
     * @return The error object, or null if an exception was encountered
     * @see Error
     */
    public static List<GraphError> getError(Response response) {
        try {
            if(response != null) {
                ResponseBody responseBody = response.errorBody();
                String message;
                List<GraphError> graphErrors;
                if (responseBody != null && !StringUtils.isEmpty(message = responseBody.string()))
                    if((graphErrors = getGraphQLError(message)) != null)
                        return graphErrors;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private static List<GraphError> getGraphQLError(String errorJson) {
        Gson gson = new Gson();
        Type tokenType = new TypeToken<GraphQLResponse<?>>(){}.getType();
        GraphQLResponse<?> graphContainer = gson.fromJson(errorJson, tokenType);
        return graphContainer.getErrors();
    }
}
