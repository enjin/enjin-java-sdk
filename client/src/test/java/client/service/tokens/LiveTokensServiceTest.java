package client.service.tokens;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.junit.Test;

import client.service.BaseLiveServiceTest;
import com.enjin.enjincoin.sdk.client.service.tokens.AsynchronousTokensService;
import com.enjin.enjincoin.sdk.client.service.tokens.SynchronousTokensService;
import com.enjin.enjincoin.sdk.client.service.tokens.vo.Token;
import com.enjin.enjincoin.sdk.client.util.Utils;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Calls out to the actual api
 * Will have the disabled annotation in place usually but will be useful for testing the actual api
 *
 */
public class LiveTokensServiceTest extends BaseLiveServiceTest {

    // TODO: Refactor to reduce redundancy

    @Test
    public void testSynchronousTokensService_GetTokens() throws IOException {
        SynchronousTokensService service = this.client.getTokensService();
        assertThat(service).isNotNull();

        Response<Token[]> response = service.getTokensSync();
        assertThat(response).isNotNull();
        assertThat(response.body()).isNotNull();

        for (Token token : response.body()) {
            assertThat(token.getTokenId()).isNotNull();
            assertThat(token.getAppId()).isNotNull();
        }
    }

    @Test
    public void testAsychronousTokensService_GetTokens() throws InterruptedException, ExecutionException {
        AsynchronousTokensService service = this.client.getTokensService();
        assertThat(service).isNotNull();

        service.getTokensAsync(new Callback<Token[]>() {

            @Override
            public void onResponse(Call<Token[]> call, Response<Token[]> response) {
                assertThat(response).isNotNull();
                assertThat(response.body()).isNotNull();

                for (Token token : response.body()) {
                    assertThat(token.getTokenId()).isNotNull();
                    assertThat(token.getAppId()).isNotNull();
                }
            }

            @Override
            public void onFailure(Call<Token[]> call, Throwable t) {
                    fail("Test Failed");
            }
        });

    }

    @Test
    public void testSynchronousTokensService_GetTokenById() throws IOException {
        SynchronousTokensService service = this.client.getTokensService();
        assertThat(service).isNotNull();

        Token Token = new Token(Utils.generateRandomInt(0, Integer.MAX_VALUE - 1), 1);
        Response<Token> createResponse = service.createTokenSync(Token);
        assertThat(createResponse).isNotNull();
        assertThat(createResponse.body()).isNotNull();
        assertThat(createResponse.body().getTokenId()).isNotNull();
        assertThat(createResponse.body().getAppId()).isNotNull();
        assertThat(createResponse.body().getCreatedAt()).isNotNull();
        assertThat(createResponse.body().getUpdatedAt()).isNotNull();

        Integer tokenId = createResponse.body().getTokenId();

        Response<Token> getResponse = service.getTokenSync(tokenId);
        assertThat(getResponse).isNotNull();
        assertThat(getResponse.body()).isNotNull();
        assertThat(getResponse.body().getTokenId()).isNotNull();
        assertThat(getResponse.body().getAppId()).isNotNull();

        Response<Boolean> deleteResponse = service.deleteTokenSync(tokenId);
        assertThat(deleteResponse).isNotNull();
        assertThat(deleteResponse.body()).isNotNull();
        assertThat(deleteResponse.body()).isTrue();
    }

    @Test
    public void testAsychronousTokensService_GetTokenById() throws InterruptedException, ExecutionException {
        AsynchronousTokensService service = this.client.getTokensService();
        assertThat(service).isNotNull();

        Token token = new Token(Utils.generateRandomInt(0, Integer.MAX_VALUE - 1), 1);
        service.createTokenAsync(token, new Callback<Token>() {

            @Override
            public void onResponse(Call<Token> call, Response<Token> createResponse) {
                assertThat(createResponse).isNotNull();
                assertThat(createResponse.body()).isNotNull();
                assertThat(createResponse.body().getTokenId()).isNotNull();
                assertThat(createResponse.body().getAppId()).isNotNull();
                assertThat(createResponse.body().getCreatedAt()).isNotNull();
                assertThat(createResponse.body().getUpdatedAt()).isNotNull();

                Integer tokenId = createResponse.body().getTokenId();

                service.getTokenAsync(tokenId, new Callback<Token>() {

                    @Override
                    public void onResponse(Call<Token> call, Response<Token> getResponse) {
                        assertThat(getResponse).isNotNull();
                        assertThat(getResponse.body()).isNotNull();
                        assertThat(getResponse.body().getTokenId()).isNotNull();
                        assertThat(getResponse.body().getAppId()).isNotNull();

                        service.deleteTokenAsync(tokenId, new Callback<Boolean>() {
                            @Override
                            public void onResponse(Call<Boolean> call, Response<Boolean> deleteResponse) {
                                assertThat(deleteResponse).isNotNull();
                                assertThat(deleteResponse.body()).isNotNull();
                                assertThat(deleteResponse.body()).isTrue();
                            }

                            @Override
                            public void onFailure(Call<Boolean> call, Throwable t) {
                                fail("Test Failed");
                            }
                        });
                    }

                    @Override
                    public void onFailure(Call<Token> call, Throwable t) {
                        fail("Test Failed");
                    }
                });
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                fail("Test failed");
            }
        });

    }

