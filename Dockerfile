FROM openjdk:20-jdk
COPY target/notifications-1.0-SNAPSHOT.jar notifications-1.0-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/notifications-1.0-SNAPSHOT.jar"]