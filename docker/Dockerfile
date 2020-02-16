FROM openjdk:8-jdk-alpine

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} SpringTech-1.0.jar

ENTRYPOINT ["java","-jar","/SpringTech-1.0.jar"]