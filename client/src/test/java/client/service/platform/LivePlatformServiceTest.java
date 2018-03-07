package client.service.platform;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.junit.Test;

import client.service.BaseLiveServiceTest;
import io.enjincoin.sdk.client.service.platform.AsynchronousPlatformService;
import io.enjincoin.sdk.client.service.platform.SynchronousPlatformService;
import io.enjincoin.sdk.client.service.platform.vo.AppDetail;
import io.enjincoin.sdk.client.service.platform.vo.NotificationDetails;
import io.enjincoin.sdk.client.service.platform.vo.PlatformDetails;
import io.enjincoin.sdk.client.service.platform.vo.PlatformResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Calls out to the actual api Will have the disabled annotation in place
 * usually but will be useful for testing the actual api
 */
public class LivePlatformServiceTest extends BaseLiveServiceTest {

    @Test
    public void testSynchronousPlatformService_GetPlatform() throws IOException {
        SynchronousPlatformService platformService = this.client.getPlatformService();
        assertThat(platformService).isNotNull();

        Response<PlatformResponseBody> platformResponse = platformService.getPlatformSync();
        assertThat(platformResponse).isNotNull();
        assertThat(platformResponse.body()).isNotNull();

        PlatformDetails platformDetails = platformResponse.body().getPlatformDetails();

        AppDetail[] appDetails = platformResponse.body().getAppDetails();
        assertThat(platformDetails).isNotNull();
        assertThat(platformDetails.getId()).isNotNull();
        assertThat(platformDetails.getName()).isNotNull();

        NotificationDetails notificationDetails = platformResponse.body().getNotificationDetails();
        assertThat(notificationDetails).isNotNull();
        assertThat(notificationDetails.getMobileDetails()).isNotNull();
        assertThat(notificationDetails.getMobileDetails().getType()).isNotNull();
        assertThat(notificationDetails.getSdkDetails()).isNotNull();
        assertThat(notificationDetails.getSdkDetails().getAppId()).isNotNull();
        assertThat(notificationDetails.getSdkDetails().getDriver()).isNotNull();
        assertThat(notificationDetails.getSdkDetails().getKey()).isNotNull();
        assertThat(notificationDetails.getSdkDetails().getOptions()).isNotNull();
        assertThat(notificationDetails.getSdkDetails().getOptions().getCluster()).isNotNull();
        assertThat(notificationDetails.getSdkDetails().getOptions().getEncrypted()).isNotNull();

        assertThat(appDetails).isNotNull();

        for (AppDetail appDetail : appDetails) {
            assertThat(appDetail).isNotNull();
            assertThat(appDetail.getId()).isNotNull();
            assertThat(appDetail.getName()).isNotNull();
            //assertThat(appDetail.getImage()).isNotNull();
            //assertThat(appDetail.getDescription()).isNotNull();
        }
    }

    @Test
    public void testAsychronousPlatformService_GetPlatform() throws InterruptedException, ExecutionException {
        AsynchronousPlatformService platformService = this.client.getPlatformService();
        assertThat(platformService).isNotNull();

        platformService.getPlatformAsync(new Callback<PlatformResponseBody>() {

            @Override
            public void onResponse(Call<PlatformResponseBody> call, Response<PlatformResponseBody> platformResponse) {
                assertThat(platformResponse).isNotNull();
                assertThat(platformResponse.body()).isNotNull();

                PlatformDetails platformDetails = platformResponse.body().getPlatformDetails();

                AppDetail[] appDetails = platformResponse.body().getAppDetails();
                assertThat(platformDetails).isNotNull();
                assertThat(platformDetails.getId()).isNotNull();
                assertThat(platformDetails.getName()).isNotNull();

                NotificationDetails notificationDetails = platformResponse.body().getNotificationDetails();
                assertThat(notificationDetails).isNotNull();
                assertThat(notificationDetails.getMobileDetails()).isNotNull();
                assertThat(notificationDetails.getMobileDetails().getType()).isNotNull();
                assertThat(notificationDetails.getSdkDetails()).isNotNull();
                assertThat(notificationDetails.getSdkDetails().getAppId()).isNotNull();
                assertThat(notificationDetails.getSdkDetails().getDriver()).isNotNull();
                assertThat(notificationDetails.getSdkDetails().getKey()).isNotNull();
                assertThat(notificationDetails.getSdkDetails().getOptions()).isNotNull();
                assertThat(notificationDetails.getSdkDetails().getOptions().getCluster()).isNotNull();
                assertThat(notificationDetails.getSdkDetails().getOptions().getEncrypted()).isNotNull();

                assertThat(appDetails).isNotNull();

                for (AppDetail appDetail : appDetails) {
                    assertThat(appDetail).isNotNull();
                    assertThat(appDetail.getId()).isNotNull();
                    assertThat(appDetail.getName()).isNotNull();
                    //assertThat(appDetail.getImage()).isNotNull();
                    //assertThat(appDetail.getDescription()).isNotNull();
                }
            }

            @Override
            public void onFailure(Call<PlatformResponseBody> call, Throwable t) {
                fail("Test Failed");
            }
        });
    }
}
