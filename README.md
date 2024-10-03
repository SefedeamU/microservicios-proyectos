# Microservicio Proyectos

Este proyecto es un microservicio para la gestión de proyectos utilizando **Spring Boot** y **MySQL**.

## Estructura del Proyecto

- `src/main/java/com/example/microservicio_proyectos/`
  - `model/`
    - `Proyecto.java`: Definición del modelo Proyecto.
    - `UsuarioProyecto.java`: Definición del modelo UsuarioProyecto.
  - `repository/`
    - `ProyectoRepository.java`: Interfaz para operaciones CRUD en la entidad Proyecto.
    - `UsuarioProyectoRepository.java`: Interfaz para operaciones CRUD en la entidad UsuarioProyecto.
  - `service/`
    - `ProyectoService.java`: Lógica de negocio para la gestión de proyectos.
  - `enums/`
    - `Estado.java`: Enumerado para los estados de un proyecto.
    - `Prioridad.java`: Enumerado para las prioridades de un proyecto.
  - `MicroservicioProyectosApplication.java`: Clase principal para iniciar la aplicación Spring Boot.

- `src/main/resources/`
  - `application.properties`: Archivo de configuración de la aplicación.
  - `db/migration/`: Contiene los scripts de migración de la base de datos.

## Configuración

1. Clonar el repositorio.
2. Configurar la base de datos en el archivo `application.properties`.
3. Instalar las dependencias y compilar el proyecto:

   ```bash
   mvn clean install
   ```

4. Ejecutar la aplicación:

   ```bash
   mvn spring-boot:run
   ```

## Uso

**Proyectos:**
- **GET /proyectos/**: Obtener todos los proyectos.
- **POST /proyectos/**: Crear un nuevo proyecto.
- **GET /proyectos/{id}**: Obtener un proyecto por ID.
- **PUT /proyectos/{id}**: Actualizar un proyecto por ID.
- **DELETE /proyectos/{id}**: Eliminar un proyecto por ID.

**UsuarioProyecto:**
- **GET /usuarios_proyectos/**: Obtener todas las relaciones usuario-proyecto.
- **POST /usuarios_proyectos/**: Crear una nueva relación usuario-proyecto.
- **GET /usuarios_proyectos/{id}**: Obtener una relación usuario-proyecto por ID.
- **PUT /usuarios_proyectos/{id}**: Actualizar una relación usuario-proyecto por ID.
- **DELETE /usuarios_proyectos/{id}**: Eliminar una relación usuario-proyecto por ID.

## Endpoints

### Proyectos:
- **GET /proyectos/**: Obtener todos los proyectos.
- **POST /proyectos/**: Crear un nuevo proyecto.
    - **Body**:
      ```json
      {
        "nombre": "string",
        "descripcion": "string",
        "fechaInicio": "string",
        "fechaFin": "string",
        "estado": "string",
        "prioridad": "string"
      }
      ```
- **GET /proyectos/{id}**: Obtener un proyecto por ID.
- **PUT /proyectos/{id}**: Actualizar un proyecto por ID.
    - **Body**:
      ```json
      {
        "nombre": "string",
        "descripcion": "string",
        "fechaInicio": "string",
        "fechaFin": "string",
        "estado": "string",
        "prioridad": "string"
      }
      ```
- **DELETE /proyectos/{id}**: Eliminar un proyecto por ID.

### UsuarioProyecto:
- **GET /usuarios_proyectos/**: Obtener todas las relaciones usuario-proyecto.
- **POST /usuarios_proyectos/**: Crear una nueva relación usuario-proyecto.
    - **Body**:
      ```json
      {
        "usuarioId": "number",
        "proyectoId": "number",
        "rol": "string"
      }
      ```
- **GET /usuarios_proyectos/{id}**: Obtener una relación usuario-proyecto por ID.
- **PUT /usuarios_proyectos/{id}**: Actualizar una relación usuario-proyecto por ID.
    - **Body**:
      ```json
      {
        "usuarioId": "number",
        "proyectoId": "number",
        "rol": "string"
      }
      ```
- **DELETE /usuarios_proyectos/{id}**: Eliminar una relación usuario-proyecto por ID.
- 
## Configuración de la Base de Datos:

```ini
spring.datasource.url=jdbc:mysql://localhost:3306/proyectos_db
spring.datasource.username=usuario
spring.datasource.password=contraseña
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
```

## Scripts

- **Inicializar la base de datos:**

  ```bash
  mvn flyway:migrate
  ```

## Endpoints

### Proyectos:
- **GET /proyectos/**: Obtener todos los proyectos.
- **POST /proyectos/**: Crear un nuevo proyecto.
- **GET /proyectos/{id}**: Obtener un proyecto por ID.
- **PUT /proyectos/{id}**: Actualizar un proyecto por ID.
- **DELETE /proyectos/{id}**: Eliminar un proyecto por ID.

### UsuarioProyecto:
- **GET /usuarios_proyectos/**: Obtener todas las relaciones usuario-proyecto.
- **POST /usuarios_proyectos/**: Crear una nueva relación usuario-proyecto.
- **GET /usuarios_proyectos/{id}**: Obtener una relación usuario-proyecto por ID.
- **PUT /usuarios_proyectos/{id}**: Actualizar una relación usuario-proyecto por ID.
- **DELETE /usuarios_proyectos/{id}**: Eliminar una relación usuario-proyecto por ID.

## Contribuir

1. Hacer un fork del repositorio.
2. Crear una nueva rama:

   ```bash
   git checkout -b feature/nueva-funcionalidad
   ```

3. Realizar los cambios necesarios y hacer commit:

   ```bash
   git commit -am 'Añadir nueva funcionalidad'
   ```

4. Hacer push a la rama:

   ```bash
   git push origin feature/nueva-funcionalidad
   ```

5. Crear un Pull Request.

## Puerto
La aplicación se ejecuta en el puerto `8080`. Asegúrate de que este puerto esté disponible en tu máquina.

## Licencia

Este proyecto está licenciado bajo los términos de la licencia **MIT**.
