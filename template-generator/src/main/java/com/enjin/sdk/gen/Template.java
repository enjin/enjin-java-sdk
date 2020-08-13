package com.enjin.sdk.gen;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class Template {

    private static final String NAMESPACE_KEY = "#namespace";
    private static final String IMPORT_KEY = "#import";
    private static final String ARG_KEY = "#arg";

    @Getter
    private final String namespace;
    @Getter
    private final String name;
    @Getter
    private final TemplateType type;
    private final Map<String, Template> fragments;
    private final List<String> contents = new ArrayList<>();
    private final List<String> parameters = new ArrayList<>();
    private final List<String> referencedFragments = new ArrayList<>();

    public Template(String namespace,
                    TemplateType type,
                    String[] contents,
                    Map<String, Template> fragments) {
        String[] parts = namespace.split("\\.");

        this.namespace = namespace;
        this.name = parts[parts.length - 1];
        this.type = type;
        this.fragments = fragments;
        parseContents(contents);
    }

    protected void parseContents(String[] contents) {
        for (String line : contents) {
            String trimmed = line.trim();
            if (trimmed.startsWith(IMPORT_KEY)) {
                referencedFragments.add(processImport(trimmed));
            } else if (trimmed.startsWith(ARG_KEY)) {
                parameters.add(processArg(trimmed));
            } else if (!trimmed.isEmpty() && !trimmed.startsWith("#")) {
                this.contents.add(trimmed);
            }
        }
    }

    protected String compile() {
        StringBuilder builder = new StringBuilder(String.join("\n", contents));
        
        if (type == TemplateType.FRAGMENT)
            return builder.toString();

        List<String> parameters = new ArrayList<>(this.parameters);
        List<String> processedFragments = new ArrayList<>();
        Stack<Template> fragmentsQueue = new Stack<>();

        for (String reference : referencedFragments)
            fragmentsQueue.add(fragments.get(reference));

        while (!fragmentsQueue.empty()) {
            Template fragment = fragmentsQueue.pop();

            if (processedFragments.contains(fragment.namespace))
                continue;

            for (String reference : fragment.referencedFragments)
                fragmentsQueue.add(fragments.get(reference));

            parameters.addAll(fragment.parameters
                                      .stream()
                                      .filter(p -> !parameters.contains(p))
                                      .collect(Collectors.toList()));

            builder.append(fragment.compile()).append('\n');
            processedFragments.add(fragment.namespace);
        }

        String template = builder.toString();
        return template.replace(type.name().toLowerCase(),
                                String.format("%s %s(\n    %s\n)",
                                              type.name().toLowerCase(),
                                              name,
                                              String.join(",\n    ", parameters)));
    }

    protected static String readNamespace(String[] contents) {
        for (String line : contents) {
            if (line.startsWith(NAMESPACE_KEY))
                return line.split(" ")[1];
        }

        return null;
    }

    private static String processArg(String line) {
        String[] parts = line.split(" ");
        switch (parts.length) {
            case 3:
                return String.format("$%s: %s", parts[1], parts[2]);
            case 4:
                return String.format("$%s: %s = %s", parts[1], parts[2], parts[3]);
            default:
                throw new IllegalArgumentException("Argument is of incorrect format");
        }
    }

    private static String processImport(String line) {
        return line.split(" ")[1];
    }

}
