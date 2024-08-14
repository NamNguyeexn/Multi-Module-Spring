ARG JAVA_VERSION=17
FROM openjdk:${JAVA_VERSION}
COPY connect-0.0.1-SNAPSHOT.jar connect
EXPOSE 8082
CMD ["java","-jar","/spring-boot-docker.jar"]