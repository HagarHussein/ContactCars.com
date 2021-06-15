# ContactCars.com
A Selenium test framework using Java, TestNG and POM for automating test cases for the old release of ContactCars.com


## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

* Maven
* Eclipse
* Java
* TestNG

### Installing

1. Download and install Maven
2. Download Eclips with Java JDK
3. Install TestNG
4. Create a new maven project inside Eclipse
5. Replace the main and test folders with the equivalent ContactCars.com folders from this project as well as the pom.xml file
6. Download chromedriver.exe and place it inside a newly created "Resources" folder inside the main hierarchy of the project
7. Run the test cases class from "TestScenarios" package as a "TestNG Test"

## Features

* Object Oriendted Design - *Using Page Object Model design pattern.*
* Customized TestNG Report - *Include a screenshot for the failed steps.*
* Assertion errors recovery and exception handeling - *Using hard assertions, waits and try and catch*


## Componenets

### Pages
Inside the "main" folder, each web page is represented by a Java class. 
* Each class consists of 2 man things: **Fileds**, which represnets the elements' locators. and **Methods** : to interact with those elements.
* All the pages need a driver to interact with the browser
* If the action inside each page changes it to another page, the method returns a handle to that new page with the current driver to keep interacting with the same browser session.
* All the pages inherit from a single AbstractPage which holds the WebDriver and WebDriverWait objects encapsulated. 


### Test
There are 3 main packages in this folder.
* utilities
  - *Helper.java:* a helper class that contains a function to take a screenshot from the current browsing session to be used in the report generation
* base
  - *BaseTest.java:* a parent class for all the test classes. Contains all the @Before and @After configuration methods
* Other packages for the test scenarios

