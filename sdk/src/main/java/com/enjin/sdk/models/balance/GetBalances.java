package com.enjin.sdk.models.balance;

import com.enjin.sdk.models.PaginationRequest;
import com.enjin.sdk.models.balance.data.BalanceFilter;
import com.enjin.sdk.services.balance.BalancesService;

import java.util.List;

/**
 * An object class for getting balances from the Trusted Platform.
 *
 * @see BalancesService
 */
public class GetBalances extends PaginationRequest<GetBalances> implements BalanceFragment<GetBalances> {

    /**
     * The application ids to filter by.
     * @deprecated Use {@link GetBalances#filter(BalanceFilter)} instead.
     *
     * @param ids the app ids
     * @return    this request
     */
    @Deprecated
    public GetBalances appIds(List<Integer> ids) {
        set("appIds", ids);
        return this;
    }

    /**
     * The Ethereum address to filter by.
     *
     * @param ethAddr the Ethereum address
     * @return        this request
     */
    public GetBalances ethAddress(String ethAddr) {
        set("ethAddress", ethAddr);
        return this;
    }

    /**
     * The token id to filter by.
     *
     * @param tokenId the token id
     * @return        this request
     */
    public GetBalances tokenId(String tokenId) {
        set("tokenId", tokenId);
        return this;
    }

    /**
     * Filters out balances that do not equal the value.
     * @deprecated Use {@link GetBalances#filter(BalanceFilter)} instead.
     *
     * @param value the value the balance must equal
     * @return      this request
     */
    @Deprecated
    public GetBalances value(Integer value) {
        set("value", value);
        return this;
    }

    /**
     * Sets the balance filter data.
     *
     * @param data the data
     * @return     this request
     */
    public GetBalances filter(BalanceFilter data) {
        set("filter", data);
        return this;
    }

    /**
     * Filters out balances that are not greater than the value.
     * @deprecated Use {@link GetBalances#filter(BalanceFilter)} instead.
     *
     * @param value the value the balance must be greater than
     * @return      this request
     */
    @Deprecated
    public GetBalances valGt(Integer value) {
        set("valueGt", value);
        return this;
    }

    /**
     * Filters out balances that are not greater than or equal to the value.
     * @deprecated Use {@link GetBalances#filter(BalanceFilter)} instead.
     *
     * @param value the value the balance must be greater than or equal to
     * @return      this request
     */
    @Deprecated
    public GetBalances valGte(Integer value) {
        set("valueGte", value);
        return this;
    }

    /**
     * Filters out balances that are not less than the value.
     * @deprecated Use {@link GetBalances#filter(BalanceFilter)} instead.
     *
     * @param value the value the balance must be less than
     * @return      this request
     */
    @Deprecated
    public GetBalances valLt(Integer value) {
        set("valueLt", value);
        return this;
    }

    /**
     * Filters out balances that are not less than or equal to the value.
     * @deprecated Use {@link GetBalances#filter(BalanceFilter)} instead.
     *
     * @param value the value the balance must be less than or equal to
     * @return      this request
     */
    @Deprecated
    public GetBalances valLte(Integer value) {
        set("valueLte", value);
        return this;
    }

}
