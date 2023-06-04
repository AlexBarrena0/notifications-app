package edu.uoc.abarrena.notifications.infrastructure.repository.mybatis;

import edu.uoc.abarrena.notifications.domain.converter.NotificationConverter;
import edu.uoc.abarrena.notifications.domain.model.Notification;
import edu.uoc.abarrena.notifications.domain.repository.NotificationRepository;
import edu.uoc.abarrena.notifications.infrastructure.repository.mybatis.entity.NotificationEntity;
import edu.uoc.abarrena.notifications.infrastructure.repository.mybatis.mapper.NotificationMapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class NotificationRepositoryImpl implements NotificationRepository {

    private final NotificationMapper notificationMapper;

    public NotificationRepositoryImpl(NotificationMapper notificationMapper) {
        this.notificationMapper = notificationMapper;
    }

    @Override
    public Long save(Notification notification) {
        NotificationEntity notificationEntity = NotificationConverter.INSTANCE.toEntity(notification);
        notificationMapper.save(notificationEntity);
        return notificationEntity.getId();
    }

    @Override
    public void update(Notification notification) {
        NotificationEntity notificationEntity = NotificationConverter.INSTANCE.toEntity(notification);
        notificationMapper.update(notificationEntity);
    }

    @Override
    public List<Notification> findByUserId(Long userId, Boolean read) {
        HashMap<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("read", read);
        return NotificationConverter.INSTANCE.toDomain(notificationMapper.findByUserId(params));
    }
}
