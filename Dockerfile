#
# Build stage
#
FROM maven:3.6.3-openjdk-15-slim AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean install -DskipTests

#
# Package stage
#
FROM maven:3.6.3-openjdk-15-slim
COPY --from=build /home/app/target/hermes-1.0.0-SNAPSHOT.jar /usr/local/lib/hermes-1.0.0-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/hermes-1.0.0-SNAPSHOT.jar"]