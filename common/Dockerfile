ARG JAVA_VERSION=17
FROM openjdk:${JAVA_VERSION}
COPY target/common-0.0.1-SNAPSHOT.jar common.jar
EXPOSE 8080
CMD ["java","-jar","/common.jar"]