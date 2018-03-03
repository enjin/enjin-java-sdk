package io.enjincoin.sdk.client.service.identities;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.Test;

import io.enjincoin.sdk.client.service.BaseLiveServiceTest;
import io.enjincoin.sdk.client.vo.identity.GetIdentityResponseVO;
import io.enjincoin.sdk.client.vo.identity.ImmutableFieldVO;

/**
 * Calls out to the actual api
 * Will have the disabled annotation in place usually but will be useful for testing the actual api
 *
 */
public class LiveIdentitiesServiceTest extends BaseLiveServiceTest{


    @Test
    public void testSychronousIdentitiesService_GetIdentities() {
        SynchronousIdentitiesService identitiesService = this.client.getIdentitiesService();
        assertThat(identitiesService).isNotNull();

        GetIdentityResponseVO[] getIdentityResponseVOArray = identitiesService.getIdentitiesSync();
        assertThat(getIdentityResponseVOArray).isNotNull();

        for (GetIdentityResponseVO getIdentityResponseVO : getIdentityResponseVOArray) {
            if (getIdentityResponseVO.getFields().isPresent()) {

                for (ImmutableFieldVO fieldVO : getIdentityResponseVO.getFields().get()) {
                    assertThat(fieldVO).isNotNull();
                }
            }
        }
    }

    @Test
    public void testAsychronousIdentitiesService_GetIdentities() throws InterruptedException, ExecutionException {
        AsynchronousIdentitiesService identitiesService = this.client.getIdentitiesService();
        assertThat(identitiesService).isNotNull();

        CompletableFuture<GetIdentityResponseVO[]> getIdentityResponseVOArrayCf = identitiesService.getIdentitiesAsync();
        assertThat(getIdentityResponseVOArrayCf).isNotNull();
        assertThat(getIdentityResponseVOArrayCf.get()).isNotNull();
        GetIdentityResponseVO[] getIdentityResponseVOArray = getIdentityResponseVOArrayCf.get();

        for (GetIdentityResponseVO getIdentityResponseVO : getIdentityResponseVOArray) {
            if (getIdentityResponseVO.getFields().isPresent()) {

                for (ImmutableFieldVO fieldVO : getIdentityResponseVO.getFields().get()) {
                    assertThat(fieldVO).isNotNull();
                }
            }
        }
    }

    @Test
    public void testSychronousIdentitiesService_GetIdentityById() {
        SynchronousIdentitiesService identitiesService = this.client.getIdentitiesService();
        assertThat(identitiesService).isNotNull();

        GetIdentityResponseVO[] getIdentityResponseVOArray = identitiesService.getIdentitiesSync();
        assertThat(getIdentityResponseVOArray).isNotNull();

        Integer identityId = getIdentityResponseVOArray[0].getId().get();

        GetIdentityResponseVO getIdentityByIdResponseVO = identitiesService.getIdentitySync(identityId);
        assertThat(getIdentityByIdResponseVO).isNotNull();

        if (getIdentityByIdResponseVO.getFields().isPresent()) {

            for (ImmutableFieldVO fieldVO : getIdentityByIdResponseVO.getFields().get()) {
                assertThat(fieldVO).isNotNull();
            }
        }
    }

    @Test
    public void testAsychronousIdentitiesService_GetIdentityById() throws InterruptedException, ExecutionException {
        AsynchronousIdentitiesService identitiesService = this.client.getIdentitiesService();
        assertThat(identitiesService).isNotNull();

        CompletableFuture<GetIdentityResponseVO[]> getIdentityResponseVOArrayCf = identitiesService.getIdentitiesAsync();
        assertThat(getIdentityResponseVOArrayCf).isNotNull();
        assertThat(getIdentityResponseVOArrayCf.get()).isNotNull();
        GetIdentityResponseVO[] getIdentityResponseVOArray = getIdentityResponseVOArrayCf.get();

        Integer identityId = getIdentityResponseVOArray[0].getId().get();

        CompletableFuture<GetIdentityResponseVO>  getIdentityByIdResponseVOCf = identitiesService.getIdentityAsync(identityId);
        assertThat(getIdentityByIdResponseVOCf).isNotNull();
        assertThat(getIdentityByIdResponseVOCf.get()).isNotNull();
        GetIdentityResponseVO  getIdentityByIdResponseVO = getIdentityByIdResponseVOCf.get();

        if (getIdentityByIdResponseVO.getFields().isPresent()) {

            for (ImmutableFieldVO fieldVO : getIdentityByIdResponseVO.getFields().get()) {
                assertThat(fieldVO).isNotNull();
            }
        }
    }
}
