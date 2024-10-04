FROM openjdk:23-slim AS build
COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .
COPY src src

RUN ./mvnw clean -B package -DskipTests

FROM openjdk:23-slim
COPY --from=build target/additional-service-0.0.1-SNAPSHOT.jar .
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "additional-service-0.0.1-SNAPSHOT.jar"]
