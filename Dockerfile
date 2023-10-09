FROM openjdk:17

WORKDIR /app

COPY src ./src
COPY pom.xml .

ADD target/drnavalha-0.0.1-SNAPSHOT.jar app.jar

CMD ["java", "-jar", "app.jar"]


