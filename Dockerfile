FROM amazoncorretto:17-alpine
WORKDIR /app
COPY target/spring-ci-cd-with-jenkins.jar spring-ci-cd-with-jenkins.jar
ENTRYPOINT ["java", "-jar", "spring-ci-cd-with-jenkins.jar"]