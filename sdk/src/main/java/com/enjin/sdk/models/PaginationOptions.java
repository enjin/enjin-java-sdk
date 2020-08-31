package com.enjin.sdk.models;

/**
 * Models a pagination input for pagination requests.
 *
 * @see com.enjin.sdk.schemas.shared.arguments.PaginationArguments
 */
public class PaginationOptions {

    private Integer page;
    private Integer limit;

    /**
     * Sets the page number to start at.
     *
     * @param page the page
     * @return this input for chaining
     */
    public PaginationOptions page(Integer page) {
        this.page = page;
        return this;
    }

    /**
     * Sets the number of results to return per page.
     *
     * @param limit the limit
     * @return this input for chaining
     */
    public PaginationOptions limit(Integer limit) {
        this.limit = limit;
        return this;
    }

}
