package edu.uoc.abarrena.notifications.infrastructure.repository.mybatis.mapper;

import edu.uoc.abarrena.notifications.infrastructure.repository.mybatis.entity.NotificationEntity;
import edu.uoc.abarrena.notifications.infrastructure.repository.mybatis.provider.NotificationEntitySqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface NotificationMapper {

    @Insert("INSERT INTO NOTIFICATION (MESSAGE, TYPE, USER_ID, READ, URL) VALUES (#{message}, #{type}, #{userId}, #{read}, #{url})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(NotificationEntity notificationEntity);

    @Update("UPDATE NOTIFICATION SET READ = #{read} WHERE ID = #{id}")
    void update(NotificationEntity notificationEntity);

    @SelectProvider(type = NotificationEntitySqlProvider.class, method = "findByUserId")
    List<NotificationEntity> findByUserId(HashMap<String, Object> params);
}
