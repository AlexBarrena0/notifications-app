package edu.uoc.abarrena.notifications.domain.converter;

import edu.uoc.abarrena.notifications.domain.model.Notification;
import edu.uoc.abarrena.notifications.infrastructure.repository.mybatis.entity.NotificationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface NotificationConverter {

    public static final NotificationConverter INSTANCE = Mappers.getMapper(NotificationConverter.class);

    NotificationEntity toEntity(Notification notification);

    List<Notification> toDomain(List<NotificationEntity> notification);
}
