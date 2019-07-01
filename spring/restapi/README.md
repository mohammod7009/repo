A simple RESTful API demonstrating CRUD operations on a simple POJO.

Features:
==========================
Implementations of the below methods. Each method responds with appropriate http-status.
- GET  method to retrieve all records, or a single record by ID
- POST  method to create a new record and return the created instance
- DELETE  method to delete a record by ID
- PUT  method to update a record
- PATCH method to update a record by ID

Generic exception handiling for all controllers, using @ControllerAdvice

How to Run:
==========================
	mvn clean spring-boot:run
	
Go to http://localhost:8080
Here, the Resource is a POJO ("User") with two attributes, Id, and Name.
You can use any client such as Postman to submit requests against this API.

 