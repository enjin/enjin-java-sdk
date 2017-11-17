package com.enjin.coin.sdk.service.transactionrequests;

import com.enjin.coin.sdk.service.EnjinCoin;
import com.enjin.coin.sdk.service.events.EventsAsyncService;
import com.enjin.coin.sdk.service.identities.IdentitiesAsyncService;
import com.enjin.coin.sdk.service.tokens.TokensAsyncService;

public interface EnjinCoinAsync extends EnjinCoin {

    @Override
    EventsAsyncService getEventsService();

    @Override
    IdentitiesAsyncService getIdentitiesService();

    @Override
    TokensAsyncService getTokensService();

    @Override
    TransactionRequestsAsyncService getTransactionRequestsService();

}
