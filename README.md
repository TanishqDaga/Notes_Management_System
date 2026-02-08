# Notes Management System (Backend)

A simple backend application to manage notes using REST APIs. Built with Java Spring Boot and MySQL, this project focuses on clean API design, database interaction, and proper layering.

## About the Project
The Notes Management System allows users to create, update, delete, list, and search notes. Each note automatically stores when it was created and last updated, making it easy to track changes over time. This is a backend-only project intended to demonstrate Spring Boot fundamentals, RESTful APIs, and persistence using MySQL.

## Tech Stack
- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Postman (for API testing)

## Features
- Create a new note
- Update existing notes
- Delete notes
- View all notes
- Search notes by keyword
- Automatic created and updated timestamps

## API Endpoints
| Method | Endpoint | Description |
|------|---------|-------------|
| POST | /notes/create | Create a new note |
| GET | /notes | Get all notes |
| GET | /notes/search/{keyword} | Search notes |
| PUT | /notes/update/{id} | Update a note |
| DELETE | /notes/{id} | Delete a note |

## Project Structure
src/main/java/com/notesmanagementsystem
├── controller
├── service
├── repository
├── entity
└── exception

## Running the Project
1. Clone the repository
2. Create a MySQL database
3. Configure database credentials in application.properties
4. Run the application using: mvn spring-boot:run
5. Server starts at http://localhost:8080

## API Testing
All APIs are tested using Postman. The Postman collection is available in the postman/ folder.

## Notes
- Backend-only repository
- Frontend can be integrated separately
- Created for learning and backend development practice

## Author
Tanishq Daga

