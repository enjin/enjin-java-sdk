package com.enjin.sdk.models;

import lombok.Getter;
import lombok.ToString;

/**
 * Models a pagination cursor for queries.
 */
@Getter
@ToString
public class PaginationCursor {

    /**
     * -- GETTER --
     * @retrun the total number of items selected
     */
    private Integer total;

    /**
     * -- GETTER --
     * @return the number of items per page
     */
    private Integer perPage;

    /**
     * -- GETTER --
     * @return the current page
     */
    private Integer currentPage;

    /**
     * -- GETTER --
     * @return true if the cursor has pages, false otherwise
     */
    private Boolean hasPages;

    /**
     * -- GETTER --
     * @return the number of the first item returned
     */
    private Integer from;

    /**
     * -- GETTER --
     * @return the number of the last item returned
     */
    private Integer to;

    /**
     * -- GETTER --
     * @return the last page (number of pages)
     */
    private Integer lastPage;

    /**
     * -- GETTER --
     * @return true if the cursor has more pages, false otherwise
     */
    private Boolean hasMorePages;

}
