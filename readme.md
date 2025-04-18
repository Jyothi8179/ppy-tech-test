
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
  "fields": ["parent_code"],
  "count_only": false,
  "search": {
    "value": "Master"
  },
  "start": 0,
  "length": 10,
  "filterParam": {
    "plan": "REGULAR"
  }
}
```
- **Response:**
```json
{
   "content": [
      {
         "parent_code": "PC002"
      }
   ],
   "pageable": {
      "pageNumber": 0,
      "pageSize": 10,
      "sort": {
         "empty": true,
         "sorted": false,
         "unsorted": true
      },
      "offset": 0,
      "paged": true,
      "unpaged": false
   },
   "last": true,
   "totalElements": 1,
   "totalPages": 1,
   "size": 10,
   "number": 0,
   "sort": {
      "empty": true,
      "sorted": false,
      "unsorted": true
   },
   "first": true,
   "numberOfElements": 1,
   "empty": false
}
```

### 2. **Create Master List Record**
- **Endpoint:** `POST /api/v1/master-list`
- **Request:**
```json
{
   "parentCode": "PC00234",
   "parentName": "Parent Name-4",
   "name": "Test List Name",
   "plan": "REGULAR",
   "option": "GROWTH",
   "optionFrequency": "FORTNIGHTLY",
   "subCategory": "DEBT",
   "sector": "AGRICULTURE",
   "benchmark": "NSE_50",
   "faceValue": 1000,
   "transactionModeAllowed": {
      "ONLINE": "NO",
      "OFFLINE": "YES"
   }
}
```
- **Response:**
```json
{
   "id": 73,
   "parentCode": "PC00234",
   "parentName": "Parent Name-4",
   "name": "Test List Name",
   "plan": "REGULAR",
   "option": "GROWTH",
   "optionFrequency": null,
   "subCategory": null,
   "sector": "AGRICULTURE",
   "benchmark": "NSE_50",
   "faceValue": 1000,
   "transactionModeAllowed": null
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
