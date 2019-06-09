package com.enjin.enjincoin.sdk.graphql;

import com.enjin.enjincoin.sdk.graphql.api.Queries;
import com.enjin.enjincoin.sdk.graphql.api.Templates;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * Loads and manages GraphQL template files used by various
 * service classes.
 *
 * @author Evan Lindsay
 * @see GraphQuery
 */
public class GraphQLProcessor {

    private static       GraphQLProcessor ourInstance;
    private final static Object           lock             = new Object();

    private GraphQLTemplateRegistry templateRegistry;

    private GraphQLProcessor() {
        synchronized (lock) {
            if (this.templateRegistry == null) {
                this.templateRegistry = new GraphQLTemplateRegistry();
                for (GraphQLTemplate template : Templates.getTemplates()) {
                    this.templateRegistry.register(template);
                }
            }
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
        GraphQuery graphQuery = null;

        for (Annotation annotation : annotations) {
            if (annotation instanceof GraphQuery) {
                graphQuery = (GraphQuery) annotation;
                break;
            }
        }

        if (graphQuery != null) {
            if (templateRegistry.has(graphQuery.value())) {
                return templateRegistry.get(graphQuery.value());
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