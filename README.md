# Foro Hub

Foro Hub es un proyecto desarrollado como parte del desafío del curso BACK END sobre una API REST. Este proyecto es un foro donde los usuarios pueden crear tópicos (dudas o consultas) y otros usuarios pueden responder a estos tópicos. Las entidades principales del proyecto son `Topico`, `Usuario` y `Respuesta`, que están relacionadas entre sí.

## Tecnologías Utilizadas

- **Java 17**
- **Spring Boot 3.3.1**
  - Spring Boot Starter Data JPA
  - Spring Boot Starter Security
  - Spring Boot Starter Validation
  - Spring Boot Starter Web
- **Flyway** (flyway-core y flyway-mysql)
- **MySQL** (mysql-connector-j)
- **Lombok**
- **JWT** (java-jwt)
- **SpringDoc OpenAPI** (springdoc-openapi-starter-webmvc-ui)
- **Spring Boot DevTools**
- **Spring Boot Starter Test**
- **Spring Security Test**

## Funcionalidad del Proyecto

### Entidades Principales

- **Topico**: Representa un tópico o consulta en el foro, creado por un usuario y puede tener varias respuestas.
- **Usuario**: Representa un usuario del foro, que puede crear tópicos y responder a los mismos.
- **Respuesta**: Representa una respuesta a un tópico en el foro, creada por un usuario.

### Relación Entre Entidades

- Un `Topico` puede tener varias `Respuestas`.
- Cada `Respuesta` está asociada a un único `Topico`.
- Los `Usuarios` pueden crear `Topicos` y `Respuestas`.

### Seguridad

El proyecto utiliza **Spring Security** para gestionar la seguridad de la aplicación. Se ha configurado la sesión en modo **stateless** y se ha implementado la creación y validación de tokens JWT (JSON Web Tokens) para la autenticación y autorización de los usuarios.

### Alunos endpoints

- **POST /login**: Permite a los usuarios autenticarse y obtener un token JWT.
- **POST /usuarios**: Permite a los usuarios registrarse.
- **POST /topicos**: Permite a los usuarios crear nuevos tópicos.
- **POST /respuestas**: Permite a los usuarios responder a los tópicos.
- **GET /topicos**: Permite obtener la lista de tópicos.
- **GET /respuestas**: Permite obtener la lista de respuestas de un tópico.
- **Documentación API**: Disponible en `/swagger-ui.html`, `/v3/api-docs/**` y `/swagger-ui/**`.

### Configuración del Proyecto

El proyecto está configurado en el archivo `pom.xml` de Maven, que incluye todas las dependencias necesarias para ejecutar la aplicación.

## Desafíos y Aprendizajes

Desarrollar Foro Hub implicó superar varios desafíos técnicos y adquirir nuevos conocimientos:

- **Manejo de Sesiones Stateless**: Configuración de sesiones stateless para mejorar la seguridad y escalabilidad de la aplicación.
- **JWT**: Implementación de la creación y validación de tokens JWT para la autenticación y autorización de usuarios.
- **Relaciones JPA**: Gestión de relaciones entre entidades usando Spring Data JPA.
- **Migraciones de Base de Datos**: Uso de Flyway para gestionar las migraciones de la base de datos.
- **Documentación API**: Integración de SpringDoc OpenAPI para la documentación de la API.

## Conclusión

Foro Hub es un proyecto que pone en práctica una variedad de tecnologías y conceptos fundamentales en el desarrollo de aplicaciones web modernas. Desde la configuración de seguridad con JWT y sesiones stateless hasta la gestión de relaciones entre entidades y migraciones de base de datos, este proyecto ha proporcionado una experiencia integral y desafiante en el desarrollo de una API REST robusta y segura.

---
