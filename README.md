# Spring Boot Learning Project

A hands-on Spring Boot project built step by step — from a simple hello world to a database-backed CRUD API.

## Tech Stack

- Java 21
- Spring Boot 3.5.0
- MongoDB
- Maven

---

## Level 1 — Controllers and REST

### 1. Hello World API

One endpoint, returns a string. Confirms everything runs.

```
GET /yo?name=Trisha  →  "Hello, Trisha! Welcome to Spring Boot!"
GET /yo              →  "Hello, World! Welcome to Spring Boot!"
```

**File:** `HelloController.java`
**Concepts:** `@RestController`, `@GetMapping`, `@RequestParam`

---

### 2. Calculator API

Takes values from the query string and returns the result.

```
GET /add?a=5&b=3       →  8
GET /subtract?a=10&b=4  →  6
GET /multiply?a=3&b=7   →  21
```

**File:** `CalculatorController.java`
**Concepts:** `@RequestParam`, returning different data types

---

### 3. User CRUD API (in-memory)

In-memory list, no database. The starting point before adding persistence.

```
GET    /users         →  list all users
POST   /users         →  create a user (JSON body)
DELETE /users/{id}    →  delete a user by id
```

**Files:** `User.java`, `UserService.java`, `UserController.java`
**Concepts:** `@RequestBody`, `@PathVariable`, `@PostMapping`, `@DeleteMapping`, layered architecture (Controller → Service)

---

## Level 2 — Add a Database

Switched from in-memory storage to MongoDB. Data now persists across server restarts.

### 1. User CRUD with MongoDB

Same endpoints as Level 1, but backed by a real database.

```
GET    /users         →  list all users (from MongoDB)
POST   /users         →  create a user (saved to MongoDB)
DELETE /users/{id}    →  delete a user from MongoDB
```

**Files:** `User.java`, `UserRepository.java`, `UserService.java`, `UserController.java`
**Concepts:** `@Document`, `@Id`, `MongoRepository`, `application.properties` DB config, Spring Data auto-generated queries

---

### 2. Todo List API

Create, complete, and delete todos. Adds data modeling with timestamps and status filtering.

```
GET    /todos                  →  list all todos
GET    /todos?completed=true   →  filter by status
POST   /todos                  →  create a todo (JSON body)
PATCH  /todos/{id}/complete    →  mark a todo as done
DELETE /todos/{id}             →  delete a todo
```

**Example POST body:**
```json
{
  "title": "Learn Spring Boot",
  "description": "Finish the CRUD tutorial"
}
```

**Files:** `Todo.java`, `TodoRepository.java`, `TodoService.java`, `TodoController.java`
**Concepts:** `@PatchMapping`, custom repository query methods (`findByCompleted`), boolean fields, `LocalDateTime` timestamps

---

## Project Structure

```
src/main/java/com/example/hello_world/
├── HelloWorldApplication.java     # Main entry point
├── HelloController.java           # Level 1 — Hello World
├── CalculatorController.java      # Level 1 — Calculator
├── User.java                      # User document (MongoDB)
├── UserRepository.java            # User data access
├── UserService.java               # User business logic
├── UserController.java            # User REST endpoints
├── Todo.java                      # Todo document (MongoDB)
├── TodoRepository.java            # Todo data access
├── TodoService.java               # Todo business logic
└── TodoController.java            # Todo REST endpoints
```

## Setup

1. Install Java 21 and MongoDB
2. Start MongoDB on `localhost:27017`
3. Clone and run:

```bash
git clone https://github.com/trish2023/spring_boot.git
cd spring_boot
./mvnw spring-boot:run
```

The app starts on `http://localhost:8080`. MongoDB creates the `demodb` database and collections automatically on first insert.

## Configuration

Database settings in `src/main/resources/application.properties`:

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/demodb
```
