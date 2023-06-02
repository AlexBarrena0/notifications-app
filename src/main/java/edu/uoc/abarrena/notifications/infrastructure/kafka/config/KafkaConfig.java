package edu.uoc.abarrena.notifications.infrastructure.kafka.config;

import edu.uoc.abarrena.notifications.domain.service.NotificationService;
import edu.uoc.abarrena.notifications.infrastructure.kafka.consumer.KafkaClassListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Bean
    public KafkaClassListener kafkaClassListener(NotificationService notificationService) {
        return new KafkaClassListener(notificationService);
    }
}
