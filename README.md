# README - Challenge Backend API

Este repositorio contiene una API REST desarrollada en Spring Boot (Java 21) que cumple con los requisitos de la prueba 
técnica. A continuación, se detallan las instrucciones para levantar el proyecto utilizando Docker Compose, 
así como una explicación del funcionamiento de la API.

---

## **Requisitos Previos**

Antes de comenzar, asegúrate de tener instalado lo siguiente en tu sistema:

- **Docker**: [Instalar Docker](https://docs.docker.com/get-docker/)
- **Docker Compose**: [Instalar Docker Compose](https://docs.docker.com/compose/install/)
- **Git**: [Instalar Git](https://git-scm.com/downloads)

---

## **Instrucciones para Levantar el Proyecto**

1. **Clonar el Repositorio:**

   ```bash
   git clone https://github.com/Ratzmx1/challenge-backend-tenpo.git
   cd challenge-backend-tenpo

2. **Levantar los Contenedores con Docker Compose:**

Ejecuta el siguiente comando para levantar la API y la base de datos PostgreSQL en contenedores Docker:

   ```bash
   docker-compose up --build
   ```

3. **Validar ejecución de la api:**

Una vez finalizado el comando anterior, la api debera estar levantada y disponible en la url 
```
http://localhost:8080
```
4. **Revisar documentación:**

La documentacion de la api se puede revisar con el servicio arriba en la siguiente ruta

```
http://localhost:8080/swagger-ui/index.html
```
