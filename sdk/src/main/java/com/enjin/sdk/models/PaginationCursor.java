package com.enjin.sdk.models;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PaginationCursor {

    private Integer total;

    private Integer perPage;

    private Integer currentPage;

    private Boolean hasPages;

    private Integer from;

    private Integer to;

    private Integer lastPage;

    private Boolean hasMorePages;

}
