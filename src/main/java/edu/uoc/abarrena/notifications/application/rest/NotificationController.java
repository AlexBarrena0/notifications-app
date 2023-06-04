package edu.uoc.abarrena.notifications.application.rest;

import edu.uoc.abarrena.notifications.application.dto.response.NotificationDto;
import edu.uoc.abarrena.notifications.application.dto.response.Result;
import edu.uoc.abarrena.notifications.domain.converter.NotificationConverter;
import edu.uoc.abarrena.notifications.domain.service.NotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(NotificationController.BASE_PATH)
public class NotificationController {

    public static final String BASE_PATH = "/notifications";

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping
    public Result<List<NotificationDto>> getNotifications(@RequestParam Long userId, @RequestParam(required = false) Boolean read) {
        List<NotificationDto> notifications = NotificationConverter.INSTANCE.toDto(notificationService.getNotificationsByUserId(userId, read));
        return new Result<>(notifications, null);
    }

    @PatchMapping("/{id}")
    public Result<Boolean> markAsRead(@PathVariable Long id) {
        notificationService.markNotificationAsRead(id);
        return new Result<>(true, "Notification marked as read");
    }
}
