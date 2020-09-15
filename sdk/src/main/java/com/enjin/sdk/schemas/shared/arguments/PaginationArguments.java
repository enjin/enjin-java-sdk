package com.enjin.sdk.schemas.shared.arguments;

import com.enjin.sdk.graphql.VariableHolder;
import com.enjin.sdk.models.PaginationOptions;

/**
 * Fragment interface used to set pagination options for a pagination returned by the platform.
 *
 * @param <T> the type of the implementing class
 * @see com.enjin.sdk.models.PaginationCursor
 */
public interface PaginationArguments<T extends VariableHolder<T>> extends VariableHolder<T> {

    /**
     * Sets the pagination options.
     *
     * @param pagination the options
     * @return this request for chaining
     */
    default T paginate(PaginationOptions pagination) {
        return set("pagination", pagination);
    }

    /**
     * Creates pagination options that are then set.
     *
     * @param page the page to start on
     * @param limit the number of items per page
     * @return this request for chaining
     */
    default T paginate(Integer page, Integer limit) {
        return paginate(new PaginationOptions()
                                .page(page)
                                .limit(limit));
    }

}
