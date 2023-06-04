package edu.uoc.abarrena.notifications.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Notification {

    private Long id;
    private String message;
    private NotificationType type;
    private Long userId;
    private Boolean read;
    private HashMap<String, Object> params;
    private String url;

    public Notification(Long id) {
        this.id = id;
        this.read = true;
    }
}
