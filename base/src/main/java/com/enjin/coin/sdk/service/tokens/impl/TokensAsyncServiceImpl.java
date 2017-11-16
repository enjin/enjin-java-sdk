package com.enjin.coin.sdk.service.tokens.impl;

import com.enjin.coin.sdk.config.Config;
import com.enjin.coin.sdk.service.tokens.TokensAsyncService;
import com.enjin.coin.sdk.vo.token.GetTokenRequestVO;
import com.enjin.coin.sdk.vo.token.GetTokenResponseVO;
import com.enjin.coin.sdk.vo.token.ListTokensRequestVO;
import com.enjin.coin.sdk.vo.token.ListTokensResponseVO;

import java.util.concurrent.Future;
import java.util.logging.Logger;

/**
 * <p>Contains services related to tokens</p>
 */
public class TokensAsyncServiceImpl extends TokensServiceImpl implements TokensAsyncService {

    private static final Logger LOGGER = Logger.getLogger(TokensAsyncServiceImpl.class.getName());

    /**
     * Class constructor
     *
     * @param enjinConfig - the enjinConfig to use
     */
    public TokensAsyncServiceImpl(Config enjinConfig) {
        super(enjinConfig);
    }

    public Future<GetTokenResponseVO> getTokenAsync(GetTokenRequestVO getTokenRequestVO) {
        return executorService.submit(() -> getToken(getTokenRequestVO));
    }

    public Future<ListTokensResponseVO> listTokensAsync(ListTokensRequestVO listTokensRequestVO) {
        return executorService.submit(() -> listTokens(listTokensRequestVO));
    }

}
