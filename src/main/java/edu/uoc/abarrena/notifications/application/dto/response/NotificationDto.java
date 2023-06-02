package edu.uoc.abarrena.notifications.application.dto.response;

import edu.uoc.abarrena.notifications.domain.model.NotificationType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotificationDto {

    private Long id;
    private String message;
    private NotificationType type;
    private Long userId;
    private Boolean read;
}
