# Use a minimal OpenJDK image to keep the image lightweight
FROM openjdk:17-jdk-slim

# Set environment variables
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    JAVA_OPTS=""

# Set the working directory inside the container
WORKDIR /app

# Copy the pre-built JAR from the host to the container
COPY target/masterlist-0.0.1-SNAPSHOT.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", \
    "-Dspring.datasource.url=${SPRING_DATASOURCE_URL}", \
    "-Dspring.datasource.username=${SPRING_DATASOURCE_USERNAME}", \
    "-Dspring.datasource.password=${SPRING_DATASOURCE_PASSWORD}", \
    "-jar", "app.jar"]
