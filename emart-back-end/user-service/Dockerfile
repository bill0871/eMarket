FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD user-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8901
ENTRYPOINT ["java", "-jar", "/app.jar"]

