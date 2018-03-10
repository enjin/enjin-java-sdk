package client.service.notifications;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;

import org.junit.Test;

import client.service.BaseLiveServiceTest;
import io.enjincoin.sdk.client.service.notifications.NotificationsService;

/**
 * Calls out to the actual api Will have the disabled annotation in place
 * usually but will be useful for testing the actual api
 */
public class LiveNotificationsServiceTest extends BaseLiveServiceTest {

    @Test
    public void testSynchronousUsersService_GetUsers() throws IOException {
        NotificationsService notificationsService = this.client.getNotificationsService();
        assertThat(notificationsService).isNotNull();

        boolean result = notificationsService.start();
        System.out.println("result:"+result);


        CustomNotificationListener listener = new CustomNotificationListener();
        notificationsService.addNotificationListener(listener);

        while(true) {

        }
    }


}
