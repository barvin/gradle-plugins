# Gradle Plugins for Test Automation

To run the Reminders application do the following commands (you need to have JDK 8 installed):
```
cd reminders-app
gradlew bootRun
```
  
To run the API code generation and tests use the following commands:
```
cd automated-tests
gradlew generateApi test
```
  
Here are the libraries that were used in the project:
1. https://github.com/javaparser - for parsing the Java code. It also can generate it, but this functionality wasn't needed here
2. https://github.com/swagger-api/swagger-codegen - the tool for generating API code (endpoints and entities)
