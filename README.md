# Todo Task Management API

A Spring Boot-based Task Management API (To-Do List) that allows users to manage their daily tasks. This API supports creating, reading, updating, and deleting tasks, with additional functionalities such as optimistic locking and detailed API documentation powered by Swagger (springdoc-openapi).

## Table of Contents

- [Features](#features)
- [Technology Stack](#technology-stack)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation & Setup](#installation--setup)
- [API Documentation](#api-documentation)
- [API Endpoints](#api-endpoints)
- [Optimistic Locking](#optimistic-locking)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Features

- **Task Management:** Create, update, retrieve (with optional filtering by status), and delete tasks.
- **Optimistic Locking:** Uses a version field to prevent concurrent update issues.
- **Swagger API Documentation:** Easily explore and test the API endpoints using the integrated Swagger UI.
- **Clean Architecture:** Structured using Spring Boot, Spring Data JPA, and Lombok for maintainability and clarity.

## Technology Stack

- **Java:** 17 or higher
- **Spring Boot:** REST API development
- **Spring Data JPA:** Database interactions
- **Lombok:** Reducing boilerplate code in model classes
- **Springdoc OpenAPI:** API documentation (Swagger UI)
- **Database:** Postgresql

## Getting Started

### Prerequisites

- Java 17 or later installed
- Maven (or use the Maven Wrapper provided)
- An IDE such as IntelliJ IDEA or Eclipse

### Installation & Setup

1. **Clone the repository:**

   ```bash
   git clone https://github.com/BOOUTCHOUANG1/todo-api.git
   cd todo-api
   
2. **Build the project using Maven:**

   ```bash
   mvn clean install

3. **Run the application:**

   ```bash
   mvn spring-boot:run

## API Documentation

- The application’s API documentation is automatically generated with Springdoc OpenAPI (Swagger). After starting the application, open your browser and visit:
- Swagger UI: http://localhost:8080/swagger-ui.html
- This interactive documentation allows you to explore and test every endpoint directly from your browser.

## API Endpoints

- Below is an overview of the primary endpoints exposed by the API:

1. **Create a Task**

- **Endpoint:** POST /api/tasks
- **Description:** Creates a new task.
- **Request Body Example:** 

   ```Json
  {
   "title": "Buy groceries",
  "description": "Milk, eggs, bread",
  "status": "TODO"
   }

2. **Retrieve Tasks**

- **Endpoint:** GET /api/tasks
- **Description:** Returns all tasks. You can optionally filter tasks by status.
- **Request Body Example:** status (optional; values: TODO, IN_PROGRESS, DONE)

3. **Update a Task**

- **Endpoint:** PUT /api/tasks/{id}
- **Description:** Updates an existing task. You can modify the title, description, or status.
- **Request Body Example:**

   ```Json
   {
    "title": "Buy groceries and supplies",
    "description": "Milk, eggs, bread, and cleaning supplies",
    "status": "IN_PROGRESS"
   }

## Optimistic Locking

This project uses optimistic locking to handle concurrent updates to a task. A version field in the Task entity prevents data conflicts by ensuring that any update operation is based on the most recent version of the entity.

## Testing

- You can test the API endpoints using:
- **Swagger UI:** http://localhost:8080/swagger-ui.html
- **Postman** or any similar API client.

- To run the tests (if provided):

   ```bash
   mvn test

## Contributing

Contributions are welcome! Feel free to fork the repository, create a new branch for your feature or bug fix, and submit a pull request. For major changes, please open an issue first to discuss what you would like to change.

## License

This project is licensed under the MIT License. See the LICENSE file for more details.

## License

For any inquiries, suggestions, or issues, please contact:

- **Boutchouang Nathan Elija:** boutchouangelija@gmail.com
