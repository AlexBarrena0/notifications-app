package edu.uoc.abarrena.notifications.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    private Long id;
    private String message;
    private NotificationType type;
    private Long userId;
    private Boolean read;

    public Notification(Long id) {
        this.id = id;
        this.read = true;
    }
}
