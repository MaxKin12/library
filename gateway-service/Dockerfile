FROM openjdk:23-slim AS build
COPY .mvn .mvn
COPY ../mvnw .
COPY pom.xml .
COPY src src

RUN chmod +x mvnw
RUN ./mvnw clean -B package -DskipTests

FROM openjdk:23-slim
COPY --from=build target/gateway-service-0.0.1-SNAPSHOT.jar .
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "gateway-service-0.0.1-SNAPSHOT.jar"]
