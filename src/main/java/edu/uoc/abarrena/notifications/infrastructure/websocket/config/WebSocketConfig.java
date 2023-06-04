package edu.uoc.abarrena.notifications.infrastructure.websocket.config;

import edu.uoc.abarrena.notifications.infrastructure.websocket.WebSocketSender;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws-notifications")
                .setAllowedOriginPatterns("*")
                .withSockJS();
        // Required because not all browsers support websocket
        registry.addEndpoint("/ws-notifications")
                .setAllowedOriginPatterns("*");
    }

    @Bean
    public WebSocketSender webSocketSender(SimpMessagingTemplate simpMessagingTemplate) {
        return new WebSocketSender(simpMessagingTemplate);
    }
}
