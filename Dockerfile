FROM eclipse-temurin:21-jre
WORKDIR /app
COPY *.jar app.jar
EXPOSE 2062
ENTRYPOINT ["java", "-jar", "app.jar"]