# PE2022-BackEnd
Creating Logical and Database for the course Programming Exercise 2022 - Prof. Huynh Trung Hieu
### Deadline 16/06/2022

## Application Install (REQUIREMENT)
- Postman (For API Testing)
- IntelliJ Community IDE(For Java Development)
- MySQL Workbench
- MySQL Server

## Database(Setup)
- Connect to your connection
- Create a new schema in the connection(in our case is PMSDatabase)

## Spring-Boot Application for IntelliJ (Setup)
- Download Repository -> Extract to your desired Directory
- go inside Folder .mvn/wrapper -> Open maven.wrapper.jar with IntelliJ -> Wait for IntelliJ to finish download all the external resources.
- Edit File in /src/main/resources/application.properties
  - Configurate your Port connection(in our case Port is 3306)
  - Edit username and passwords to your root username and password
  - Edit the schema name in the connection to your schema(in our case is PMSDatabase)
- Run the Application file in /src/main/java/PharmacyManagermentApplication.java


## API CONTROL(POSTMAN)
### **GETservice** //Get data from table
- http://localhost:8080/api/v1/Clients
- http://localhost:8080/api/v1/Drugs
- http://localhost:8080/api/v1/DrugStores
- http://localhost:8080/api/v1/DrugSuppliers
- http://localhost:8080/api/v1/Employees
- http://localhost:8080/api/v1/Logins
- http://localhost:8080/api/v1/Managers
- http://localhost:8080/api/v1/Orders
- http://localhost:8080/api/v1/Stores
### **POSTservice**//Insert(Check for duplication) data into Table
- Insert via JSON FORMAT {"id": 1, "clientID": "C1", "employeeID": "E1"}
- http://localhost:8080/api/v1/Clients/insert
### **PUTservice** //Update or Insert data inside Table
- http://localhost:8080/api/v1/Clients/1 (1 here is the id of the Client)
- Same applied for other API
### **DELETEservice** //Delete data inside Table
- http://localhost:8080/api/v1/Clients/delete/1 (1 here is the id of the Client)
- Same for orther API
## Development Notes
- Code is Fixed Now
- ref: https://youtu.be/UMePnyjr6FM
- Postman
https://www.postman.com/

