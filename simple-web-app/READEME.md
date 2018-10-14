Generate project directory from maven archetype:
-------------------------------------------------
	mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-webapp -DarchetypeVersion=1.3 -DgroupId=com.my -DartifactId=simple-web-app -Dversion=1.0 -Dpackage=com.my

Add the tomcat plugin:
-------------------------------------------------
	      <plugin>
	        <groupId>org.apache.tomcat.maven</groupId>
	        <artifactId>tomcat7-maven-plugin</artifactId>
	        <version>2.2</version>
	        <configuration>
	          <path>/</path>
	        </configuration>
	      </plugin>      
Run:
-------------------------------------------------
	mvn clean tomcat7:run

View: 
-------------------------------------------------
	http://localhost:8080
	