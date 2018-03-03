package io.enjincoin.sdk.client.service.tokens;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.Before;
import org.junit.Test;

import io.enjincoin.sdk.client.service.BaseLiveServiceTest;
import io.enjincoin.sdk.client.vo.token.CreateTokenRequestVO;
import io.enjincoin.sdk.client.vo.token.CreateTokenResponseVO;
import io.enjincoin.sdk.client.vo.token.TokenResponseVO;

/**
 * Calls out to the actual api Will have the disabled annotation in place
 * usually but will be useful for testing the actual api
 */
public class LiveTokensServiceTest extends BaseLiveServiceTest {

    private int randomNumber1 = 0;
    private int randomNumber2 = 0;

    @Override
    @Before
    public void setUp() {
        super.setUp();
        Random random1 = new Random();
        Random random2 = new Random();
        int low = 10000;
        int high = 999999999;
        randomNumber1 = random1.nextInt(high-low) + low;
        randomNumber2 = random2.nextInt(high-low) + low;
    }
    @Test
    public void testSychronousTokensService_GetTokens() {
        SynchronousTokensService tokensService = this.client.getTokensService();
        assertThat(tokensService).isNotNull();

        TokenResponseVO[] tokensArray = tokensService.getTokensSync();
        assertThat(tokensArray).isNotNull();

        for (TokenResponseVO token : tokensArray) {
            assertThat(token).isNotNull();
            assertThat(token.getTokenId()).isNotNull();
            assertThat(token.getAppId()).isNotNull();
            assertThat(token.getCreator()).isNotNull();
            assertThat(token.getAdapter()).isNotNull();
            assertThat(token.getName()).isNotNull();
            assertThat(token.getIcon()).isNotNull();
            assertThat(token.getTotalSupply()).isNotNull();
            assertThat(token.getExchangeRate()).isNotNull();
            assertThat(token.getDecimals()).isNotNull();
            assertThat(token.getMaxMeltFee()).isNotNull();
            assertThat(token.getMeltFee()).isNotNull();
            assertThat(token.getTransferable()).isNotNull();
            assertThat(token.getCreatedAt()).isNotNull();
            assertThat(token.getUpdatedAt()).isNotNull();
        }
    }

    @Test
    public void testAsychronousTokensService_GetTokens() throws InterruptedException, ExecutionException {
        AsynchronousTokensService tokensService = this.client.getTokensService();
        assertThat(tokensService).isNotNull();

        CompletableFuture<TokenResponseVO[]> tokensArrayCf = tokensService.getTokensAsync();
        assertThat(tokensArrayCf).isNotNull();
        assertThat(tokensArrayCf.get()).isNotNull();

        TokenResponseVO[] tokensArray = tokensArrayCf.get();
        for (TokenResponseVO token : tokensArray) {
            assertThat(token).isNotNull();
            assertThat(token.getTokenId()).isNotNull();
            assertThat(token.getAppId()).isNotNull();
            assertThat(token.getCreator()).isNotNull();
            assertThat(token.getAdapter()).isNotNull();
            assertThat(token.getName()).isNotNull();
            assertThat(token.getIcon()).isNotNull();
            assertThat(token.getTotalSupply()).isNotNull();
            assertThat(token.getExchangeRate()).isNotNull();
            assertThat(token.getDecimals()).isNotNull();
            assertThat(token.getMaxMeltFee()).isNotNull();
            assertThat(token.getMeltFee()).isNotNull();
            assertThat(token.getTransferable()).isNotNull();
            assertThat(token.getCreatedAt()).isNotNull();
            assertThat(token.getUpdatedAt()).isNotNull();
        }
    }

    @Test
    public void testSychronousTokensService_GetToken() {
        SynchronousTokensService tokensService = this.client.getTokensService();
        assertThat(tokensService).isNotNull();

        CreateTokenRequestVO createTokenRequestVO = new CreateTokenRequestVO(Optional.of(randomNumber1), Optional.of(randomNumber2));
        CreateTokenResponseVO createTokenResponseVO = tokensService.createTokenSync(createTokenRequestVO );
        assertThat(createTokenResponseVO).isNotNull();
        assertThat(createTokenResponseVO.getAppId()).isNotNull();
        assertThat(createTokenResponseVO.getTokenId()).isNotNull();
        assertThat(createTokenResponseVO.getCreatedAt()).isNotNull();
        assertThat(createTokenResponseVO.getUpdatedAt()).isNotNull();

        Integer tokenId = createTokenResponseVO.getTokenId().get();

        TokenResponseVO token = tokensService.getTokenSync(tokenId);
        assertThat(token).isNotNull();
        assertThat(token.getTokenId()).isNotNull();
        assertThat(token.getAppId()).isNotNull();
        assertThat(token.getCreator()).isNotNull();
        assertThat(token.getAdapter()).isNotNull();
        assertThat(token.getName()).isNotNull();
        assertThat(token.getIcon()).isNotNull();
        assertThat(token.getTotalSupply()).isNotNull();
        assertThat(token.getExchangeRate()).isNotNull();
        assertThat(token.getDecimals()).isNotNull();
        assertThat(token.getMaxMeltFee()).isNotNull();
        assertThat(token.getMeltFee()).isNotNull();
        assertThat(token.getTransferable()).isNotNull();
        assertThat(token.getCreatedAt()).isNotNull();
        assertThat(token.getUpdatedAt()).isNotNull();
    }

