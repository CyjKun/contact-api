# MS3 Contact API
### Pre-requisites
- Gradle
- Lombok
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

---

### Test APIs
- Go to Postman
- File > Import > Import `Contact API.postman_collection.json` from contact-api directory

You should have a collection named `Contact API` which contains API requests for this project
