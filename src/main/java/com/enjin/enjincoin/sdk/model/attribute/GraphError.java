package com.enjin.enjincoin.sdk.model.attribute;

import java.util.List;
import java.util.Map;

public class GraphError {

    private String                     message;
    private int                        code;
    private List<Map<String, Integer>> locations;
    private String                     detail;

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public List<Map<String, Integer>> getLocations() {
        return locations;
    }

    public String getDetail() {
        return detail;
    }

    @Override
    public String toString() {
        return "GraphError{" +
                "message='" + message + '\'' +
                ", code=" + code +
                ", locations=" + locations +
                ", detail='" + detail + '\'' +
                '}';
    }
}
