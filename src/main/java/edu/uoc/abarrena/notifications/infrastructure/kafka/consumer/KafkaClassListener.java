package edu.uoc.abarrena.notifications.infrastructure.kafka.consumer;

import edu.uoc.abarrena.notifications.domain.model.Notification;
import edu.uoc.abarrena.notifications.domain.service.NotificationService;
import edu.uoc.abarrena.notifications.infrastructure.kafka.KafkaConstants;
import org.springframework.kafka.annotation.KafkaListener;

public class KafkaClassListener {

    private final NotificationService notificationService;

    public KafkaClassListener(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @KafkaListener(
            topics = {
                    KafkaConstants.FAVOURITE_SEARCH_TOPIC + KafkaConstants.SEPARATOR + KafkaConstants.COMMAND_ADD,
                    KafkaConstants.BOOKINGS_TOPIC + KafkaConstants.SEPARATOR + KafkaConstants.COMMAND_ADD
            },
            groupId = KafkaConstants.GROUP_ID
    )
    public void listen(Notification notification) {
        notificationService.createNotification(notification);
    }
}
