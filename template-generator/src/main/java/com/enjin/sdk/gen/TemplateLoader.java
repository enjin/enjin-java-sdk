/* Copyright 2021 Enjin Pte Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.enjin.sdk.gen;

import lombok.Getter;
import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.Stack;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TemplateLoader {

    // This pattern handles arbitrary paths, validates the schema, gets the type, and validates the template name
    private static final Pattern TEMPLATE_REGEX = Pattern.compile(
            "^(?:[a-zA-Z\\\\:-]*schemas\\\\)(?:project|player|shared)\\\\(?<type>fragment|query|mutation)\\\\(?:[a-zA-Z]+)\\.gql$"
    );

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
                throw new IllegalArgumentException(String.format("Unknown template type: %s", type));
        }

    }

    @SneakyThrows
    private String[] loadTemplateContents(File file) {
        return Files.readAllLines(file.toPath()).toArray(new String[0]);
    }

}
