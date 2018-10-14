RESTful CRUD
==========================
A simple project demonstrating CRUD operations from a jQuery-based UI against a RESTful service layer built using Spring's @RestController

Generate project directory
==========================
Go to https://start.spring.io/ and select Web, and  Devtools (for auto-restart to speed up development) 

How to Run:
==========================
	mvn clean spring-boot:run
	
Go to http://localhost:8080
Here, the Resource is a POJO with two attributes, ID, and Value.
To create, or update, you need to enter both of these values, and click Create or Update. 
To get all instances of the resource, click Get All. The server returns a *dummy* collection of Pojo. In this simple example, resources are not stored anywhere, and hence the *dummy* collection is being returned.
Similar to Get All, enter a number in ID, and click Get to get the Pojo for that ID.
Enter a number in ID, and click Delete to delete the Pojo for that ID.
Enter a number in ID, and a value in Value, and click Patch to update the Value of the Pojo for that ID.

Here are the HTTP verbs being used behing the scene by each button to communicate the request to the server:
Create - POST
Get All and Get By ID - GET
Update - PUT
Patch - Patch
Delete - DELETE
 