    @Test
    public void testSynchronousTokensService_CreateToken() throws IOException {
        SynchronousTokensService service = this.client.getTokensService();
        assertThat(service).isNotNull();

        Token Token = new Token(Utils.generateRandomInt(0, Integer.MAX_VALUE - 1), 1);

        Response<Token> createResponse = service.createTokenSync(Token);
        assertThat(createResponse).isNotNull();
        assertThat(createResponse.body()).isNotNull();
        assertThat(createResponse.body().getTokenId()).isNotNull();
        assertThat(createResponse.body().getAppId()).isNotNull();
        assertThat(createResponse.body().getCreatedAt()).isNotNull();
        assertThat(createResponse.body().getUpdatedAt()).isNotNull();

        Integer tokenId = createResponse.body().getTokenId();

        Response<Boolean> deleteResponse = service.deleteTokenSync(tokenId);
        assertThat(deleteResponse).isNotNull();
        assertThat(deleteResponse.body()).isNotNull();
        assertThat(deleteResponse.body()).isTrue();
    }

    @Test
    public void testAsychronousTokensService_CreateToken() throws InterruptedException, ExecutionException {
        AsynchronousTokensService service = this.client.getTokensService();
        assertThat(service).isNotNull();

        Token token = new Token(Utils.generateRandomInt(0, Integer.MAX_VALUE - 1), 1);
        service.createTokenAsync(token, new Callback<Token>() {

            @Override
            public void onResponse(Call<Token> call, Response<Token> createResponse) {
                assertThat(createResponse).isNotNull();
                assertThat(createResponse.body()).isNotNull();
                assertThat(createResponse.body().getTokenId()).isNotNull();
                assertThat(createResponse.body().getAppId()).isNotNull();
                assertThat(createResponse.body().getCreatedAt()).isNotNull();
                assertThat(createResponse.body().getUpdatedAt()).isNotNull();

                Integer tokenId = createResponse.body().getTokenId();

                service.deleteTokenAsync(tokenId, new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> deleteResponse) {
                        assertThat(deleteResponse).isNotNull();
                        assertThat(deleteResponse.body()).isNotNull();
                        assertThat(deleteResponse.body()).isTrue();
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        fail("Test Failed");
                    }
                });

            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                fail("Test Failed");
            }
        });

    }

    @Test
    public void testSynchronousTokensService_DeleteToken() throws IOException {
        SynchronousTokensService service = this.client.getTokensService();
        assertThat(service).isNotNull();

        Token Token = new Token(Utils.generateRandomInt(0, Integer.MAX_VALUE - 1), 1);
        Response<Token> createResponse = service.createTokenSync(Token);
        assertThat(createResponse).isNotNull();
        assertThat(createResponse.body()).isNotNull();
        assertThat(createResponse.body().getTokenId()).isNotNull();
        assertThat(createResponse.body().getAppId()).isNotNull();
        assertThat(createResponse.body().getCreatedAt()).isNotNull();
        assertThat(createResponse.body().getUpdatedAt()).isNotNull();

        Integer tokenId = createResponse.body().getTokenId();

        Response<Boolean> deleteResponse = service.deleteTokenSync(tokenId);
        assertThat(deleteResponse).isNotNull();
        assertThat(deleteResponse.body()).isNotNull();
        assertThat(deleteResponse.body()).isTrue();
    }

    @Test
    public void testAsychronousTokensService_DeleteToken() throws InterruptedException, ExecutionException {
        AsynchronousTokensService service = this.client.getTokensService();
        assertThat(service).isNotNull();

        Token token = new Token(Utils.generateRandomInt(0, Integer.MAX_VALUE - 1), 1);
        service.createTokenAsync(token, new Callback<Token>( ) {

            @Override
            public void onResponse(Call<Token> call, Response<Token> createResponse) {
                assertThat(createResponse).isNotNull();
                assertThat(createResponse.body()).isNotNull();
                assertThat(createResponse.body().getTokenId()).isNotNull();
                assertThat(createResponse.body().getAppId()).isNotNull();
                assertThat(createResponse.body().getCreatedAt()).isNotNull();
                assertThat(createResponse.body().getUpdatedAt()).isNotNull();

                Integer tokenId = createResponse.body().getTokenId();

                service.deleteTokenAsync(tokenId, new Callback<Boolean>() {
                    @Override
                    public void onResponse(Call<Boolean> call, Response<Boolean> deleteResponse) {
                        assertThat(deleteResponse).isNotNull();
                        assertThat(deleteResponse.body()).isNotNull();
                        assertThat(deleteResponse.body()).isTrue();
                    }

                    @Override
                    public void onFailure(Call<Boolean> call, Throwable t) {
                        fail("Test Failed");
                    }
                });
            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                fail("Test Failed");
            }

        });
    }

    @Test
    public void testSynchronousTokensService_UpdateToken() throws IOException {
        SynchronousTokensService service = this.client.getTokensService();
        assertThat(service).isNotNull();

        Token token = new Token(Utils.generateRandomInt(0, Integer.MAX_VALUE - 1), 1);
        Response<Token> createResponse = service.createTokenSync(token);
        assertThat(createResponse).isNotNull();
        assertThat(createResponse.body()).isNotNull();
        assertThat(createResponse.body().getTokenId()).isNotNull();
        assertThat(createResponse.body().getAppId()).isNotNull();
        assertThat(createResponse.body().getCreatedAt()).isNotNull();
        assertThat(createResponse.body().getUpdatedAt()).isNotNull();

        Integer tokenId = createResponse.body().getTokenId();
        Integer appId = createResponse.body().getAppId();

        Token updateToken = new Token(tokenId, appId, "Enjin Coin", null, null, null, null, null, null, null, null, null, null, null);
        Response<Token> updateResponse = service.updateTokenSync(tokenId, updateToken);
        assertThat(updateResponse).isNotNull();
        assertThat(updateResponse.body()).isNotNull();
        assertThat(updateResponse.body().getCreator()).isEqualToIgnoringCase(updateToken.getCreator());

        Response<Boolean> deleteResponse = service.deleteTokenSync(tokenId);
        assertThat(deleteResponse).isNotNull();
        assertThat(deleteResponse.body()).isNotNull();
        assertThat(deleteResponse.body()).isTrue();
    }

    @Test
    public void testAsychronousTokensService_UpdateToken() throws InterruptedException, ExecutionException {
        AsynchronousTokensService service = this.client.getTokensService();
        assertThat(service).isNotNull();

        Token token = new Token(Utils.generateRandomInt(0, Integer.MAX_VALUE - 1), 1);
        service.createTokenAsync(token, new Callback<Token>() {

            @Override
            public void onResponse(Call<Token> call, Response<Token> createResponse) {
                assertThat(createResponse).isNotNull();
                assertThat(createResponse.body()).isNotNull();
                assertThat(createResponse.body().getTokenId()).isNotNull();
                assertThat(createResponse.body().getAppId()).isNotNull();
                assertThat(createResponse.body().getCreatedAt()).isNotNull();
                assertThat(createResponse.body().getUpdatedAt()).isNotNull();

                Integer tokenId = createResponse.body().getTokenId();
                Integer appId = createResponse.body().getAppId();

                Token updateToken = new Token(tokenId, appId, "Enjin Coin", null, null, null, null, null, null, null, null, null, null, null);
                service.updateTokenAsync(tokenId, updateToken, new Callback<Token>() {

                    @Override
                    public void onResponse(Call<Token> call, Response<Token> updateResponse) {
                        assertThat(updateResponse).isNotNull();
                        assertThat(updateResponse.body()).isNotNull();
                        assertThat(updateResponse.body().getCreator()).isEqualToIgnoringCase(updateToken.getCreator());

                        service.deleteTokenAsync(tokenId, new Callback<Boolean>() {
                            @Override
                            public void onResponse(Call<Boolean> call, Response<Boolean> deleteResponse) {
                                assertThat(deleteResponse).isNotNull();
                                assertThat(deleteResponse.body()).isNotNull();
                                assertThat(deleteResponse.body()).isTrue();
                            }

                            @Override
                            public void onFailure(Call<Boolean> call, Throwable t) {
                                fail("Test Failed");
                            }
                        });

                    }

                    @Override
                    public void onFailure(Call<Token> call, Throwable t) {
                        fail("Test Failed");
                    }
                });

            }

            @Override
            public void onFailure(Call<Token> call, Throwable t) {
                fail("Test Failed");
            }

        });
    }
}
