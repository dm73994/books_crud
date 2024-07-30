# Library Test

This project is a technical test for a backend developer position. It uses an MVC architecture chosen for its simplicity and suitability for managing two main entities: `Book` and `User`. This architecture was selected to streamline development and optimize implementation time. For security, an asynchronous token-based authentication system has been implemented instead of traditional encryption keys, as it offers greater flexibility and additional benefits.

## Table of Contents

- [Features](#features)
- [Use Cases](#use-cases)
- [Entities and Validations](#entities-and-validations)
  - [Book](#book)
  - [User](#user)
- [Usage](#usage)
- [Additional Configuration](#additional-configuration)

## Features

- **MVC Architecture**: Selected for its simplicity and efficiency in managing two main entities.
- **Token-Based Security**: Implementation of asynchronous tokens using the Bearer scheme, providing greater flexibility for authentication compared to traditional encryption keys.
- **Custom Metrics**: Use of Actuator, Micrometer, and Prometheus to measure and monitor endpoint execution times. You can access the custom metrics at [http://localhost:8080/actuator/prometheus](http://localhost:8080/actuator/prometheus).
- **Endpoint Documentation**: Endpoint documentation is available through Swagger at [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html).

## Use Cases

![biblioteca_prueba_técnica](https://github.com/user-attachments/assets/46ba7d7c-f62b-4ac4-9bfa-5b5a9239c21e)
![biblioteca_prueba_técnica3](https://github.com/user-attachments/assets/c1678eb5-c37b-44dc-b685-347e1e1149cc)
![biblioteca_prueba_técnica2](https://github.com/user-attachments/assets/494e67e8-d893-4607-8915-439d261d7e6f)

## Entities and Validations

The system manages two main entities: `Book` and `User`, using an H2 database. The following validations have been implemented:

### Book (`Book`):

The `Book` entity is represented by the following JSON schema:

```json
{
    "title": "string",
    "author": "string",
    "releaseDate": "yyyy-mm-dd",
    "publisher": "string",
    "description": "string"
}
```
**Validations:**
- `title`: Must not be blank and must be longer than 2 characters.
- `author`: Must not be blank.
- `publisher`: Must not be blank.
- `description`: Optional field.
- `releaseDate`: Optional field.

### User (`User`):
The `User` entity is represented by the following JSON schema:
```json
{
    "username": "string",
    "password": "string"
}
```

**Validations:**
  - Password must be at least 8 characters long.
  - The `username` field cannot be empty.

These validations are applied using the `Validator` component at the endpoints. Additionally, specific validation components have been created for each entity to maintain clear separation of responsibilities.

## Usage

- **Register a New User**: Send a POST request to `/api/auth/register` with a JSON body containing `username` and `password` fields.
- **View Custom Metrics**: Access [http://localhost:8080/actuator/prometheus](http://localhost:8080/actuator/prometheus) to view the metrics.
- **Endpoint Documentation**: Complete documentation is available at [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html).

## Additional Configuration

For additional adjustments and custom configurations, review the `pom.xml` file and the Spring Boot configuration. Make sure to adjust any parameters according to the specific needs of the project.
Sometimes the pem files on /certs folder are not registered, so for this just cut the next lines save and pasted agains and save so the application can recognized those security files:
- **rsa.public-key=classpath:com/library_test/library_test/certs/public.pem
- **rsa.private-key = classpath:com/library_test/library_test/certs/private.pem

- To use postman go to the next link where you will find the schema collection so you can import it into your local machine or postman: https://api.postman.com/collections/16207306-ecfe895a-58b7-47e0-9d9a-ebd9d1cb8eb4?access_key=PMAT-01J40MMQP87F3RGBYMXPP41W2X

