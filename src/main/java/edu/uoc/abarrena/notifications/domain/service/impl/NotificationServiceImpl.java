package edu.uoc.abarrena.notifications.domain.service.impl;

import edu.uoc.abarrena.notifications.domain.model.Notification;
import edu.uoc.abarrena.notifications.domain.repository.NotificationRepository;
import edu.uoc.abarrena.notifications.domain.service.NotificationSenderService;
import edu.uoc.abarrena.notifications.domain.service.NotificationService;

import java.util.List;

public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;

    private final NotificationSenderService notificationSenderService;

    public NotificationServiceImpl(NotificationRepository notificationRepository, NotificationSenderService notificationSenderService) {
        this.notificationRepository = notificationRepository;
        this.notificationSenderService = notificationSenderService;
    }

    @Override
    public Long createNotification(Notification notification) {
        setNotificationDetails(notification);
        Long id = notificationRepository.save(notification);
        notification.setId(id);
        notificationSenderService.notify(notification);
        return id;
    }

    private void setNotificationDetails(Notification notification) {
        switch (notification.getType()) {
            case NEW_RESULT -> {
                notification.setMessage("Your favourite search has new results");
                StringBuilder url = new StringBuilder();
                if (notification.getParams().containsKey("destinationId")) {
                    url.append("&destinationId=").append(notification.getParams().get("destinationId"));
                }
                if (notification.getParams().containsKey("startDate")) {
                    url.append("&dateFrom=").append(notification.getParams().get("startDate"));
                }
                if (notification.getParams().containsKey("endDate")) {
                    url.append("&dateTo=").append(notification.getParams().get("endDate"));
                }
                if (url.length() > 0) {
                    url.replace(0, 1, "?");
                }
                notification.setUrl(url.toString());
            }
            case RESERVATION_PENDING -> {
                notification.setMessage("New reservation pending");
                notification.setUrl("/traveler/" + notification.getParams().get("travelerId") + "?bookingId=" + notification.getParams().get("bookingId"));
            }
            case RESERVATION_CONFIRMED -> {
                notification.setMessage("Reservation confirmed");
                notification.setUrl("/cruise/" + notification.getParams().get("cruiseId"));
            }
            case RESERVATION_REJECTED -> {
                notification.setMessage("Reservation rejected");
                notification.setUrl("/cruise/" + notification.getParams().get("cruiseId"));
            }
            default -> {
            }
        }
    }

    @Override
    public void markNotificationAsRead(Long notificationId) {
        Notification notification = new Notification(notificationId);
        notificationRepository.update(notification);
    }

    @Override
    public List<Notification> getNotificationsByUserId(Long userId, Boolean read) {
        return notificationRepository.findByUserId(userId, read);
    }
}
