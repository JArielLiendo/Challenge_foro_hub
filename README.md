# Foro Hub

Foro Hub es un proyecto desarrollado como parte del Challenge del curso BACK END sobre una API REST. Este proyecto consiste en un foro donde los usuarios pueden crear tópicos (dudas o consultas) y responder a los tópicos de otros usuarios. Los tópicos y las respuestas están relacionados entre sí y gestionados por usuarios registrados.

## Temas y Tecnologías Implementadas

### Temas
- **API REST**: Diseño y desarrollo de una API RESTful.
- **Persistencia de Datos**: Uso de JPA y MySQL para el almacenamiento y gestión de datos.
- **Seguridad**: Implementación de seguridad con Spring Security y JWT.
- **Migraciones de Base de Datos**: Uso de Flyway para manejar cambios en el esquema de la base de datos.
- **Validación**: Validación de datos de entrada con Spring Boot Starter Validation.
- **Documentación**: Generación de documentación de la API con Springdoc OpenAPI.

### Tecnologías
- **Spring Boot**: Framework principal para la construcción del proyecto.
- **Spring Security**: Para la gestión de la seguridad y autenticación de usuarios.
- **Spring Data JPA**: Para la persistencia y acceso a la base de datos.
- **Flyway**: Para las migraciones de la base de datos.
- **Lombok**: Para reducir el código boilerplate.
- **JWT (JSON Web Token)**: Para la autenticación y autorización basada en tokens.
- **MySQL**: Base de datos utilizada para almacenar la información.
- **Springdoc OpenAPI**: Para la documentación interactiva de la API.

## Funcionamiento del Proyecto

### Entidades Principales
- **Usuario**: Representa a los usuarios que interactúan con el foro.
- **Topico**: Representa los tópicos (dudas o consultas) creados por los usuarios.
- **Respuesta**: Representa las respuestas a los tópicos, también creadas por los usuarios.

### Flujo de Trabajo
1. **Creación de Usuarios**: Los usuarios pueden registrarse en el sistema.
2. **Autenticación**: Los usuarios se autentican mediante un sistema de tokens JWT. La sesión se maneja de forma stateless.
3. **Gestión de Tópicos**: Los usuarios pueden crear, leer, actualizar y eliminar tópicos.
4. **Gestión de Respuestas**: Los usuarios pueden responder a los tópicos creados por otros usuarios.
5. **Seguridad**: La API está protegida, y solo los usuarios autenticados pueden interactuar con los endpoints restringidos.

### Seguridad
La seguridad se implementa usando Spring Security y JWT. La configuración de la sesión es stateless, lo que significa que no se mantiene el estado de la sesión en el servidor. Cada solicitud autenticada debe incluir un token JWT válido, que se valida en cada solicitud.

### Documentación y Pruebas
- **Insomnia**: La API REST fue probada con Insomnia para asegurar que todos los endpoints funcionen correctamente.
- **Springdoc OpenAPI**: La documentación de la API se genera automáticamente y se puede acceder a través de `/swagger-ui.html`.

## Desafíos y Aprendizajes

### Desafíos Superados
- **Autenticación y Autorización**: Implementar un sistema de seguridad robusto utilizando JWT y Spring Security.
- **Migraciones de Base de Datos**: Manejo de cambios en el esquema de la base de datos con Flyway.
- **Validación de Datos**: Asegurar que los datos de entrada sean válidos y seguros utilizando Spring Boot Starter Validation.

### Aprendizajes
- **Diseño de API REST**: Mejores prácticas en el diseño y desarrollo de APIs RESTful.
- **Seguridad en APIs**: Importancia de asegurar las APIs, especialmente en entornos de producción.
- **Manejo de Datos Relacionales**: Uso de JPA y MySQL para gestionar relaciones complejas entre entidades.

## Conclusión

Foro Hub ha sido un proyecto enriquecedor que permitió la aplicación práctica de conceptos clave en el desarrollo de APIs RESTful, la gestión de seguridad con JWT y Spring Security, y la persistencia de datos con Spring Data JPA y MySQL. Los desafíos enfrentados durante el desarrollo han contribuido significativamente al aprendizaje y dominio de estas tecnologías.
