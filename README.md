# Spring Boot Webhook Automation

## Overview
This application automates the hiring challenge process:
1. Generates a webhook.
2. Solves the SQL challenge (Requires User Input).
3. Submits the solution via JWT-authenticated API.

## ⚠️ Action Required
Before running the application, you must open:
`src/main/java/com/healthrx/automation/service/AutomationService.java`

And update the `SQL_SOLUTION` constant with the answer to Question 1:
```java
private static final String SQL_SOLUTION = "SELECT * FROM ..."; // <--- PUT YOUR QUERY HERE
```

## How to Build
Navigate to the `test1` directory and run:

### Windows
```cmd
mvnw.cmd clean package
```
*Note: If `mvnw.cmd` fails, ensure you have Java installed and try passing the arguments directly or use a global `mvn` if available.*

### Linux/Mac
```bash
./mvnw clean package
```

## How to Run
After building, the JAR will be in the `target` directory:
```bash
java -jar target/automation-0.0.1-SNAPSHOT.jar
```
