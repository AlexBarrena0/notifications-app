package edu.uoc.abarrena.notifications.infrastructure.repository.mybatis.provider;

import java.util.HashMap;

public class NotificationEntitySqlProvider {

    public String findByUserId(HashMap<String, Object> params) {
        StringBuilder sql = new StringBuilder();
        sql.append("SELECT * FROM NOTIFICATION WHERE USER_ID = #{userId} ");
        if (params.get("read") != null) {
            sql.append("AND READ = #{read} ");
        }
        return sql.toString();
    }
}
