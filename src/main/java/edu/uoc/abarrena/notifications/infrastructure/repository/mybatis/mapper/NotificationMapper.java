package edu.uoc.abarrena.notifications.infrastructure.repository.mybatis.mapper;

import edu.uoc.abarrena.notifications.infrastructure.repository.mybatis.entity.NotificationEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NotificationMapper {

    @Insert("INSERT INTO NOTIFICATION (MESSAGE, TYPE, USER_ID, READ) VALUES (#{message}, #{type}, #{userId}, #{read})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void save(NotificationEntity notificationEntity);

    @Update("UPDATE NOTIFICATION SET READ = #{read} WHERE ID = #{id}")
    public void update(NotificationEntity notificationEntity);

    @Select("SELECT * FROM NOTIFICATION WHERE USER_ID = #{userId}")
    public List<NotificationEntity> findByUserId(Long userId);
}
