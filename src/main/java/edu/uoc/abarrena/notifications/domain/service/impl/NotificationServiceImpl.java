package edu.uoc.abarrena.notifications.domain.service.impl;

import edu.uoc.abarrena.notifications.domain.model.Notification;
import edu.uoc.abarrena.notifications.domain.repository.NotificationRepository;
import edu.uoc.abarrena.notifications.domain.service.NotificationSender;
import edu.uoc.abarrena.notifications.domain.service.NotificationService;
import edu.uoc.abarrena.notifications.infrastructure.websocket.NotificationSenderImpl;

import java.util.List;

public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    private final NotificationSender notificationSender;

    public NotificationServiceImpl(NotificationRepository notificationRepository, NotificationSender notificationSender) {
        this.notificationRepository = notificationRepository;
        this.notificationSender = notificationSender;
    }

    @Override
    public Long createNotification(Notification notification) {
        setNotificationMessage(notification);
        Long id = notificationRepository.save(notification);
        notification.setId(id);
        notificationSender.notify(notification);
        return id;
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
