package com.enjin.sdk.graphql;

import java.lang.annotation.Annotation;

/**
 * Singleton class, loads and manages GraphQL template files used by various service classes.
 *
 * @author Evan Lindsay
 * @see GraphQuery
 */
public final class GraphQLProcessor {

    private static GraphQLProcessor ourInstance;

    private GraphQLQueryRegistry queryRegistry;

    private GraphQLProcessor() {
        this.queryRegistry = new GraphQLQueryRegistry();
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
    public String getQuery(Annotation[] annotations) {
        for (Annotation annotation : annotations) {
            if (annotation instanceof GraphQuery) {
                return queryRegistry.get(((GraphQuery) annotation).value());
            }
        }

        return null;
    }

    /**
     * Gets the query using the query name.
     *
     * @param name the query name.
     * @return     the query.
     */
    public String getQuery(String name) {
        return queryRegistry.get(name);
    }

    /**
     * Takes an array of annotations and searches for a {@link GraphQuery}
     * instance. If an instance is found it will then look for an entry
     * that matches {@link GraphQuery#value()} and if not found will return
     * null.
     *
     * @param annotations an array of annotations that should contain {@link GraphQuery}.
     * @return            the query name.
     */
    public String getQueryName(Annotation[] annotations) {
        for (Annotation annotation : annotations) {
            if (annotation instanceof  GraphQuery) {
                return ((GraphQuery) annotation).value();
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
