package edu.uoc.abarrena.notifications.infrastructure.websocket;

import edu.uoc.abarrena.notifications.domain.model.Notification;
import org.springframework.messaging.simp.SimpMessagingTemplate;

public class WebSocketSender {

    private final SimpMessagingTemplate simpMessagingTemplate;

    public WebSocketSender(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public void notify(Notification notification) {
        simpMessagingTemplate.convertAndSend("/user?id=" + notification.getUserId(), notification);
    }

}
