
FROM openjdk:17
COPY target/ClusteredData.jar .
EXPOSE 8080
ENTRYPOINT ["java","-jar","ClusteredData.jar"]
