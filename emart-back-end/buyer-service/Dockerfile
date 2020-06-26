FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD buyer-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8902
ENTRYPOINT ["java", "-jar", "/app.jar"]

