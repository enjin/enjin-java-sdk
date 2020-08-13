package com.enjin.sdk.models;

/**
 * TODO
 */
public class PaginationOptions {

    private Integer page;
    private Integer limit;

    /**
     * TODO
     * @param page
     * @return
     */
    public PaginationOptions page(Integer page) {
        this.page = page;
        return this;
    }

    /**
     * TODO
     * @param limit
     * @return
     */
    public PaginationOptions limit(Integer limit) {
        this.limit = limit;
        return this;
    }

}
