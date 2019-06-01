<h2>Taxi Booking Application</h2>

<h3>Requirements</h3>
For building and running the application you would require:<br>

<ul>
<li>JDK 1.8</li>
</ul>

<h3>Running the application</h3>
<ul>
<li>Run following command to build and run the application <b>./mvnw clean spring-boot:run</b></li>
</ul>

<h3>End Points</h3>
One end point is exposed for providing cancellation rates for taxi, which used request parameters as start and end day of trip booked.
Following is the url, hitting which would return list of cancellation rates in JSON format.
<ul>
  <li><h4>localhost:8080/cancellationRate?start=May 1, 2019&end=May 3, 2019</h4>
    </li>
</ul>

![alt text](https://github.com/arorakapil13990/kmart/blob/master/swagger1.jpg)

![alt text](https://github.com/arorakapil13990/kmart/blob/master/swagger2.jpg)

<h3>Documentation</h3>
<ul>
Swagger - Documentation & Testing <b>http://localhost:8080/swagger-ui.html</b>
</ul>

<h3>Technologies and Frameworks used</h3>
For building and running the application you need:<br>

<ul>
<li>Language: Java 8</li>
<li>Build and Packaging: Maven</li>
<li>Application Framework: Spring Boot</li>
<li>Persistence Framework: Spring JPA and Hibernate</li>
<li>Application Documentation: Swagger</li>
<li>Database Change Management: Flyway</li>
<li>Database: H2</li>
<li>Unit Testing: Junit, Mockito</li>
<li>Integration Testing: Spring Test</li>
<li>Coverage Tool: Jacoco</li>
</ul>

<h3>Startup data</h3>
<ul>
Flyway will help in inserting initial trip related data in H2 database on start of the Spring Boot application. It will create two tables, one for trip details and other for user details, holding respective data.
</ul> 

<h3>Test cases</h3>
<ul>
Test cases covering unit and integrated aspects of the taxi booking applicating ensuring 100% testabilty of the code, mainly for Controller and Service classes. 
</ul>

<h3>Running test cases and checking coverage</h3>
<ul>
<li>Run following command to run unit and integration test cases <b>./mvnw clean test</b></li>
<li>Run following command to generate test coverage in html format <b>./mvnw clean site</b></li>
</ul>

<h3>packages</h3>
<ul>
<li><b>config</b> — COntains appropriate configuration required application wide</li>
<li><b>constants</b> — COntains all constants used application wide</li>
<li><b>entity</b> — to hold our entities</li>
<li><b>repository</b> — to communicate with the database</li>
<li><b>service</b> — to hold our business logic</li>
<li><b>controller</b> — to listen to the client</li>
<li><b>dto</b> — to create required request and response objects to be transfered</li>
<li><b>enums</b> — to define fixed set of constants to be used application wide</li>
<li><b>resources/</b> - Contains all the static resources and property files.</li>
<li><b>resources/migration</b> - static sql data</li>
<li><b>resources/application.properties</b> - It contains application-wide properties. Spring reads the properties defined in this file to configure your application. We can define server’s default port, server’s context path, database URLs etc, in this file.</li>
<li><b>test/</b> - contains unit and integration tests</li>
<li><b>test/resources/migration</b> - static sql data used for test cases</li>
<li><b>resources/application.properties</b> - It contains application properties for executing test cases. To use this file for running, we can set spring property as <b>mvn spring-boot:run -Dspring.profiles.active=test</b></li>
<li><b>pom.xml</b> - contains all the project dependencies</li>



