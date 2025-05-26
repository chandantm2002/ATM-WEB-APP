# ATM-WEB-APP

# 🧪 SonarQube Setup with Docker (Windows) for Spring Boot ATM WebApp

This guide walks you through installing **SonarQube using Docker on Windows**, generating a token, and connecting your Spring Boot project (`atm-webapp`) for static analysis in Eclipse IDE.

---

## ✅ Prerequisites

- Docker Desktop installed and running
- Git & Java (17+) installed
- Maven installed
- Eclipse IDE (or your preferred Java IDE)

---

##  Step 1: Start SonarQube in Docker

Run the following command in PowerShell or Command Prompt:

bash
docker run -d --name sonarqube \
  -p 9000:9000 \
  -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true \
  sonarqube:latest


## Step 2: Log in & Generate a Token
Visit http://localhost:9000

Login with:
Username: admin
Password: admin
After login, change the default password
Go to:
My Account → Security → Generate Token
Give it a name like atm-token, click Generate, and copy the token

## Step 3: Configure settings.xml or Environment Variable

Option 1: Maven Command (Recommended)
Use this command inside your project directory:

bash
mvn clean verify sonar:sonar \
  -Dsonar.projectKey=atm-web-app \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.token=YOUR_TOKEN_HERE

Replace YOUR_TOKEN_HERE with the generated token.


## Expected Output 
[INFO] ANALYSIS SUCCESSFUL
[INFO] More about the report at: http://localhost:9000/dashboard?id=atm-web-app
