ARG JAVA_VERSION=17
FROM openjdk:${JAVA_VERSION}
COPY target/checkwork-0.0.1-SNAPSHOT.jar checkwork.jar
EXPOSE 8086
CMD ["java","-jar","/checkwork.jar"]