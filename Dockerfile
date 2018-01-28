FROM openjdk:8u151-jdk

COPY target/console-drawing-1.0.0.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]
