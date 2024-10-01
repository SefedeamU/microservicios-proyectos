# Microservicio Proyectos

## Descripción
Este proyecto es un microservicio para la gestión de proyectos. Utiliza Spring Boot, JPA, y MySQL para la persistencia de datos.

## Estructura del Proyecto
- `src/main/java/com/example/microservicio_proyectos/`: Contiene el código fuente de la aplicación.
  - `model/`: Contiene las clases de modelo `Proyecto` y `UsuarioProyecto`.
  - `repository/`: Contiene las interfaces de repositorio `ProyectoRepository` y `UsuarioProyectoRepository`.
  - `service/`: Contiene la clase de servicio `ProyectoService`.
  - `enums/`: Contiene los enumerados `Estado` y `Prioridad`.
  - `MicroservicioProyectosApplication.java`: Clase principal para iniciar la aplicación Spring Boot.
- `src/main/resources/`: Contiene los recursos de la aplicación.
  - `application.properties`: Archivo de configuración de la aplicación.
  - `db/migration/`: Contiene los scripts de migración de la base de datos.

## Configuración de la Base de Datos
El archivo `application.properties` contiene la configuración para conectarse a una base de datos MySQL:

```ini
spring.datasource.url=jdbc:mysql://18.235.139.228:3306/proyectos_db
spring.datasource.username=api-proyectos
spring.datasource.password=Mysql@123
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect