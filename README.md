# Chat Bot Backend

This repository contains the backend code for the chat bot website, built using Java, Spring Boot, Spring Data, and SQL. The backend provides a RESTful API for communication with the frontend, allowing seamless integration and data exchange.

## Features

- RESTful API: Provides endpoints for the frontend to communicate with the backend, enabling smooth data exchange and interaction.
- AI Personality Management: Allows the creation, retrieval, update, and deletion of AI personalities through API endpoints.
- Database Integration: Utilizes SQL and Spring Data to store and retrieve AI personality data in a persistent database.
- Secure Communication: Implements authentication and authorization mechanisms to ensure secure communication between the frontend and backend.

## Technologies Used

- Java: A widely used programming language, used for developing the backend logic and business rules.
- Spring Boot: A powerful framework for building Java applications, providing essential features such as dependency injection, web services, and more.
- Spring Data: A module of the Spring Framework that simplifies database access and provides a high-level API for data persistence.
- SQL: A standard language for managing relational databases, used for storing and retrieving AI personality data.
- REST: Representational State Transfer is an architectural style used for designing networked applications. It facilitates communication between the frontend and backend through standard HTTP protocols.

## Getting Started

To set up the development environment and run the backend server, follow these steps:

1. Clone the repository:

```bash
git clone https://github.com/saulgaray0131/charaichat
```

2. Navigate to the project directory:

```bash
cd chat-bot-backend
```

3. Import the project into your preferred Java IDE.

4. Configure the database connection by updating the `application.properties` file with your database credentials.

5. Build and run the application using your IDE or the following command:

```bash
./mvnw spring-boot:run
```

6. The backend server will start running on `http://localhost:8080`.

## API Endpoints

- **GET /api/bots**: Retrieves all AI users.
- **POST /api/create/bot**: Creates a new AI user.
- **GET /api/bot/{id}**: Retrieves a specific AI user by ID.
- **POST /api/create/user**: Creates a new user.
- **POST /api/chats**: Retrieves the chats for a specific user.
- **POST /api/create/chat**: Creates a new chat.
- **POST /api/chatdata**: Retrieves chat data for a specific chat.
- **POST /api/chat**: Sends a chat message and receives a response.
- **POST /api/account/edit/username**: Edits the username of a user.
- **POST /api/account/data**: Retrieves user data for a specific user.

Please refer to the corresponding Java code for more details on request and response formats, as well as any additional authentication or error handling mechanisms that may be in place.

Refer to the API documentation or code comments for more details on request/response formats and authentication requirements.

## Database Schema

The backend utilizes a SQL database for storing AI personality data. The database schema includes the following tables:

- `personalities`: Stores AI personality information, such as ID, name, traits, and any additional properties.

Ensure that you have the necessary database set up and configured in your environment for proper data storage and retrieval.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvements, please submit an issue or open a pull request.

## License

This project is licensed under the [MIT License](LICENSE).

## Acknowledgments

- The backend logic was implemented using the Java programming language and Spring Boot framework.
- Spring Data simplified the integration with the database for seamless data persistence.
- REST principles were followed to design the API endpoints and facilitate communication with the frontend.
- Special thanks to the open-source community for their contributions and inspiration.

## Contact

For any inquiries or feedback, please contact [me](mailto:saulgaray0131@gmail.com).

Happy coding!
