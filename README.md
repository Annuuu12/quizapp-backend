# Quiz Application Backend

A secure Quiz Application Backend built using Spring Boot, PostgreSQL, Spring Security, and JWT Authentication.

## Features

* User Registration and Login
* JWT-based Authentication
* Role-Based Authorization (ADMIN / USER)
* Quiz Creation and Management
* Question Management
* Quiz Attempt History
* User-Specific Attempt Tracking
* Admin Dashboard APIs
* DTO-based API Responses
* Global Exception Handling
* Input Validation
* PostgreSQL Integration

## Tech Stack

* Java 17
* Spring Boot 3
* Spring Security
* Spring Data JPA
* PostgreSQL
* JWT (JSON Web Tokens)
* Maven
* Lombok

## API Endpoints

### Authentication

| Method | Endpoint       |
| ------ | -------------- |
| POST   | /auth/register |
| POST   | /auth/login    |

### Questions

| Method | Endpoint                      |
| ------ | ----------------------------- |
| GET    | /question/allQuestions        |
| GET    | /question/category/{category} |
| POST   | /question/add                 |
| PUT    | /question/update/{id}         |
| DELETE | /question/delete/{id}         |

### Quiz

| Method | Endpoint          |
| ------ | ----------------- |
| POST   | /quiz/create      |
| GET    | /quiz/get/{id}    |
| POST   | /quiz/submit/{id} |

### Attempts

| Method | Endpoint                   |
| ------ | -------------------------- |
| GET    | /attempts/my-history       |
| GET    | /attempts/all (ADMIN only) |

## Security

* Passwords are encrypted using BCrypt.
* JWT tokens are used for authentication.
* ADMIN-only endpoints are protected using Spring Security role-based authorization.

## Database

PostgreSQL is used as the database.

Update the datasource configuration in:

```yaml
src/main/resources/application.yaml
```

before running the application.

## Run Locally

```bash
git clone <repository-url>

cd quizapp-backend

mvn spring-boot:run
```

## Future Enhancements

* React Frontend
* Quiz Analytics Dashboard
* Refresh Token Support
* Leaderboard
* Email Verification
* Password Reset

## Author

Anuradha Gupta
