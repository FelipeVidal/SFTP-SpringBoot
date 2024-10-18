FROM maven:3.8.3-openjdk-17 AS build

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvn clean install -DskipTests

RUN chmod 755 /app/target/eps_unisalud-0.0.1-SNAPSHOT.jar

FROM openjdk:latest

COPY --from=build /app/target/sfptproject-0.0.1-SNAPSHOT.jar .

EXPOSE 8090

RUN chmod 755 eps_unisalud-0.0.1-SNAPSHOT.jar

ENTRYPOINT [ "java","-jar","app/eps_unisalud-0.0.1-SNAPSHOT.jar" ]
