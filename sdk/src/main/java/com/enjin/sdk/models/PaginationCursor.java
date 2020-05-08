package com.enjin.sdk.models;

import lombok.Getter;
import lombok.ToString;

/**
 * Models a pagination cursor.
 */
@Getter
@ToString
public class PaginationCursor {

    /**
     * -- GETTER --
     * Returns the total number of items selected by the query.
     *
     * @retrun total items
     */
    private Integer total;

    /**
     * -- GETTER --
     * Returns the number of items returned per page.
     *
     * @return items per page
     */
    private Integer perPage;

    /**
     * -- GETTER --
     * Returns the current page of the cursor.
     *
     * @return the current page
     */
    private Integer currentPage;

    /**
     * -- GETTER --
     * Determines if the cursor has pages.
     *
     * @return true if the cursor has pages, false otherwise
     */
    private Boolean hasPages;

    /**
     * -- GETTER --
     * Returns the number of the first item returned.
     *
     * @return the first item
     */
    private Integer from;

    /**
     * -- GETTER --
     * Returns the number of the last item returned.
     *
     * @return the last item
     */
    private Integer to;

    /**
     * -- GETTER --
     * Returns the last page (number of pages).
     *
     * @return the last page
     */
    private Integer lastPage;

    /**
     * -- GETTER --
     * Determines if the cursor has more pages after the current page.
     *
     * @return true if the cursor has more pages, false otherwise
     */
    private Boolean hasMorePages;

}
