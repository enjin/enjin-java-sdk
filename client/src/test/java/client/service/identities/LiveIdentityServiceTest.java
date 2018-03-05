package client.service.identities;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import client.service.BaseLiveServiceTest;
import org.junit.Test;

import io.enjincoin.sdk.client.service.identity.AsynchronousIdentityService;
import io.enjincoin.sdk.client.service.identity.SynchronousIdentityService;
import io.enjincoin.sdk.client.service.identity.vo.LinkIdentityRequestBody;
import io.enjincoin.sdk.client.service.identity.vo.LinkIdentityResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Calls out to the actual api
 * Will have the disabled annotation in place usually but will be useful for testing the actual api
 *
 */
public class LiveIdentityServiceTest extends BaseLiveServiceTest {

    @Test
    public void testSynchronousIdentitiesService_LinkIdentity() throws IOException {
        SynchronousIdentityService identityService = this.client.getIdentityService();
        assertThat(identityService).isNotNull();

        String ethereumAddress = "TestEthereumAddress_"+System.currentTimeMillis();

        String linkingCode = "av"+System.currentTimeMillis();
        LinkIdentityRequestBody linkIdentityRequestVO = new LinkIdentityRequestBody(ethereumAddress);
        Response<LinkIdentityResponseBody> linkIdentityResponseVO = identityService.linkIdentitySync(linkingCode, linkIdentityRequestVO);
        assertThat(linkIdentityResponseVO).isNotNull();
        assertThat(linkIdentityResponseVO.body()).isNotNull();
        //assertThat(linkIdentityResponseVO.body().getId()).isNotNull();
        //assertThat(linkIdentityResponseVO.body().getEthereumAddress()).isNotNull();
        //assertThat(linkIdentityResponseVO.body().getCreatedAt()).isNotNull();
        //assertThat(linkIdentityResponseVO.body().getUpdatedAt()).isNotNull();
        //assertThat(linkIdentityResponseVO.body().getUserId()).isNotNull();
        //assertThat(linkIdentityResponseVO.body().getLinkingCode()).isNotNull();
    }

    @Test
    public void testAsychronousIdentitiesService_LinkIdentity() throws InterruptedException, ExecutionException {
        AsynchronousIdentityService identityService = this.client.getIdentityService();
        assertThat(identityService).isNotNull();

        String ethereumAddress = "TestEthereumAddress_"+System.currentTimeMillis();

        String linkingCode = "av"+System.currentTimeMillis();
        LinkIdentityRequestBody linkIdentityRequestVO = new LinkIdentityRequestBody(ethereumAddress);
        identityService.linkIdentityAsync(linkingCode, linkIdentityRequestVO, new Callback<LinkIdentityResponseBody>() {

            @Override
            public void onResponse(Call<LinkIdentityResponseBody> call, Response<LinkIdentityResponseBody> response) {
                assertThat(response).isNotNull();
                assertThat(response.body()).isNotNull();

                LinkIdentityResponseBody linkIdentityResponseVO = response.body();
                assertThat(linkIdentityResponseVO).isNotNull();
                //assertThat(linkIdentityResponseVO.getId()).isNotNull();
                //assertThat(linkIdentityResponseVO.getEthereumAddress()).isNotNull();
                //assertThat(linkIdentityResponseVO.getCreatedAt()).isNotNull();
                //assertThat(linkIdentityResponseVO.getUpdatedAt()).isNotNull();
                //assertThat(linkIdentityResponseVO.getUserId()).isNotNull();
                //assertThat(linkIdentityResponseVO.getLinkingCode()).isNotNull();
            }

            @Override
            public void onFailure(Call<LinkIdentityResponseBody> call, Throwable t) {
                fail("Test failed");
            }
        });


    }
}
