
# Master List API - Spring Boot Application

## 📚 Overview
This project is a Spring Boot application designed to provide a flexible and efficient API to manage master list records with advanced filtering, pagination, and dynamic search functionality.

---

## 🚀 Key Features
- **API for Master List Operations**: Create, retrieve, and filter master list records.
- **Dynamic Filtering and Pagination**: Supports dynamic filters using JPA Specifications.
- **Efficient Query Handling**: Supports criteria-based querying using multiple filter options.
- **Error Handling**: Handles API errors gracefully with descriptive messages.
- **Pagination and Sorting**: Supports pageable responses with limit and offset.

---

## 🛠️ Tech Stack
- **Backend:** Spring Boot, Java
- **Database:** PostgreSQL
- **ORM:** Hibernate, JPA
- **Build Tool:** Maven
- **API Documentation:** Postman

---

## 📂 Project Structure
```
/master-list-api
├── /src
│   ├── /main
│   │   ├── /java/com/example/masterlist
│   │   │   ├── /controller
│   │   │   │   └── MasterListController.java
│   │   │   ├── /dto
│   │   │   │   └── MasterListFilterRequestDto.java
│   │   │   ├── /entity
│   │   │   │   └── MasterListEntity.java
│   │   │   ├── /repository
│   │   │   │   └── MasterListRepository.java
│   │   │   ├── /service
│   │   │   │   └── MasterListService.java
│   │   │   └── /specification
│   │   │   |   └── MasterListSpecification.java 
│   │   │   └── /mapper
│   │   │       └── MasterListMapper.java
│   │   ├── /resources
│           └── application.propertie
└── /pom.xml
└── /Dockerfile
└── /docker-compose.yaml
└── /readme.md

---

## 📢 API Endpoints
### 1. **Filter Master List Records**
- **Endpoint:** `POST /api/v1/master-list/filter`
- **Request:**
```json
{
  "fields": ["ALL"],
  "count_only": false,
  "search": {
    "value": "Sample Name"
  },
  "start": 0,
  "length": 10,
  "filterParam": {
    "name": "Master List Name",
    "plan": "DIRECT"
  }
}
```
- **Response:**
```json
{
  "content": [
    {
      "id": 1,
      "name": "Master List Name",
      "plan": "DIRECT",
      "option": "Option 1",
      "sector": "Sector Name"
    }
  ],
  "totalElements": 1,
  "totalPages": 1,
  "pageNumber": 0
}
```

### 2. **Create Master List Record**
- **Endpoint:** `POST /api/v1/master-list`
- **Request:**
```json
{
  "name": "Master List Name",
  "plan": "DIRECT",
  "option": "Option 1",
  "sector": "Sector Name"
}
```
- **Response:**
```json
{
  "id": 1,
  "name": "Master List Name",
  "plan": "DIRECT",
  "option": "Option 1",
  "sector": "Sector Name"
}
```

---

## 🎯 Filtering Implementation Using JPA Specification
- **Dynamic Filters:** Using `MasterListSpecification`, multiple filter conditions are dynamically generated based on request parameters.
- **Criteria Builder:** Constructs predicates dynamically for name, plan, option, and sub-category.
- **Pagination & Sorting:** Pageable object applies offset and limit with sorting options.

---

## 📝 How to Run
1. Clone the repository:
```bash
  git clone https://github.com/Jyothi8179/ppy-tech-test.git
```
2. Navigate to the project directory:
```bash
  cd master-list-api
```
3. Build the application:
```bash
  mvn clean install
```
4. Run the application:
```bash

=======
  docker-compose up --build
```
5. Access API on `http://localhost:8080/api/v1/test`

   It should return 
```
  Working fine
```

---

## 📝 Configuration
Update `application.properties` with your PostgreSQL configuration.
```
spring.datasource.url=jdbc:postgresql://localhost:5432/masterlist_db
spring.datasource.username=postgres
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```
