package edu.uoc.abarrena.notifications.domain.config;

import edu.uoc.abarrena.notifications.domain.repository.NotificationRepository;
import edu.uoc.abarrena.notifications.domain.service.NotificationSenderService;
import edu.uoc.abarrena.notifications.domain.service.NotificationService;
import edu.uoc.abarrena.notifications.domain.service.impl.NotificationSenderServiceImpl;
import edu.uoc.abarrena.notifications.domain.service.impl.NotificationServiceImpl;
import edu.uoc.abarrena.notifications.infrastructure.websocket.WebSocketSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {

    @Bean
    public NotificationService notificationService(NotificationRepository notificationRepository, NotificationSenderService notificationSenderService) {
        return new NotificationServiceImpl(notificationRepository, notificationSenderService);
    }

    @Bean
    public NotificationSenderService notificationSenderService(WebSocketSender webSocketSender) {
        return new NotificationSenderServiceImpl(webSocketSender);
    }

}
