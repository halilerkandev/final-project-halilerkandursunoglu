FROM maven:3.8-openjdk-17

ADD ./target/backend-0.0.1-SNAPSHOT.jar /backend.jar

ENTRYPOINT ["java", "-jar", "backend.jar"]

EXPOSE 8082