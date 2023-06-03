package edu.uoc.abarrena.notifications.infrastructure.websocket;

import edu.uoc.abarrena.notifications.domain.model.Notification;
import edu.uoc.abarrena.notifications.domain.service.NotificationSender;
import org.springframework.messaging.simp.SimpMessagingTemplate;

public class NotificationSenderImpl implements NotificationSender {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public NotificationSenderImpl(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public void notify(Notification notification) {
        simpMessagingTemplate.convertAndSend("/user?id=" + notification.getUserId(), notification);
    }

}
