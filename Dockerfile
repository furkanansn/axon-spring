    FROM openjdk:11

    # Set the working directory in the container
    WORKDIR /app

    # Copy the JAR file into the container at /app
    COPY target/energy-consumption-0.0.1-SNAPSHOT.jar /app/energy-consumption-0.0.1-SNAPSHOT.jar

    # Expose the port that your application will run on
    EXPOSE 8080

    # Specify the command to run on container startup
    CMD ["java", "-jar", "energy-consumption-0.0.1-SNAPSHOT.jar"]
