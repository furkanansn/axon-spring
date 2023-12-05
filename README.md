# Spring Axon example

This is a Spring Boot application for processing metering data related to energy consumption. The application provides RESTful APIs for CRUD operations on fractions and meter readings, as well as retrieving consumption for a given month.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Getting Started](#getting-started)
    - [Building the Project](#building-the-project)
    - [Running with Docker](#running-with-docker)
- [REST API Documentation](#rest-api-documentation)
    - [Swagger Documentation](#swagger-documentation)
- [Contributing](#contributing)
- [License](#license)

## Prerequisites

- Java Development Kit (JDK) 11
- Maven
- Docker

## Getting Started

### Building the Project
```bash
docker-compose -f docker-compose-axonserver-se.yml up

And please go to http://localhost:8024 and initiliaze axon server as default.
```
```bash
docker-compose -f docker-compose-postgres.yml up
```
```bash
docker build -t energy-consumption .
```



The application will be accessible at http://localhost:8080. \
The swagger will be accessible at http://localhost:8080/swagger-ui/index.html
