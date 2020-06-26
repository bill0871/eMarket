FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD item-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8903
ENTRYPOINT ["java", "-jar", "/app.jar"]

