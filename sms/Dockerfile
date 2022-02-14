FROM maven:3.8-openjdk-17

ADD ./target/sms-0.0.1-SNAPSHOT.jar /sms.jar

ENTRYPOINT ["java", "-jar", "sms.jar"]

EXPOSE 8084