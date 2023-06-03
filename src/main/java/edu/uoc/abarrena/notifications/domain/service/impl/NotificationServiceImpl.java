package edu.uoc.abarrena.notifications.domain.service.impl;

import edu.uoc.abarrena.notifications.domain.model.Notification;
import edu.uoc.abarrena.notifications.domain.repository.NotificationRepository;
import edu.uoc.abarrena.notifications.domain.service.NotificationService;

import java.util.List;

public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public Long createNotification(Notification notification) {
        setNotificationMessage(notification);
        return notificationRepository.save(notification);
    }

    private void setNotificationMessage(Notification notification) {
        switch (notification.getType()) {
            case NEW_RESULT:
                notification.setMessage("Your search has new results");
                break;
            case RESERVATION_PENDING:
                notification.setMessage("New reservation pending");
                break;
            case RESERVATION_CONFIRMED:
                notification.setMessage("Reservation confirmed");
                break;
            case RESERVATION_REJECTED:
                notification.setMessage("Reservation rejected");
                break;
            default:
                break;
        }
    }

    @Override
    public void markNotificationAsRead(Long notificationId) {
        Notification notification = new Notification(notificationId);
        notificationRepository.update(notification);
    }

    @Override
    public List<Notification> getNotificationsByUserId(Long userId) {
        return notificationRepository.findByUserId(userId);
    }
}
