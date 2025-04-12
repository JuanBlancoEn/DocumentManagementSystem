# Document Management System

Este es un sistema de gestión de documentos desarrollado con Spring Boot, que permite la creación, autenticación, y gestión de usuarios. A futuro, los documentos serán almacenados en Elasticsearch, y se implementará un *API wrapper* en Python para la integración de inteligencia artificial (IA). Además, se contará con un chatbot que permitirá realizar consultas sobre los documentos almacenados en la base de datos.

## Características

- **Gestión de usuarios**: Los usuarios pueden registrarse, iniciar sesión y gestionar su información personal.
- **Autenticación segura**: Las contraseñas de los usuarios se cifran con BCrypt para garantizar la seguridad.
- **Documentos**: En el futuro, los documentos serán gestionados y almacenados en Elasticsearch, lo que permitirá realizar búsquedas rápidas y eficientes.
- **API de IA**: Un *API wrapper* en Python proporcionará acceso a capacidades de inteligencia artificial para procesar y analizar los documentos almacenados.
- **Chatbot**: Un chatbot permitirá realizar preguntas sobre los documentos en la base de datos, utilizando IA para responder de manera inteligente.

## Tecnologías utilizadas

- **Spring Boot**: Framework principal para el desarrollo de la aplicación.
- **MySQL**: Base de datos relacional para almacenar información de usuarios.
- **Elasticsearch**: Motor de búsqueda distribuido para la gestión y consulta de documentos (en desarrollo futuro).
- **Python & AI**: Integración de IA a través de un API wrapper en Python (en desarrollo futuro).
- **BCrypt**: Algoritmo de cifrado utilizado para asegurar las contraseñas de los usuarios.
- **Spring Security**: Proporciona las funcionalidades de autenticación y autorización.

## Instalación

### Requisitos

1. **Java 17 o superior**.
2. **MySQL** instalado y configurado.
3. **Maven** o **Gradle** (dependiendo de tu configuración de proyecto).

### Paso a paso

1. **Clonar el repositorio**:

   ```bash
   git clone https://github.com/JuanBlancoEn/TFG.git
   cd TFG
   ```

2. **Configurar la base de datos**:

   Asegúrate de tener una base de datos de MySQL configurada. Puedes crear una nueva base de datos llamada `document_manager`.

3. **Configurar las credenciales de la base de datos**:

   En el archivo `src/main/resources/application.properties`, configura las credenciales de tu base de datos:

   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/document_manager
   spring.datasource.username=tu_usuario
   spring.datasource.password=tu_contraseña
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
   ```

4. **Compilar y ejecutar el proyecto**:

   Si usas Maven:

   ```bash
   mvn clean install
   mvn spring-boot:run
   ```

   Si usas Gradle:

   ```bash
   gradle build
   gradle bootRun
   ```

   La aplicación debería estar corriendo en `http://localhost:8080`.

## Uso

### Endpoints principales

- **Registrar usuario (POST)**:

  - URL: `/api/users/register`
  - Body:
    ```json
    {
      "username": "testuser",
      "password": "testpassword",
      "email": "test@example.com"
    }
    ```
  - Respuesta: `201 Created` si el usuario fue creado correctamente.

- **Iniciar sesión (POST)**:

  - URL: `/api/login`
  - Body:
    ```json
    {
      "username": "testuser",
      "password": "testpassword"
    }
    ```
  - Respuesta: `200 OK` si las credenciales son correctas, `401 Unauthorized` si son incorrectas.

- **Obtener todos los usuarios (GET)**:

  - URL: `/api/users`
  - Respuesta: Devuelve un array de usuarios.

- **Eliminar un usuario (DELETE)**:

  - URL: `/api/users/{id}`
  - Respuesta: `204 No Content` si el usuario fue eliminado correctamente.

