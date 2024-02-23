FROM openjdk:21-jdk

WORKDIR /app

# Copy the built jar from the builder stage
COPY /build/libs/*.jar /app/app.jar

# Command to run the application
CMD ["java", "-jar", "/app/app.jar"]