FROM openjdk:21-jdk

WORKDIR /app

COPY target/municipality-processor-0.0.1-SNAPSHOT.jar /app/municipality-processor-0.0.1-SNAPSHOT.jar

CMD ["java", "-jar", "municipality-processor-0.0.1-SNAPSHOT.jar"]