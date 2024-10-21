FROM maven:3.8.3-openjdk-17 AS build

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN mvn clean install -DskipTests

RUN chmod 755 /app/target/sfptproject-${JAR_VERSION}.jar

FROM openjdk:latest

COPY --from=build /app/target/sfptproject-${JAR_VERSION}.jar .

EXPOSE 8090

RUN chmod 755 sfptproject-${JAR_VERSION}.jar
ENTRYPOINT [ "java","-jar","app/sfptproject-${JAR_VERSION}.jar" ]
