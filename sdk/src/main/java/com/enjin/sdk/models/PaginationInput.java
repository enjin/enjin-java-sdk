package com.enjin.sdk.models;

import lombok.ToString;

@ToString
public class PaginationInput {

    public static final int HARD_LIMIT = 500;
    public static final int DEFAULT_LIMIT = 100;

    private int page;
    private int limit;

    public PaginationInput(int page, int limit) {
        this.page = Math.max(1, page);
        this.limit = Math.max(1, Math.min(HARD_LIMIT, limit));
    }

    public PaginationInput(int page) {
        this(page, DEFAULT_LIMIT);
    }

    public PaginationInput() {
        this(1);
    }

}
