A simple demonstration of TCP client-server communication
==========================

Generate Project:
==========================
	mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-simple -DarchetypeVersion=1.3  -DgroupId=com.my -DartifactId=tcpsocket -Dversion=1.0 -Dpackage=com.my

How to Run:	
==========================
Open a command line window, and type	
	mvn clean compile
	java -cp target\classes com.my.Server

Open a second command line window, and type	
	java -cp target\classes com.my.Client

Sample Run:	
==========================
Server Window:
--------------------------
	mvn clean compile
	java -cp target\classes com.my.Server
	Waiting for connection...
	Connected.
	Message from Client!

Client Window:
--------------------------
	java -cp target\classes com.my.Client
	Connected.
	Reply from Server!
	
	