FROM openjdk:17-oracle

WORKDIR /app
# Copia el archivo JAR de la aplicación al contenedor
COPY ../target/backendDevTest-0.0.1-SNAPSHOT.jar /app/backendDevTest.jar

# Expone el puerto 5000 para acceder a la aplicación
EXPOSE 5000

# Define el comando de inicio de la aplicación
CMD ["java", "-jar", "/app/backendDevTest.jar"]
