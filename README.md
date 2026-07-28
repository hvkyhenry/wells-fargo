# Financial Counselor Backend

This project is the backend service for a financial counseling application, originally started as part of the Forage Wells Fargo software engineering program. It provides the core logic and data management for advisors, clients, portfolios, and securities.

## Built With

- [Java](https://www.java.com/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Maven](https://maven.apache.org/)

## Getting Started

To get a local copy up and running, follow these simple steps.

### Prerequisites

- JDK 17 or higher
- Maven

### Running the Application

1.  Clone the repo:
    ```sh
    git clone https://github.com/your_username/your_repository.git
    ```
2.  Navigate to the project directory:
    ```sh
    cd wells-fargo
    ```
3.  Run the application using the Maven wrapper:
    `sh
    ./mvnw spring-boot:run
    `
    The application will start on `http://localhost:8080`.

## Roadmap: Future Improvements

This project is actively being developed. Here are the next steps planned to build a production-grade backend system:

- [ ] **Implement Service and Repository Layers:** Build out the business logic and data access layers.
- [ ] **Build REST API Controllers:** Expose the service layer functionality through RESTful endpoints.
- [ ] **Introduce Data Transfer Objects (DTOs):** Decouple the API from the database entities for better security and flexibility.
- [ ] **Add Input Validation:** Ensure data integrity by validating all incoming API requests.
- [ ] **Implement Global Exception Handling:** Create a centralized system for handling application errors gracefully.
- [ ] **Secure the API with Spring Security:**
  - [ ] Implement Basic Authentication.
  - [ ] Evolve to JWT (JSON Web Token) based authentication.
  - [ ] Add role-based access control (e.g., `ADVISOR` vs. `CLIENT` roles).
- [ ] **Set up Logging and Monitoring:** Integrate logging and use Spring Boot Actuator for application health checks.

_(Note: This is a living document and will be updated as the project progresses.)_
