Introduction: [![Build Status](https://travis-ci.org/shirishk/synerzip-selenium-framework.svg?branch=master)](https://travis-ci.org/shirishk/synerzip-selenium-framework)
---------------
This Test Automation Framework is created using Java + Selenium Web Driver + TestNG. Which can be used across different web based applications.
In this approach, the endeavor is to build a lot of applications independent reusable keyword components so that they can directly used for another web application without spending any extra effort. 
With this framework in place, whenever we need to automate a web based application, we would not need to start from scratch, but use the application independent keyword components to the extent possible and create application specific components for the specific needs.

Prerequisites:
---------------
*	Java jdk-1.5 or higher
*	Apache Maven 3 or higher
*	Please refer for any help in Maven. 
* 	http://maven.apache.org/guides/getting-started/maven-in-five-minutes.html
* 	http://www.tutorialspoint.com/maven/maven_environment_setup.htm

Environment:
---------------
* 	There are 5 different environment configuration set up [dev, local, stage, test and prod]
*	Use -P[environment_id] to copy the respective properties file to //config/env.properties 

Execution:
---------------
*	Clone the repository.
*	Open command prompt and go to web-test directory.
*	To run on local environment use command ....\.\web-test> mvn clean test -Plocal 

Logging:
---------------
*	log4j configured to capture the test execution logs
*	Configuration file is located at //config/log4j.xml
*	Execution log is captured in the //log/Automation_Execution.log