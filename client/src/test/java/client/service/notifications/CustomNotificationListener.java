package client.service.notifications;

import java.util.logging.Logger;

import com.enjin.enjincoin.sdk.client.service.notifications.NotificationListener;
import com.enjin.enjincoin.sdk.client.vo.notifications.NotificationEvent;

public class CustomNotificationListener implements NotificationListener{

    /**
     * Logger used by this class.
     */
    private static final Logger LOGGER = Logger.getLogger(CustomNotificationListener.class.getName());


    @Override
    public void notificationReceived(NotificationEvent event) {
        if (event != null) {
            LOGGER.info(String.format("notificationReceived: Type:%s, Channel:%s, Data:%s", event.getNotificationType(), event.getChannel(), event.getSourceData()));
        }
    }

}
