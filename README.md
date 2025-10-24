# Microservicio de Clientes

Este proyecto es un **microservicio Java Spring Boot** que gestiona la información de personas y clientes bancarios.
Forma parte del sistema de ejemplo.

##Autora
Ana Luisa Ruano Espina
annaruanoespina@gmail.com
Ingeniera en Sistemas - Guatemala

##Tecnologías Utilizadas

- **Java 11**
- **Spring Boot 2.7.14**
- **Spring Data JPA**
- **Oracle Database (ojdbc8 driver)**
- **Swagger OpenAPI (springdoc)**
- **Maven 3.8.9** para la gestion de dependencias

##Estructura del proyecto

microServicioCuentas/
│
├── src/
│ ├── main/java/com/devsu/test/microservicioClientes/
│ │ ├── controller/ → Controladores REST
│ │ ├── entity/ → Entidades JPA (Persona, Cliente)
│ │ ├── repository/ → Interfaces JPA
│ │ ├── service/ → Lógica de negocio
│ └── main/resources/
│ ├── application.properties → Configuración de conexión a Oracle
│ 
│
└── pom.xml → Configuración de Maven


## Configuración del entorno

1. Clonar el repositorio:

   ```bash

   git clone https://github.com/alruanoe/devsu-microServicioClientes.git
   cd microServicioCuentas

2.Configurar la conexión a Oracle en el archivo application.properties:

3.Ejecutar pruebas con
```bash
mvn test

4.Compilar y ejecutar el proyecto
```bash
mvn clean install
mvn spring-boot:run



5.Levantar Swagger
##Documentación Swagger

Una vez ejecutado el microservicio, puedes acceder a la documentación interactiva en:

 http://localhost:8081/swagger-ui.html

