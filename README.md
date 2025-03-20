# Data Mapping Project

## Description
The **Data Mapping Project** is a Spring Boot application designed to demonstrate various data mapping techniques using Hibernate and Spring Data JPA. It includes different types of entity relationships like One-to-One, One-to-Many, and Many-to-Many.

## Features
- **Entity Mapping**: Demonstrates various entity relationships.
- **CRUD Operations**: Supports create, read, update, and delete operations.
- **Database Integration**: Uses **MySQL** for persistent storage.

## Tech Stack
- **Backend**: Spring Boot, Spring Data JPA, Hibernate
- **Database**: MySQL
- **Build Tool**: Maven
- **IDE**: IntelliJ IDEA
- **Version Control**: GitHub

## Project Structure
```
Data_Mapping/
│── src/
│   ├── main/java/com/example/mapping/
│   │   ├── entity/        # Entity classes
│   │   ├── repository/    # Repository interfaces
│   │   ├── service/       # Business logic layer
│   │   ├── controller/    # REST API controllers
│   ├── main/resources/
│   │   ├── application.properties  # Database configurations
│── pom.xml  # Maven dependencies
│── README.md  # Project documentation
```

## Installation & Setup
1. **Clone the repository:**
   ```sh
   git clone https://github.com/VaishnaviRSawant/Data_Mapping.git
   ```
2. **Navigate to the project directory:**
   ```sh
   cd Data_Mapping
   ```
3. **Configure the database in `application.properties`:**
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/mapping_db
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```
4. **Run the application:**
   ```sh
   mvn spring-boot:run
   ```

## API Endpoints
| Endpoint | Method | Description |
|----------|--------|-------------|
| `/entities` | GET | Get all entities |
| `/entities/{id}` | GET | Get an entity by ID |
| `/entities` | POST | Add a new entity |
| `/entities/{id}` | PUT | Update an entity |
| `/entities/{id}` | DELETE | Delete an entity |

## Contributions
Feel free to contribute by creating issues or submitting pull requests!

## License
This project is **MIT Licensed**.

## Author
[Vaishnavi R Sawant](https://github.com/VaishnaviRSawant)

