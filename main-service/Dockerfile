FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM maven:3.9.4-eclipse-temurin-17
WORKDIR /app
COPY --from=build /app/target/main-service-0.0.1-SNAPSHOT.jar .
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "main-service-0.0.1-SNAPSHOT.jar"]
