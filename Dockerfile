FROM maven:3.8.3-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17-ea-28-jdk-slim
COPY --from=build /target/WeatherAPIDemo-0.0.1-SNAPSHOT.jar WeatherAPIDemo-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/WeatherAPIDemo-0.0.1-SNAPSHOT.jar"]