# MS3 Contact API
### Pre-requisites
- Gradle
- Java 8
- Docker `https://docs.docker.com/engine/installation/`
- Postman

## Getting Started
### Get the latest snapshot
- $ `git clone https://github.com/CyjKun/contact-api.git`
- $ cd contact-api

### Startup database
- $ `docker-compose up -d`

### Start application
- $ `./gradlew clean build bootRun`

Your app should be running now on localhost:8080

#### Notes
- You can import the database using these credentials after running `docker-compuse-up -d` and running the application by `./gradlew clean build BootRun` 
```
    url: jdbc:postgresql://localhost:5433/ms3db
    username: postgres
    password: postgres
```
- Since this application relies on flyway migration it auto-magically creates the table and columns for you
- You can find the database sql inside `src/main/resources/db/migration/v1_1_0__initialize_database.sql`
---
### Test APIs
- Go to Postman
- File > Import > Import `Contact API.postman_collection.json` from contact-api directory

You should have a collection named `Contact API` which contains API requests for this project
