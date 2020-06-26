FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD eureka-server-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8900
ENTRYPOINT ["java", "-jar", "/app.jar"]

