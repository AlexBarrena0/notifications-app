package edu.uoc.abarrena.notifications.domain.service;

import edu.uoc.abarrena.notifications.domain.model.Notification;

import java.util.List;

public interface NotificationService {

    /**
     * Create a new notification
     * @param notification the notification to create
     * @return the notification id
     */
    public Long createNotification(Notification notification);

    /**
     * Mark a notification as read
     * @param notificationId the notification id
     */
    public void markNotificationAsRead(Long notificationId);

    /**
     * Get all notifications by user id
     * @param userId the user id
     * @return the list of notifications
     */
    public List<Notification> getNotificationsByUserId(Long userId);
}
