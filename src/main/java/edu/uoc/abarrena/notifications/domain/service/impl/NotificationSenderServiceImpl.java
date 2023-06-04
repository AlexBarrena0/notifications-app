package edu.uoc.abarrena.notifications.domain.service.impl;

import edu.uoc.abarrena.notifications.domain.model.Notification;
import edu.uoc.abarrena.notifications.domain.service.NotificationSenderService;
import edu.uoc.abarrena.notifications.infrastructure.websocket.WebSocketSender;

public class NotificationSenderServiceImpl implements NotificationSenderService {

    private final WebSocketSender webSocketSender;

    public NotificationSenderServiceImpl(WebSocketSender webSocketSender) {
        this.webSocketSender = webSocketSender;
    }

    @Override
    public void notify(Notification notification) {
        webSocketSender.notify(notification);
    }
}
