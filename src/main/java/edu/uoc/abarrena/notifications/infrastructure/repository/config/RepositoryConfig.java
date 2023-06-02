package edu.uoc.abarrena.notifications.infrastructure.repository.config;

import edu.uoc.abarrena.notifications.domain.repository.NotificationRepository;
import edu.uoc.abarrena.notifications.infrastructure.repository.mybatis.NotificationRepositoryImpl;
import edu.uoc.abarrena.notifications.infrastructure.repository.mybatis.mapper.NotificationMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {

    @Bean
    public NotificationRepository notificationRepository(NotificationMapper notificationMapper) {
        return new NotificationRepositoryImpl(notificationMapper);
    }
}
