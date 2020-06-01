package com.enjin.sdk.gen;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

public class Template {

    private String key;
    private TemplateType type;
    private Map<String, Template> fragments;
    private List<String> contents;
    private List<String> parameters;
    private List<String> referencedFragments;

    public Template(String key, List<String> rawContents, Map<String, Template> fragments) {
        this.key = key;
        this.type = TemplateType.fromKey(key);
        this.fragments = fragments;
        this.contents = new ArrayList<>();
        this.parameters = new ArrayList<>();
        this.referencedFragments = new ArrayList<>();
        parseTemplate(rawContents);
    }

    protected void parseTemplate(List<String> contents) {
        for (String line : contents) {
            if (!line.startsWith("$")) {
                if (!line.equals("\n")) {
                    this.contents.add(line);
                    if (line.trim().startsWith("..."))
                        referencedFragments.add(line.trim().replace("...", ""));
                }

                continue;
            }

            parameters.add(line);
        }
    }

    protected String compile() {
        StringBuilder builder = new StringBuilder(String.join("\n", contents));

        if (type != TemplateType.FRAGMENT) {
            List<String> parameters = new ArrayList<>(this.parameters);
            List<String> processedFragments = new ArrayList<>();
            Stack<Template> fragmentsQueue = new Stack<>();

            for (String reference : referencedFragments)
                fragmentsQueue.add(fragments.get(reference));

            while (!fragmentsQueue.empty()) {
                Template fragment = fragmentsQueue.pop();

                if (processedFragments.contains(fragment.key))
                    continue;

                for (String reference : fragment.referencedFragments)
                    fragmentsQueue.add(fragments.get(reference));

                parameters.addAll(fragment.parameters.stream().filter(p -> !parameters.contains(p)).collect(Collectors.toList()));

                builder.append('\n').append(fragment.compile());
                processedFragments.add(fragment.key);
            }

            String template = builder.toString();
            return template.replace(type.name().toLowerCase(),
                                    String.format("%s %s(%s)", type.name().toLowerCase(), key, String.join(", ", parameters)));
        }

        return builder.toString();
    }

}
