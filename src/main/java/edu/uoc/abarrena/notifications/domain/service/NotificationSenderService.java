package edu.uoc.abarrena.notifications.domain.service;

import edu.uoc.abarrena.notifications.domain.model.Notification;

public interface NotificationSenderService {

    /**
     * Send a notification
     *
     * @param notification the notification to send
     */
    void notify(Notification notification);
}
