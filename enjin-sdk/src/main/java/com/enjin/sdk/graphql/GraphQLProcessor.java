package com.enjin.sdk.graphql;

import java.lang.annotation.Annotation;

import com.enjin.sdk.graphql.definitions.Templates;

/**
 * Loads and manages GraphQL template files used by various
 * service classes.
 *
 * @author Evan Lindsay
 * @see GraphQuery
 */
public final class GraphQLProcessor {

    private static GraphQLProcessor ourInstance;

    private GraphQLTemplateRegistry templateRegistry;

    private GraphQLProcessor() {
        this.templateRegistry = new GraphQLTemplateRegistry();
        for (GraphQLTemplate template : Templates.getTemplates()) {
            this.templateRegistry.register(template);
        }
    }

    /**
     * Takes an array of annotations and searches for a {@link GraphQuery}
     * instance. If an instance is found it will then look for an entry
     * that matches {@link GraphQuery#value()} and if not found will return
     * null.
     *
     * @param annotations an array of annotations that should contain {@link GraphQuery}.
     *
     * @return the contents of a template file or null if no entry is found.
     */
    public GraphQLTemplate getTemplate(Annotation[] annotations) {
        for (Annotation annotation : annotations) {
            if (annotation instanceof GraphQuery) {
                return templateRegistry.get(((GraphQuery) annotation).value());
            }
        }

        return null;
    }

    /**
     * Returns the GraphQLProcessor instance.
     *
     * @return the GraphQLProcessor instance.
     */
    public static GraphQLProcessor getInstance() {
        if (ourInstance == null) {
            ourInstance = new GraphQLProcessor();
        }
        return ourInstance;
    }
}