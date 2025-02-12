<link rel="stylesheet" href="../style.css" />

# 🟪 Section 1: Spring Boot 3 - Quick Start

# 🧠 1.1 Spring Boot

## 🟦 Overview

* Spring Boot simplifies the start up of a spring application. It minimises setup configuration including servers and dependency conflicts

* Has an embedded HTTP server, so we can use Tomcat straight away!

* We can use Spring Initializr to set up out project

## 🟦 Running Spring Boot Apps

* We can run a Spring Boot application standalone using the jar file which is created

* You can also deploy a WAR file to an external server, the WAR file excludes the server configuration.

    <img  width="300px" src="screenshots/2023-03-26-10-50-40.png">

## 🟦 FAQs

1) **Does Spring boot replace Spring MVC, Spring Rest?**

    A: No! Spring uses these depenendencies!

    <img  width="300px" src="screenshots/2023-03-26-10-51-37.png">

2) **Is Spring Boot faster?**

    A: No!

<hr>

# 🧠 1.2 Sprint Boot Initializr Demo

## 🟦 Maven Solution

* Maven can be used to download all the JAR dependencies we need!

## 🟦 Spring Initiailizr

* I go to the Spring Initiailzr website [here](https://start.spring.io/)

* The dependencies I take is Spring Web.

* I have the following project setup:

    <img  width="500px" src="screenshots/2023-03-26-10-58-33.png">

* I unzip the folder into this directory [here](/Section%201%20-%20Spring%203%20Quick%20Start%20Guide/demo%201/mycoolapp/)

* I import in the project into eclipse!

## 🖥️ Code Demo 🖥️

* I click `File -> Open` and select the POM of the unzipped file. I click the build icon and then `Right Click -> Run 'Mycoolappp...(main)`

```java
    @SpringBootApplication
    public class MycoolappApplication {

        public static void main(String[] args) {
            SpringApplication.run(MycoolappApplication.class, args);
        }

    }
```

* I run the application:

    <img  width="500px" src="screenshots/2023-03-26-11-10-39.png">

* Going to localhost:8080 gives me:

    <img  width="300px" src="screenshots/2023-03-26-11-11-13.png">

<br>

# 🧠 1.3 Creating a REST Controller

## 🟦 Plan

* We will create a REST controller, so it will display:

    <img  width="300px" src="screenshots/2023-03-26-11-12-30.png">

* The plan is:

    <img  width="300px" src="screenshots/2023-03-26-12-40-03.png">

## 🖥️ Code Demo 🖥️

* I define a new package and class:

<img  width="300px" src="screenshots/2023-03-26-12-42-36.png">

* I write the following:

```java
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    @GetMapping("/")
    public String sayHello(){
        return "Hello World!";
    }
}
```

* I run my application from the main method. And go to localhost:8080/

<img  width="300px" src="screenshots/2023-03-26-12-44-42.png">

<br>

# 🧠 1.4 Spring Framework Overview

## 🟦 Goals of Spring

* Lightweight development with POJO

* Dependency injection to encourage loose-coupling

* Minimise boiler-plating

* AOP: add functionality such as logging, security and transactions in a declarative manner

* Support for TDD ans mocking objects outside of the container

## 🟦 Data Access Layer

* JDBC - reduces amount of code by 50%

* ORM - objection-relational mapping

* Transaction support on methods

<br>

# 🧠 1.5 Spring Projects

* These are additional modules built on top of the core Spring framework

* There are many projects such as cloud, data, security

<br>

# 🧠 1.6 What is Maven

* Spring Initializr can generate a Maven project for you

## 🟦 What is Maven?

* A popular tool for dependency and build management.

* Let's us download additional dependencies without manual intervention.

* Maven makes the JAR files available during compilation/run

## 🟦 How Maven works:

* Maven will look at your project configuration file

* It will check if your local repo, if it is not present it will download the dependencies from the Maven Central Repo and place it in your local repo!

* Maven will then use your local repo to build the project

    <img  width="300px" src="screenshots/2023-03-26-13-06-34.png">

* Maven willa also download supporting dependencies for the dependencies!

* Maven will handle class/build path for you

<br>

# 🧠 1.7 Maven Project Structure

## 🟦 Project Structure

* Maven uses a standard project structure which encourages uniformity between developers!

* IDEs support Maven out the box, we can also move the project around different IDEs

    <img  width="300px" src="screenshots/2023-03-26-13-09-21.png">

* Java code is stored in src/main/java

* Any web resources are placed in src/main/resources


## 🟦 POM File

* The POM is the Project Object Model file located in root of project! ✅

    <img  width="200px" src="screenshots/2023-03-26-13-19-33.png">

* The POM contains metadata (version, output file type), dependencies and custom task plugins

## 🟦 Simple POM File

<img  width="300px" src="screenshots/2023-03-26-13-21-24.png">

## 🟦 Project Coordinates

* A project coordinate is a way to uniquely identify a project.

* The project coordinate consists of:

    - **Group ID**: the name of organisation or company. E.g. `com.luv2code`

    - **Artifact ID**: the name of the project

    - **Version**: specific release version. E.g. `1.0` or `1.0-SNAPSHOT`

    <img  width="200px" src="screenshots/2023-03-26-13-24-18.png">


<br>

# 🧠 1.8 Spring Boot Project Files

## 🟦 The POM File:

* Looking at the POM from our code:

```xml
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
```

* We can see we have starter dependencies which are a collection of Spring dependencies

* We also have the following plugins:

```xml
<plugins>
    <plugin>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-maven-plugin</artifactId>
    </plugin>
</plugins>
```

* We have a Maven plugin which enables us to download the dependencies using mvn in the command line! E.g.

```cmd
./mvn package
./mvn spring-boot:run
```

## 🟦 Application Properties

* Spring Boot will load properties from `application.properties` which is empty at the beginning!

    <img  width="250px" src="screenshots/2023-03-26-14-11-13.png">

* Currently, it is an empty file 😲

* We COULD use this file to instruct which port number to use. E.g. by writing:

```properties
server.port=8090
```

## 🟦 Reading from Application Properties

* Suppose our application.properties is defined as:

    <img  width="200px" src="screenshots/2023-03-26-14-15-13.png">

* Then we can access the values within our Java code like so:

```java
    @RestController
    public class FunRestController {
        @Value("${coach.name}") 
        private String coachName;
    }
```

## 🟦 Static Content

* Static resources like HTML, CSS, JavaScript, Images will be stored in the `src/main/resources/static` directory: 

    <img  width="200px" src="screenshots/2023-03-26-14-18-10.png">

⚠️ Most build tools will ignore the `src/main/webapp` if you generate a **JAR** file. Works fine with WAR file ⚠️

## 🟦 Templates

* Spring Boot includes auto-configuration for template engines like `FreeMarker`, `Thymelead` and `Mustache`.

* By default Spring Boot will load templates from `src/main/resources/templates`

    <img  width="200px" src="screenshots/2023-03-26-14-22-44.png">

## 🟦 Unit Tests

* We can place our unit-testing files in `src/test/java`:

    <img  width="250px" src="screenshots/2023-03-26-14-24-16.png">

<br>

# 🧠 1.9 Spring Boot Starters

## 🟦 What is a Spring Boot Starter?

* 🎃 Spring Boot Starters are a **list of curated Maven dependencies** from the Spring Team which simplifies the problem for the developers of which Spring dependencies they should download!🎃

## Spring Boot Starter - Web

* Spring Boot provides one of these starters:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

* This dependency contains:

    - spring-web
    - spring-webmvc
    - hibernate-validator
    - json
    - tomcat
    - ...

* ✅ To get this starter from spring.io, you just need to select the "Spring Web" dependency: ✅

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <img  width="350px" src="screenshots/2023-03-26-14-35-34.png">

* ✅  We can view all the dependencies of our project in intelliJ by navigating to `View -> Tool Windows -> Maven -> Your project -> Dependencies` ✅

    <img  width="250px" src="screenshots/2023-03-26-14-52-53.png">

<br>

# 🧠 1.10 Spring Boot Starter Parent

## 🟦 What is a Spring Boot Starter Parent 

* 🎃 Spring Boot provides a Starter Parent - a special starter which provides Maven defaults 🎃

* We can see this near the top of our POM:

```xml
<parent>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-parent</artifactId>
    <version>3.0.5</version>
    <relativePath/> <!-- lookup parent from repository -->
</parent>
```

* We can override a Maven default by specifying a property. E.g., we set the Java version to 17:

```xml
<name>mycoolapp</name>
<description>Demo project for Spring Boot</description>
<properties>
    <java.version>17</java.version>
</properties>
```


<br>

# 🧠 1.11 Spring Boot Dev Tools

## 😞 Problem: 😞

* If we make changes to our code, you must manually restart your application

## 😊 Solution: 😊

* Spring Boot Dev Tools will automatically restart your application when code is updated

* ✅ We just need to add the following dependency to our POM file! ✅

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
</dependency>
```

* IntelliJ does not support spring-devtools by default

* We need to go to `Preferences > Build, Execution, Deployment > Compiler` and check `Build project automatically`

* Additionally, we must see the `Advance Settings` in `Preferences` and under `Compiler`, check the following:

    <img  width="350px" src="screenshots/2023-03-26-15-40-26.png">

<br>

# 🧠 1.12 Spring Boot Dev Tools - Demo

* I create a new copy of Spring project [here](/Section%201%20-%20Spring%203%20Quick%20Start%20Guide/demo%203%20-%20Using%20spring%20dev%20tools/)

* I run the main method in intelliJ and verify spring dev tools is working!

* I add a new mapping in my FunRestController:

```java
// exposing a new endpoint for "workout"
    @GetMapping("/workout")
    public String getDailyWorkOut(){
        return "Run a hard 5k!";
    }
```

* The console shows that the server has restarted and navigating to localhost:8080/workout:

    <img  width="250px" src="screenshots/2023-03-26-15-53-02.png">

* Spring dev tools is working!!!

* I define another endpoint:

```java
    // exposing a new endpoint for "fortune"
    @GetMapping("/fortune")
    public String getDailyFortune(){
        return "Today is your lucky day!";
    }
```

<br>

# 🧠 1.13 Spring Boot Actuator


## 😞 Problem: 😞

* How do I monitory and manage the application, check the health and access the application metrics?

## 😊 Solution: 😊

* 🎃The Spring Boot Actuator exposes endpoints to monitor and manage your application.🎃

* ✅ In order to use the Spring Boot actuator, you need the following dependency ✅

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

* This will automatically expose new end-points which you can visit in the browser!

## 🟦 Health Endpoint

* 🎃 This endpoint gives health of application 🎃

* After adding the above dependency, I can navigate to localhost:8080/actuator/health. I get the following:

    <img  width="250px" src="screenshots/2023-03-26-16-07-18.png">

* This is exposed by default

## 🟦 Info Endpoint

* For the /info endpoint, we need to update our application.properties to include:

```properties
management.endpoints.web.exposure.include=health,info
management.info.env.enabled=true
```

* 🎃 The /info endpoint gives you information on your app. By default it returns empty 🎃

    <img  width="250px" src="screenshots/2023-03-26-16-10-40.png">

* ✅ We can specify the info to return by updating the properties ✅

* E.g., I add the following to my `application.properties` file:

```properties
info.app.name=Some cool application
info.app.description=A crazy and fun app!!!
info.app.version=1.0
```

* Going to the info endpoint now shows:

    <img  width="250px" src="screenshots/2023-03-26-16-14-07.png">

## 🟦 Spring Boot Actuator Endpoints

* There are 10+ Spring Boot Actuator Endpoints, these include:

    <img  width="250px" src="screenshots/2023-03-26-16-16-10.png">

* 😏 We could expose all the actuator endpoints by using a wildcard in the `application.properties`:

```properties
management.endpoints.web.exposure.include=*
```

* We can then look at all the Beans using /actuator/beans endpoint!

* The /actuator/threaddumps displays all the threads of your application.

* The /actuator/mappings displays all the mappings of the app


<br>

# 🧠 1.14 Spring Boot Actuator Security

* We do not want to expose all the endpoints to the public!

* ✅ We add the Spring Security dependency: ✅

```xml
<dependency>
    <groupId>org.springframework.boot<groupId>
    <artifactId>spring-boot-starter-secutriy<artifactId>
</dependency>
```

* Spring security will now enforce a login to access the actuator endpoints.

* There is a default user of `user` and a password generated in the console.

* We can override this user be specifying a username/password in `application.properties`:

```properties
spring.security.user.name=shiv
spring.security.user.password=pass
```

* Currently, the health and info are accessible without login! This is default behaviour

* We can exclude these by updating the `application.properties`:

```properties
management.endpoints.web.exposure.exclude=health,info
```

* Te `/actuator/info` and `/actuator/health` endpoints now require login permissions!

* The `application.properties` file as a whole looks like:

```properties
management.endpoints.web.exposure.include=*
management.info.env.enabled=true

management.endpoints.web.exposure.exclude=health,info

info.app.name=Some cool application
info.app.description=A crazy and fun app!!!
info.app.version=1.0

spring.security.user.name=shiv
spring.security.user.password=pass
```


<br>

# 🧠 1.15 Run Spring Boot Apps from Command Line

* We may want to run our application outside the IDE, one way to do this is to use the command line.

* Since we are using Spring Boot, the server configuration is contained in a JAR file:

    <img  width="250px" src="screenshots/2023-03-27-10-01-12.png">


* There are 2 ways of running the application: using the Jar file with `java -jar mycoolapp.jar` or using the Spring Boot Maven plugin.

* If we do not have Maven install then we execute the following commands:

```console
./mvnw package
./mvnw spring-boot:run
```

* This uses the mvnw file in our project:

    <img  width="250px" src="screenshots/2023-03-27-10-05-15.png">


## 🖥️ Code Demo 🖥️

* I navigated to the root of my project in explorer and started the command line

* I executed the following command:

```console
./mvnw package
```

* But encountered a build failure:

```
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-compiler-plugin:3.10.1:testCompile (default-testCompile) on project mycoolapp: Fatal error compiling: invalid target release: 17 -> [Help 1]
```

* I install Java 17 and update the path variable

* I again run `./mvnw package` and the build is successful!

* I then run `./mvwn spring-boot:run` and my application works

* I also try running the app from the Jar. I navigate to the atarget file:

```
cd .\target
java -jar .\mycoolapp-0.0.1-SNAPSHOT.jar
```

 * Again the application works!!

 * NOTE: both using the `java -jar` and using the `./mvwn spring-boot:run` commands require you to first build the package using `./mvwn package` ⚠️ ⚠️ ⚠️

 <br>

# 🧠 1.17 Injecting Custom Application Properties

## 😞 Problem: 😞

* We need to make the app configurable and not rely on hard-coded values!

## 😊 Solution: 😊

* We can use the `application.properties` file to define any custom properties we need to use within our Spring Boot application

* We can access the properties using `@Value` annotation

## 🖥️ Code Demo 🖥️

* I create a new copy of the project [here](/Section%201%20-%20Spring%203%20Quick%20Start%20Guide/demo%205%20-%20Properties/04-properties-demo/)

* I add the following custom properties in the `application.properties` file:

```properties
coach.name=Mickey Mouse
team.name=The Mouse Club
```

* I add the following lines to my FunRestController:

```java
 // injecting properties for coach.name and team.name
    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    // new end points shows teamName and coachName injected values
    @GetMapping("/teaminfo")
    public String getTeamInfo(){
        return "Coach: "+ coachName + ", Team: "+ teamName;
    }
```

* I go to `localhost:8080/teaminfo`:

    <img  width="350px" src="screenshots/2023-03-27-11-46-42.png">

 <br>

# 🧠 1.18 Configuring Spring Boot Server - Overview

* Spring Boot has over 1000 properties which are categorised as:

    - Core
    - Web
    - Security
    - Data
    - Actuator
    - Integration
    - DevTools
    - Testing

## 🟦 Core Properties

* We can set up logging severity:

    ![](2023-03-27-11-53-04.png)

* We can also specify where to put the logs:

```properties
logging-file=mylog.log
```

## 🟦 Web Properties

* We can specify the server port number

```properties
server.port=7070
```

* The default application context path is `"/"`, but we can change this to `"/mysillyapp"` for example:

```properties
server.servlet.context-path=/mysillyapp
```

* We can also set the default HTTP Session time out

```properties
server.servlet.session.timeout=15m # 15 minutes
``` 

## 🟦 Actuator Properties

* We can include and exclude the actuator endpoints:

```properties
management.endpoints.web.exposure.include=*
management.endpoints.web.exposure.exclude=beans,mapping
```

* We can specify the base path for actuator:

```properties
management.endpoints.web.base-path=/actuator
```

## 🟦 Actuator Properties

* We cans secure endpoints by specifying user and password:

```properties
spring.security.user.name=admin
spring.security.password=topsecret
```

## 🟦 Data Properties

* We can specify the JDBC URL, username and password:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ecommerce

# username/password
spring.datasource.username=shiv
spring.datasource.password=root
```

## 🖥️ Code Demo 🖥️

* I update the `application.properties` file:

```properties
# changing spring boot embedded server port
server.port=7071

# setting context path of application
server.servlet.context-path=/mycoolapp
```
