# === Stage 1: Build the application ===
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copy the pom.xml first to cache dependencies
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src

# Package the application (skipping tests for faster local builds)
RUN mvn clean package -DskipTests

# === Stage 2: Run the application ===
# FIXED: Switched from alpine to jammy for native M1 (ARM64) support
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app

# Copy the compiled jar from the build stage (Using wildcard to prevent future version breaks!)
COPY --from=build /app/target/*.jar app.jar

# Expose Spring Boot's default port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]