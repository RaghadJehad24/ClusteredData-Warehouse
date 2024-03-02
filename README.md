# Clustered Data Warehouse

This project is a Spring Boot application designed to manage FX (Foreign Exchange) deals in a clustered data warehouse environment. It provides a RESTful API for creating and retrieving FX deals, with support for validation and error handling.

## Features

- **FxDeal Management**: Create and retrieve FX deals with unique identifiers.
- **Validation**: Ensures that FX deals have valid data before they are saved.
- **Error Handling**: Provides custom error responses for validation errors and duplicate FX deals.
- **Docker Support**: Includes Dockerfile and docker-compose configuration for easy deployment.

## Getting Started

### Prerequisites

- Java 17
- Maven 3.8.4
- Docker

### Building the Application

1. Clone the repository.
2. Navigate to the project directory.
3. Run `mvn clean package` to build the application.

### Running the Application

#### Using Docker

1. Ensure Docker and Docker Compose are installed and running.
2. Navigate to the project directory.
3. Run `docker-compose up --build` to start the application and its dependencies.

#### Manually

1. Ensure Java 17 is installed.
2. Navigate to the project directory.
3. Run `java -jar target/ClusteredData-0.0.1-SNAPSHOT.jar` to start the application.

## API Documentation

### Endpoints

- **POST /api/fx-deals**: Creates a new FX deal.
 - Request Body: `FxDeal` object.
 - Response: `FxDealResponse` object with a success message and the created FX deal's details.

- **GET /api/fx-deals/{uniqueId}**: Retrieves an FX deal by its unique identifier.
 - Path Variable: `uniqueId` - The unique identifier of the FX deal.
 - Response: `FxDealResponse` object with the FX deal's details or a 404 Not Found if the deal does not exist.

### Error Handling

- **400 Bad Request**: Returned for validation errors in the request body.
- **409 Conflict**: Returned when attempting to create an FX deal with a unique identifier that already exists.

## Contributing

Contributions are welcome. Please open an issue or submit a pull request.

## License

This project is licensed under the MIT License. See the `LICENSE` file for details.
