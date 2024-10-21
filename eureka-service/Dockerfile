FROM maven:3.9.4-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM maven:3.9.4-eclipse-temurin-17
WORKDIR /app
COPY --from=build /app/target/eureka-service-0.0.1-SNAPSHOT.jar .
EXPOSE 8761
ENTRYPOINT ["java", "-jar", "eureka-service-0.0.1-SNAPSHOT.jar"]
