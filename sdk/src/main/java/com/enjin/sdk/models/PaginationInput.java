package com.enjin.sdk.models;

import lombok.ToString;

/**
 * Models pagination settings.
 */
@ToString
public class PaginationInput {

    /**
     * The default number of results to return per page.
     */
    public static final int DEFAULT_LIMIT = 100;

    private int page;
    private int limit;

    /**
     * Constructs a PaginationInput with the passed limit of results per page and starting at the passed page number.
     *
     * @param page  the page number to start at
     * @param limit the number of results per page
     */
    public PaginationInput(int page, int limit) {
        this.page = Math.max(1, page);
        this.limit = Math.max(1, limit);
    }

    /**
     * Constructs a PaginationInput starting at the passed page number.
     *
     * @param page the page to start on
     */
    public PaginationInput(int page) {
        this(page, DEFAULT_LIMIT);
    }

    /**
     * Constructs a PaginationInput with the default number of results per page and starts at the first page.
     */
    public PaginationInput() {
        this(1);
    }

}
