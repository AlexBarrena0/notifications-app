package edu.uoc.abarrena.notifications.domain.config;

import edu.uoc.abarrena.notifications.domain.repository.NotificationRepository;
import edu.uoc.abarrena.notifications.domain.service.NotificationService;
import edu.uoc.abarrena.notifications.domain.service.impl.NotificationServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainConfig {

    @Bean
    public NotificationService notificationService(NotificationRepository notificationRepository) {
        return new NotificationServiceImpl(notificationRepository);
    }

}