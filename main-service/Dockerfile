FROM openjdk:23-slim AS build
COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .
COPY src src

RUN chmod +x mvnw
RUN ./mvnw clean -B package -DskipTests

FROM openjdk:23-slim
COPY --from=build target/main-service-0.0.1-SNAPSHOT.jar .
EXPOSE 8081
ENTRYPOINT ["java", "-jar", "main-service-0.0.1-SNAPSHOT.jar"]
