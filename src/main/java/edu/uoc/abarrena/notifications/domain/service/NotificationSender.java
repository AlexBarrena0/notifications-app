package edu.uoc.abarrena.notifications.domain.service;

import edu.uoc.abarrena.notifications.domain.model.Notification;

public interface NotificationSender {

    /**
     * Send a notification
     * @param notification the notification to send
     */
    public void notify(Notification notification);
}
