FROM maven:3.8.3-openjdk-17 AS build

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvn clean install -DskipTests

FROM openjdk:latest

COPY --from=build /app/target/sfptproject-${JAR_VERSION}.jar ./eps_unisalud.jar

EXPOSE 8090

RUN chmod 755 eps_unisalud.jar
ENTRYPOINT [ "java","-jar","app/eps_unisalud.jar" ]
