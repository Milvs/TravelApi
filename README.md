# Travel API

This is a Spring Boot-based RESTful API for managing holidays, locations, and reservations in the travel industry.

## Table of Contents

- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
- [Usage](#usage)
  - [API Endpoints](#api-endpoints)
  - [Project Structure](#project-structure)


## Getting Started

### Prerequisites

Make sure you have the following installed on your machine:

- Java 11 or higher
- Maven
- Docker (optional for running with Docker Compose)
- MySQL

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/travel-api.git
   cd travel-api

1.2  Running with Docker Compose<br>

If you prefer running the MySQL database with a docker-compose file:<br>
Run the database container:
   
    docker-compose up -d

If you want to stop and remove the container:

   ```
   docker-compose down
```

1.3 Running with MySQL Database:<br>

Open the `src/main/resources/application.properties` file and configure the database connection properties:<br>
Adjust the API port, database credentials, and other configurations as needed.<br>
Make sure you have a MySQL database installed and running.

   ```bash

   spring.datasource.url=jdbc:mysql://localhost:3306/travel_db
   spring.datasource.username=your_username
   spring.datasource.password=your_password
```

Build and run the application!

## Usage

The application will be accessible at http://localhost:8080.

### API Endpoints

**Holidays:**

- Create Holiday: `POST /holidays`
- Delete Holiday: `DELETE /holidays/{id}`
- Get All Holidays By Filters: `GET /holidays`
- Get Holiday by ID: `GET /holidays/{id}`
- Update Holiday: `PUT /holidays`

**Locations:**

- Create Location: `POST /locations`
- Delete Location: `DELETE /locations/{id}`
- Get All Locations: `GET /locations`
- Get Location by ID: `GET /locations/{id}`
- Update Location: `PUT /locations`

**Reservations:**

- Create Reservation: `POST /reservations`
- Delete Reservation: `DELETE /reservations/{id}`
- Get All Reservations: `GET /reservations`
- Get Reservation by ID: `GET /reservations/{id}`
- Update Reservation: `PUT /reservations`

### Project Structure

The project is organized into controllers, services, and repositories. Exception handling is centralized in the `GlobalExceptionHandler` class. The application uses ModelMapper for DTO conversion and Spring Data JPA for database interactions.

- `src/main/java/com/example/travelapi/controllers`: Contains the API controllers.
- `src/main/java/com/example/travelapi/services`: Implements business logic and data manipulation.
- `src/main/java/com/example/travelapi/dtos`: Data Transfer Objects for API requests and responses.
- `src/main/java/com/example/travelapi/entities`: JPA entities representing database tables.
- `src/main/java/com/example/travelapi/exceptions`: Custom exceptions for error handling. These are centrally handled using the `GlobalExceptionHandler` class.
- `src/main/java/com/example/travelapi/configurations`: Contains configuration class for `ModelMapper`, responsible for DTO conversion.
