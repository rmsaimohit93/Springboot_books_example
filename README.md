Spring_Boot_CRUD_Example

This is a Spring Boot application that demonstrates CRUD (Create, Read, Update, Delete) operations, based on the tutorial from [Javatpoint](https://www.javatpoint.com/spring-boot-crud-operations).

Table of Contents

- [Features](#features)
- [Requirements](#requirements)
- [Setup](#setup)
- [Usage](#usage)
- [API Endpoints](#api-endpoints)
- [Testing](#testing)
- [Contributing](#contributing)
- [License](#license)

Features

- Create new records
- Read existing records
- Update existing records
- Delete records

Requirements

- Java 8 or higher
- Maven 3.6.0 or higher
- Spring Boot 2.5.4 or higher

Setup

1. Clone the repository:
    ```sh
    git clone https://github.com/rmsaimohit93/Springboot_books_example.git
    cd Springboot_books_example
    ```

2. Build the project:
    ```sh
    mvn clean install
    ```

3. Run the application:
    ```sh
    mvn spring-boot:run
    ```

4. The application will start on `http://localhost:8080`.

Usage

To use the application, you can interact with the API using tools like Postman or cURL.

API Endpoints

Here are the main API endpoints for the CRUD operations:

- Create a new record
    ```sh
    POST /books
    ```
    - Request Body: JSON with book details (e.g., `{"id": 1, "title": "Book Title", "author": "Author Name", "price": 1000}`)

- Get all records
    ```sh
    GET /book
    ```

- Get a record by ID
    ```sh
    GET /book/{id}
    ```

- Update a record
    ```sh
    PUT /books/{id}
    ```
    - Request Body: JSON with updated book details (e.g., `{"title": "Updated Title", "author": "Updated Author", "price": 1200}`)

- Delete a record
    ```sh
    DELETE /books/{id}
    ```

Testing

To run the tests for the application, use the following command:
```sh
mvn test
