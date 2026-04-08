# Learning Spring Boot

## Level 1 — Controllers and REST

### 1. Hello World API

```
GET /yo?name=<name>  →  "Hello, <name> Welcome to Spring Boot!"
GET /yo              →  "Hello, World! Welcome to Spring Boot!"
```
**Concepts:** `@RestController`, `@GetMapping`, `@RequestParam`
---

### 2. Calculator API

Takes values from the query string and returns the result.

```
GET /add?a=5&b=3       →  8
GET /subtract?a=10&b=4  →  6
GET /multiply?a=3&b=7   →  21
```
**Concepts:** `@RequestParam`, returning different data types

---

### 3. User CRUD API (in-memory)

In-memory list, no database. The starting point before adding persistence.

```
GET    /users         →  list all users
POST   /users         →  create a user (JSON body)
DELETE /users/{id}    →  delete a user by id
```

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
**Concepts:** `@PatchMapping`, custom repository query methods (`findByCompleted`), boolean fields, `LocalDateTime` timestamps

---



Database settings in `src/main/resources/application.properties`:

```properties
spring.data.mongodb.uri=mongodb://localhost:27017/demodb
```
