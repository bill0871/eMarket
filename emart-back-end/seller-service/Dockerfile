FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD seller-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8904
ENTRYPOINT ["java", "-jar", "/app.jar"]

