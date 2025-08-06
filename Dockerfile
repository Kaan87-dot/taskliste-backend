# Base image mit Java 17
FROM eclipse-temurin:17-jdk

# Arbeitsverzeichnis setzen
WORKDIR /app

# Projektdateien kopieren
COPY . .

# Projekt bauen
RUN ./mvnw clean package -DskipTests

# JAR-Datei starten
CMD ["java", "-jar", "target/taskliste-0.0.1-SNAPSHOT.jar"]
