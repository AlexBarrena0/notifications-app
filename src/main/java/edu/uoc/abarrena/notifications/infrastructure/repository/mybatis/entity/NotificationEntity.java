package edu.uoc.abarrena.notifications.infrastructure.repository.mybatis.entity;

import edu.uoc.abarrena.notifications.domain.model.NotificationType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NotificationEntity {

    private Long id;
    private String message;
    private NotificationType type;
    private Long userId;
    private Boolean read;
}
