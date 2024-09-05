ARG JAVA_VERSION=17
FROM openjdk:${JAVA_VERSION}
COPY target/logger-0.0.1-SNAPSHOT.jar logger.jar
EXPOSE 8080
CMD ["java","-jar","/logger.jar"]