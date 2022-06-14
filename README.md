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

## RESTful API Documentation via Swagger

Access point: http://localhost:8080/swagger-ui/#/


## API CONTROL(POSTMAN)
- To connect to Database use this link: http://localhost:8080 which expose the following APIs
- There are following API to connect to table


API | Table | Description
--- | --- | ---
/api/v1/Clients | client | client info
/api/v1/Drugs | drug | drugs info
/api/v1/DrugStores | drugStore | drug store info
/api/v1/DrugSuppliers | drugSupplier | drug suppier info
/api/v1/Employees | employee | employee info
/api/v1/Logins | login | login info
/api/v1/Managers | manager | manager info
/api/v1/Orders | order | order info
/api/v1/Stores | store | store info

### REST API methods:

URL |	HTTP | Method |	Description
--- | --- | --- | ---
/api/v1/Clients	|GET	| Get all Clients
/api/v1/Clients/{id} |	GET |	Get client by ID
/api/v1/Clients/insertClients | POST |	Create a new client
/api/v1/Clients/{id} |	PUT |	Update existing client
/api/v1/Clients/delete{id} |	DELETE |	Delete client by ID


## Development Notes
- Code is Fixed Now
- ref: https://youtu.be/UMePnyjr6FM
- Postman
https://www.postman.com/

