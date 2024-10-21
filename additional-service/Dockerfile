FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM maven:3.9.4-eclipse-temurin-17
WORKDIR /app
COPY --from=build /app/target/additional-service-0.0.1-SNAPSHOT.jar .
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "additional-service-0.0.1-SNAPSHOT.jar"]
