# Spring Boot Implementation

### 1. Hello World API

```
GET /yo?name=<name>  →  "Hello, <name> Welcome to Spring Boot!"
GET /yo              →  "Hello, World! Welcome to Spring Boot!"
```

### 2. Calculator API

Takes values from the query string and returns the result.

```
GET /add?a=5&b=3       →  8
GET /subtract?a=10&b=4  →  6
GET /multiply?a=3&b=7   →  21
```

### 3. User CRUD API (in-memory)

In-memory list, no database. The starting point before adding persistence.

```
GET    /users         →  list all users
POST   /users         →  create a user (JSON body)
DELETE /users/{id}    →  delete a user by id
```
### 4. User CRUD with MongoDB

Same endpoints as 3, but backed by a real database.

```
GET    /users         →  list all users (from MongoDB)
POST   /users         →  create a user (saved to MongoDB)
DELETE /users/{id}    →  delete a user from MongoDB
```

### 5. Todo List API

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

### 6. Login/Register API
Users can sign up and log in.  
Passwords are hashed with BCrypt before storing.  
POST /auth/register → create a new account  
POST /auth/login → log in with username + password  

**Example register body:**
```json
{
  "username": "randomname",
  "email": "randomname@example.com",
  "password": "mypassword123"
}
```
**Example login body:**

```{
  "username": "randomname",
  "password": "mypassword123"
}
```

