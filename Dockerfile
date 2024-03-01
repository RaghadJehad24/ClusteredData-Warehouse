
# Stage 1: Build the application
FROM maven:3.8.4-openjdk-17 AS build
WORKDIR /usr/src/app
COPY pom.xml .
COPY src ./src
RUN mvn clean package

# Stage 2: Setup the runtime environment with Java 17
FROM openjdk:17-slim
WORKDIR /app
COPY --from=build /usr/src/app/target/ClusteredData-0.0.1-SNAPSHOT.jar /app/ClusteredData-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/ClusteredData-0.0.1-SNAPSHOT.jar"]
