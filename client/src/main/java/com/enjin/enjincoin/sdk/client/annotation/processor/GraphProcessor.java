package com.enjin.enjincoin.sdk.client.annotation.processor;

import com.enjin.enjincoin.sdk.client.annotation.GraphQuery;
import com.enjin.java_commons.ResourceUtils;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class GraphProcessor {

    private static GraphProcessor ourInstance;
    private final static Object lock = new Object();
    private final static String defaultExtension = ".graphql";
    private final static String defaultDirectory = "graphql";

    public static GraphProcessor getInstance() {
        if(ourInstance == null)
            ourInstance = new GraphProcessor();
        return ourInstance;
    }

    private GraphProcessor() {
        synchronized (lock) {
            if(this.graphFiles == null)
                this.graphFiles = new HashMap<>();
            if(isEmpty()) {
                initialize();
            }
        }
    }

    private volatile Map<String, String> graphFiles;

    public String getQuery(Annotation[] annotations) {
        GraphQuery graphQuery = null;

        for (Annotation annotation: annotations)
            if(annotation instanceof GraphQuery) {
                graphQuery = (GraphQuery) annotation;
                break;
            }

        if(graphFiles != null && graphQuery != null) {
            String fileName = String.format("%s%s", graphQuery.value(), defaultExtension);
            if(graphFiles.containsKey(fileName))
                return graphFiles.get(fileName);
        }
        return null;
    }

    private synchronized boolean isEmpty() {
        return graphFiles.size() < 1;
    }

    private synchronized void initialize() {
        try {
            Set<URL> urls = ResourceUtils.getResourceURLs(getClass().getClassLoader(), defaultDirectory,
                    url -> url.getFile().endsWith(defaultExtension));

            for (URL url : urls) {
                Path path = Paths.get(url.toURI());
                byte[] data = Files.readAllBytes(path);
                graphFiles.put(path.getFileName().toString(), new String(data));
            }
        } catch (URISyntaxException | IOException e) {
            e.printStackTrace();
        }
    }
}