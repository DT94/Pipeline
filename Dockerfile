# Usa una imagen base oficial de Java 17 ligera (Alpine)
FROM eclipse-temurin:17-jre-alpine

# Define el directorio de trabajo dentro del contenedor
WORKDIR /app

# Crear un usuario sin privilegios root
RUN addgroup -S springsec && adduser -S springsec -G springsec
USER springsec:springsec

# Copia el archivo .jar compilado al contenedor
COPY target/*.jar app.jar

# Expone el puerto que usa Tomcat/Spring Boot
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]