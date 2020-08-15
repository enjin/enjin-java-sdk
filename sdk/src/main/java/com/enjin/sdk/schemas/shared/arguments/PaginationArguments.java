package com.enjin.sdk.schemas.shared.arguments;

import com.enjin.sdk.graphql.VariableHolder;
import com.enjin.sdk.models.PaginationOptions;

/**
 * TODO
 * @param <T>
 */
public interface PaginationArguments<T extends VariableHolder<T>> extends VariableHolder<T> {

    /**
     * TODO
     * @param pagination
     * @return
     */
    default T paginate(PaginationOptions pagination) {
        return set("pagination", pagination);
    }

    /**
     * TODO
     * @param page
     * @param limit
     * @return
     */
    default T paginate(Integer page, Integer limit) {
        PaginationOptions options = new PaginationOptions()
                                        .page(page)
                                        .limit(limit);
        return set("pagination", options);
    }

}
