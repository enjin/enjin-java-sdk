package client.service.tokens;

import client.service.BaseLiveServiceTest;
import io.enjincoin.sdk.client.service.tokens.AsynchronousTokensService;
import io.enjincoin.sdk.client.service.tokens.SynchronousTokensService;
import io.enjincoin.sdk.client.service.tokens.vo.Token;
import io.enjincoin.sdk.client.util.Utils;
import org.junit.Test;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

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
            assertThat(token.getTokenId().isPresent()).isTrue();
            assertThat(token.getAppId()).isNotNull();
            assertThat(token.getAppId().isPresent()).isTrue();
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
                    assertThat(token.getTokenId().isPresent()).isTrue();
                    assertThat(token.getAppId()).isNotNull();
                    assertThat(token.getAppId().isPresent()).isTrue();
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

        Integer tokenId = createResponse.body().getTokenId().get();

        Response<Token> getResponse = service.getTokenSync(tokenId);
        assertThat(getResponse).isNotNull();
        assertThat(getResponse.body()).isNotNull();
        assertThat(getResponse.body().getTokenId()).isNotNull();
        assertThat(getResponse.body().getTokenId().isPresent()).isTrue();
        assertThat(getResponse.body().getAppId()).isNotNull();
        assertThat(getResponse.body().getAppId().isPresent()).isTrue();

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

                Integer tokenId = createResponse.body().getTokenId().get();

                service.getTokenAsync(tokenId, new Callback<Token>() {

                    @Override
                    public void onResponse(Call<Token> call, Response<Token> getResponse) {
                        assertThat(getResponse).isNotNull();
                        assertThat(getResponse.body()).isNotNull();
                        assertThat(getResponse.body().getTokenId()).isNotNull();
                        assertThat(getResponse.body().getTokenId().isPresent()).isTrue();
                        assertThat(getResponse.body().getAppId()).isNotNull();
                        assertThat(getResponse.body().getAppId().isPresent()).isTrue();

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

        Integer tokenId = createResponse.body().getTokenId().get();

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

                Integer tokenId = createResponse.body().getTokenId().get();

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

        Integer tokenId = createResponse.body().getTokenId().get();

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

                Integer tokenId = createResponse.body().getTokenId().get();

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

        Integer tokenId = createResponse.body().getTokenId().get();
        Integer appId = createResponse.body().getAppId().get();

        Token updateToken = new Token(tokenId, appId, "Enjin Coin", null, null, null, null, null, null, null, null, null, null, null);
        Response<Token> updateResponse = service.updateTokenSync(tokenId, updateToken);
        assertThat(updateResponse).isNotNull();
        assertThat(updateResponse.body()).isNotNull();
        assertThat(updateResponse.body().getCreator().isPresent()).isTrue();
        assertThat(updateResponse.body().getCreator().get()).isEqualToIgnoringCase(updateToken.getCreator().get());

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

                Integer tokenId = createResponse.body().getTokenId().get();
                Integer appId = createResponse.body().getAppId().get();

                Token updateToken = new Token(tokenId, appId, "Enjin Coin", null, null, null, null, null, null, null, null, null, null, null);
                service.updateTokenAsync(tokenId, updateToken, new Callback<Token>() {

                    @Override
                    public void onResponse(Call<Token> call, Response<Token> updateResponse) {
                        assertThat(updateResponse).isNotNull();
                        assertThat(updateResponse.body()).isNotNull();
                        assertThat(updateResponse.body().getCreator().isPresent()).isTrue();
                        assertThat(updateResponse.body().getCreator().get()).isEqualToIgnoringCase(updateToken.getCreator().get());

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
