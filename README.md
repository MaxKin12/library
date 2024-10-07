# Project Library
CRUD Web API that imitates library with microservice architecture.

### Technologies:
Spring Boot, Spring Cloud, Spring Security (+ JWT token), MapStruct,
Hibernate, MySQL, Swagger, Docker + Docker Compose.

## Starting:
Project building (run that in the root):
```
$ docker-compose build
```
Project starting: 
```
$ docker-compose up
```
The whole project has single entry point via 8080 port:
```
http://localhost:8080
```

## Microservices:
### Gateway-service:
API Gateway based on Spring Cloud Gateway. Access to all other microservices of the project is provided via the gateway.
Gateway has port 8080 (the only entry point of the project).
All requests pass through a filter that performs authorization based on the presence of a verified JWT token (bearer token),
except for registration and authentication requests. So all other requests without a JWT token will be rejected.
The token verification logic is stored here.

### Eureka-service:
Eureka - discovery server, that holds info about all connected services in the system.

### Auth-service:
User authentication service. Contains the database with users (here and after - MySQL).
#### 1. Signup: [POST]
```
http://localhost:8080/auth/signup
```
#### 2. Login: [POST]
```
http://localhost:8080/auth/login
```
As a result, it issues a JWT token that is valid for an hour.
#### 3. Get all users (tokes is required): [GET]
```
http://localhost:8080/auth/users/
```
### Main-service:
Contains the main functionality of the project - imitation of a library. Has database with books.
#### 1. Get books list: [GET]
```
http://localhost:8080/books/
```
#### 2. Get book by id: [GET]
```
http://localhost:8080/books/{id}
```
#### 3. Get book by ISBN: [GET]
```
http://localhost:8080/books/{isbn}
```
#### 4. Add new book: [POST]
```
http://localhost:8080/books/create
```
Invokes an automatic synchronous request to Additional-service to add a new record using Spring Cloud (FeignClient)
#### 5. Update book info: [POST]
```
http://localhost:8080/books/update
```
#### 6. Delete book: [POST]
```
http://localhost:8080/books/delete
```

### Additional-service:
Additional library functionality. Stores records of whether a book is free/occupied (in the DB).
#### 1. Get all records: [GET]
```
http://localhost:8080/records/
```
#### 2. Get available books records: [GET]
```
http://localhost:8080/records/available
```
#### 3. Update record: [POST]
```
http://localhost:8080/records/update
```
#### 4. Add record: [POST]
```
http://localhost:8080/records/add
```

## Documentation:
Each microservice contains Swagger documentation. Publicly accessible via:
```
http://localhost:8080/swagger-ui.html
```
All other services documentation you can access via this one.
