FROM openjdk:21-jdk-slim

WORKDIR /app

COPY src/ ./src/

# Compile all Java files recursively
RUN mkdir out && find src -name "*.java" | xargs javac -d out

# Default entrypoint (can be overridden at runtime)
ENTRYPOINT ["java", "-cp", "out"] 
CMD ["assignment_one.ConstructionMain"]