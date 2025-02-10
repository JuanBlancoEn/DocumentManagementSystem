FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copia el archivo .jar desde la carpeta target del directorio donde se ejecuta docker
COPY ./gestion-documentos/target/gestion-documentos-0.0.1-SNAPSHOT.jar /app/gestion-documentos.jar

CMD ["java", "-jar", "gestion-documentos.jar"]