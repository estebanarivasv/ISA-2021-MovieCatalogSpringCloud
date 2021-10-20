# Movie Catalog with Spring Cloud

This basic application returns the reviews a user has made for some movies.

This project has three microservices:
- movie-catalog-service: that provides the payload, interacting with the other microservices.
- movie-service: returns the data from the movie.   
- rating-service: returns the data from the ratings a user has made.

## Features
- Rest Template: we communicate microservices with each other with syncronous calls.
- Eureka: service discovery capabilites. 
    - Offers the advantage of using dynamic urls
    - Load balancing
    - Client-side service discovery

## Requirements
- Java version: 11.0.12
- Docker version 20.10.9
- docker-compose version 1.29.2

## Steps to get the application running

1. `./mvnw install` in all the spring boot projects
2. Execute `docker-compose up`

## Useful endpoints
- movie-catalog-service: `http://localhost:8081/catalog/{userId}`
- movie-service: `http://localhost:8082/movies/{movieId}`
- rating-service: `http://localhost:8083/ratings/users/{userId}`
- discovery-server: `http://localhost:8761/`
