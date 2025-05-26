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

## 🚀 Step 1: Start SonarQube in Docker

Run the following command in PowerShell or Command Prompt:

```bash
docker run -d --name sonarqube \
  -p 9000:9000 \
  -e SONAR_ES_BOOTSTRAP_CHECKS_DISABLE=true \
  sonarqube:latest
