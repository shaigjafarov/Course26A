FROM openjdk:11-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container at /app
#COPY target/your-app.jar /app/

# Expose the port the application runs on
EXPOSE 8080

# Define the command to run your application
CMD ["java", "-jar", "your-app.jar"]



