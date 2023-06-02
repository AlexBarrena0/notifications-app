package edu.uoc.abarrena.notifications.domain.repository;

import edu.uoc.abarrena.notifications.domain.model.Notification;

import java.util.List;

public interface NotificationRepository {

    /**
     * Create a new notification
     * @param notification the notification to create
     * @return the notification id
     */
    public Long save(Notification notification);

    /**
     * Mark a notification as read
     * @param notification the notification to update
     */
    public void update(Notification notification);

    /**
     * Get all notifications by user id
     * @param userId the user id
     * @return the list of notifications
     */
    public List<Notification> findByUserId(Long userId);
}
