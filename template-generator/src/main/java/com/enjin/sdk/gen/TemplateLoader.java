package com.enjin.sdk.gen;

import lombok.Getter;
import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.Stack;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateLoader {

    private static final Pattern TEMPLATE_REGEX =
            Pattern.compile(new StringBuilder()
                                    .append("^(?:[.a-zA-Z]{0,}\\.)") // Handles arbitrary number of path elements
                                    .append("schema\\.(?:project|player|shared)\\.") // Validates the schema
                                    .append("(?<type>fragment|mutation|query)\\.") // Gets the template type
                                    .append("(?:[a-zA-Z]{1,}?)\\.gql$") // Validates the query name
                                    .toString());

    private final Map<String, Template> fragments = new HashMap<>();
    @Getter
    private final SortedMap<String, Template> operations = new TreeMap<>();
    private final File resourcesDir;

    protected TemplateLoader(File resourcesDir) {
        this.resourcesDir = resourcesDir;
    }

    public void load() {
        loadRawResources();
    }

    private void loadRawResources() {
        if (resourcesDir == null || !resourcesDir.exists())
            return;

        Stack<File> stack = new Stack<>();
        stack.add(resourcesDir);

        // Loads all .gql files in the resources directories and any child directories
        while (!stack.isEmpty()) {
            File resource = stack.pop();
            if (resource.isDirectory()) {
                File[] files = resource.listFiles();
                if (files != null)
                    stack.addAll(Arrays.asList(files));
            } else {
                Matcher matcher = TEMPLATE_REGEX.matcher(resource.getAbsolutePath());
                if (!matcher.matches())
                    continue;

                String type = matcher.group("type");
                for (TemplateType templateType : TemplateType.values()) {
                    if (type.equalsIgnoreCase(templateType.toString())) {
                        loadAndCacheTemplateContents(loadTemplateContents(resource), templateType);
                        break;
                    }
                }
            }
        }
    }

    private void loadAndCacheTemplateContents(String[] contents, TemplateType type) {
        if (contents == null)
            return;

        String namespace = Template.readNamespace(contents);
        if (namespace == null)
            return;

        switch (type) {
            case FRAGMENT:
                fragments.put(namespace, new Template(namespace, type, contents, fragments));
                break;
            case QUERY:
            case MUTATION:
                operations.put(namespace, new Template(namespace, type, contents, fragments));
                break;
            default:
                // TODO: Throw exception.
                break;
        }

    }

    @SneakyThrows
    private String[] loadTemplateContents(File file) {
        return (String[]) Files.readAllLines(file.toPath()).toArray();
    }

}
