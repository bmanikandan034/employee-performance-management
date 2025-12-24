# Employee Performance Management System

## Project Overview
This is a simple **Spring Boot REST API** for an **Employee Performance Management System**.

It allows you to:

- Get a list of employees with filters:
  - Performance score on a specific date
  - Department
  - Project
- Get full details of a single employee, including:
  - Department
  - Assigned projects
  - Last 3 performance reviews

The application uses an **in-memory H2 database**, making it easy to run and test without any external setup.

---

## Tech Stack
- Java 17
- Spring Boot 3
- Spring Data JPA (Hibernate)
- H2 Database (In-memory)
- Lombok
- Gradle

---

## How to Run the Project

### 1️⃣ Clone the repository
```bash
git clone https://github.com/bmanikandan034/employee-performance-management.git
cd employee-performance-system

2️⃣ Build and run the application
gradlew bootRun


The application will start at:
👉 http://localhost:8080

Testing the API

You can test the APIs using:

-Postman

-curl

-Browser

**Swagger UI**

Open Swagger for API documentation and testing:
👉 http://localhost:8080/swagger-ui.html
