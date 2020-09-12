FROM openjdk:8-alpine
COPY target/movie-info-service-*.jar /movie-info-service.jar
CMD ["java", "-jar", "/movie-info-service.jar"]
setup