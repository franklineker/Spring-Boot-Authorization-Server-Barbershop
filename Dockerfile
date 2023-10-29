FROM --platform=linux/amd64 maven:3.8.5-openjdk-17 as builder

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn package -DskipTests

FROM --platform=linux/amd64 openjdk:17

COPY --from=builder /app/target/barbershop-authorization-*.jar /barbershop-authorization.jar

CMD ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/barbershop-authorization.jar"]
EXPOSE 8081