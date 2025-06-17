# Use JDK 21 base image
FROM eclipse-temurin:21-jdk

# Set working directory
WORKDIR /app

# Copy the built JAR into the container
COPY target/asset_manager-1.0.0.war app.war

# Create the h2 directory
RUN mkdir -p h2

# Copy the test_db file into the h2 directory
COPY ./h2/asset_manager.mv.db ./h2/asset_manager.mv.db

# Expose application port
EXPOSE 8080

# Command to run the application
CMD ["java", "-jar", "app.war"]