    @Test
    public void testAsychronousTokensService_GetToken() throws InterruptedException, ExecutionException {
        AsynchronousTokensService tokensService = this.client.getTokensService();
        assertThat(tokensService).isNotNull();

        CreateTokenRequestVO createTokenRequestVO = new CreateTokenRequestVO(Optional.of(randomNumber2), Optional.of(randomNumber1));
        CompletableFuture<CreateTokenResponseVO> createTokenResponseVOCf = tokensService.createTokenAsync(createTokenRequestVO );
        assertThat(createTokenResponseVOCf).isNotNull();
        assertThat(createTokenResponseVOCf.get()).isNotNull();

        CreateTokenResponseVO createTokenResponseVO = createTokenResponseVOCf.get();
        assertThat(createTokenResponseVO.getAppId()).isNotNull();
        assertThat(createTokenResponseVO.getTokenId()).isNotNull();
        assertThat(createTokenResponseVO.getCreatedAt()).isNotNull();
        assertThat(createTokenResponseVO.getUpdatedAt()).isNotNull();

        Integer tokenId = createTokenResponseVO.getTokenId().get();
        CompletableFuture<TokenResponseVO> tokenCf = tokensService.getTokenAsync(tokenId);
        assertThat(tokenCf).isNotNull();
        assertThat(tokenCf.get()).isNotNull();

        TokenResponseVO token = tokenCf.get();
        assertThat(token).isNotNull();
        assertThat(token.getTokenId()).isNotNull();
        assertThat(token.getAppId()).isNotNull();
        assertThat(token.getCreator()).isNotNull();
        assertThat(token.getAdapter()).isNotNull();
        assertThat(token.getName()).isNotNull();
        assertThat(token.getIcon()).isNotNull();
        assertThat(token.getTotalSupply()).isNotNull();
        assertThat(token.getExchangeRate()).isNotNull();
        assertThat(token.getDecimals()).isNotNull();
        assertThat(token.getMaxMeltFee()).isNotNull();
        assertThat(token.getMeltFee()).isNotNull();
        assertThat(token.getTransferable()).isNotNull();
        assertThat(token.getCreatedAt()).isNotNull();
        assertThat(token.getUpdatedAt()).isNotNull();
    }

    @Test
    public void testSychronousTokensService_CreateTokens() {
        SynchronousTokensService tokensService = this.client.getTokensService();
        assertThat(tokensService).isNotNull();

        CreateTokenRequestVO createTokenRequestVO = new CreateTokenRequestVO(Optional.of(randomNumber1), Optional.of(randomNumber2));
        CreateTokenResponseVO createTokenResponseVO = tokensService.createTokenSync(createTokenRequestVO );
        assertThat(createTokenResponseVO).isNotNull();
        assertThat(createTokenResponseVO.getAppId()).isNotNull();
        assertThat(createTokenResponseVO.getTokenId()).isNotNull();
        assertThat(createTokenResponseVO.getCreatedAt()).isNotNull();
        assertThat(createTokenResponseVO.getUpdatedAt()).isNotNull();
    }

    @Test
    public void testAsychronousTokensService_CreateTokens() throws InterruptedException, ExecutionException {
        AsynchronousTokensService tokensService = this.client.getTokensService();
        assertThat(tokensService).isNotNull();

        CreateTokenRequestVO createTokenRequestVO = new CreateTokenRequestVO(Optional.of(randomNumber2), Optional.of(randomNumber1));
        CompletableFuture<CreateTokenResponseVO> createTokenResponseVOCf = tokensService.createTokenAsync(createTokenRequestVO );
        assertThat(createTokenResponseVOCf).isNotNull();
        assertThat(createTokenResponseVOCf.get()).isNotNull();

        CreateTokenResponseVO createTokenResponseVO = createTokenResponseVOCf.get();
        assertThat(createTokenResponseVO.getAppId()).isNotNull();
        assertThat(createTokenResponseVO.getTokenId()).isNotNull();
        assertThat(createTokenResponseVO.getCreatedAt()).isNotNull();
        assertThat(createTokenResponseVO.getUpdatedAt()).isNotNull();
    }
}
