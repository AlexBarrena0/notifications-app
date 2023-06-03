package edu.uoc.abarrena.notifications.application.rest;

import edu.uoc.abarrena.notifications.application.dto.response.NotificationDto;
import edu.uoc.abarrena.notifications.application.dto.response.Result;
import edu.uoc.abarrena.notifications.domain.converter.NotificationConverter;
import edu.uoc.abarrena.notifications.domain.model.Notification;
import edu.uoc.abarrena.notifications.domain.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(NotificationController.BASE_PATH)
public class NotificationController {

    public static final String BASE_PATH = "/notifications";

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public Result<List<NotificationDto>> getNotifications(@RequestParam Long userId) {
        List<NotificationDto> notifications = NotificationConverter.INSTANCE.toDto(notificationService.getNotificationsByUserId(userId));
        return new Result<>(notifications, null);
    }

    @PatchMapping("/{id}")
    public Result<Boolean> markAsRead(@PathVariable Long id) {
        notificationService.markNotificationAsRead(id);
        return new Result<>(true, "Notification marked as read");
    }
}
