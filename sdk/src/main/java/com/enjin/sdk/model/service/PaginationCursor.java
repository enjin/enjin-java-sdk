package com.enjin.sdk.model.service;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PaginationCursor {

    private Integer total;
    private Integer perPage;
    private Integer currentPage;
    private boolean hasPages;

}
