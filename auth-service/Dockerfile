FROM openjdk:23-slim AS build
COPY .mvn .mvn
COPY mvnw .
COPY pom.xml .
COPY src src

RUN chmod +x mvnw
RUN ./mvnw clean -B package -DskipTests

FROM openjdk:23-slim
COPY --from=build target/auth-service-0.0.1-SNAPSHOT.jar .
EXPOSE 8005
ENTRYPOINT ["java", "-jar", "auth-service-0.0.1-SNAPSHOT.jar"]
