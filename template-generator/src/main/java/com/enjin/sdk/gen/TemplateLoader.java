package com.enjin.sdk.gen;

import com.github.nocatch.NoCatch;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class TemplateLoader {

    private Map<String, Template> fragments = new HashMap<>();
    private Map<String, Template> operations = new HashMap<>();

    private final File resourcesDir;

    protected TemplateLoader(File resourcesDir) {
        this.resourcesDir = resourcesDir;
    }

    public void load() {
        loadRawResources();
    }

    private void loadRawResources() {
        Stack<File> stack = new Stack<>();
        stack.add(resourcesDir);

        while (!stack.isEmpty()) {
            File file = stack.pop();
            if (file.isDirectory())
                stack.addAll(Arrays.asList(file.listFiles()));
            else if (file.getName().endsWith(".gql"))
                loadRawTemplate(file);
        }
    }

    private void loadRawTemplate(File file) {
        List<String> lines = NoCatch.noCatch(() -> Files.readAllLines(file.toPath()));
        String key = file.getName().replace(".gql", "");

        if (key.endsWith("Fragment"))
            fragments.put(key, new Template(key, lines, fragments));
        else if (key.endsWith("Mutation") || key.endsWith("Query"))
            operations.put(key, new Template(key, lines, fragments));
        else
            System.out.println(String.format("Invalid template name detected: %s", key));
    }

    public Map<String, Template> getOperations() {
        return operations;
    }
}
