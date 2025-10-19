# Stage 1: build con Gradle (usa imagen oficial con Gradle y JDK 17)
FROM gradle:8.4-jdk17 AS builder
# Define el directorio de trabajo dentro del contenedor
WORKDIR /home/gradle/project

# Copiamos archivos relevantes (incluye gradle wrapper si lo tienes)
COPY --chown=gradle:gradle . .

# Ejecuta el build skip tests para acelerar
RUN gradle --no-daemon clean bootJar -x test

# Stage 2: runtime con JRE liviano
FROM eclipse-temurin:17-jre-jammy
ARG JAR_FILE=/home/gradle/project/build/libs/*.jar
COPY --from=builder ${JAR_FILE} /app/app.jar
EXPOSE 8181
ENTRYPOINT ["java","-jar","/app/app.jar"]