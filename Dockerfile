FROM openjdk:19-jdk-alpine
WORKDIR /app
COPY *.jar app.jar
CMD ["java", "-jar", "app.jar"]