# Movie Catalog with Spring Cloud

This basic microservice-oriented application returns the reviews a user has made for some movies and helps the developer to access the logs with Elastic stack and to monitor how PC resources are being used.

## Components

This project has four main microservices:
- movie-catalog-service: that provides the payload, interacting with the other microservices.
- movie-service: returns the data from the movie.   
- rating-service: returns the data from the ratings a user has made.
- discovery-server: microservice that holds the Eureka server. It helps server discovering. Eureka:
    - Offers the advantage of using dynamic urls
    - Load balancing
    - Client-side service discovery

Other elements
- MySQL: application data is persisted in a MySQL db.
- Traefik: helps port-binding and load balancing. Eureka alternative.
- Prometheus: tracks the resources usage.
- Grafana: metrics visualization.
- Elasticsearch: data indexing.
- Filebeats: collection, parsing, and visualization of microservices logs.
- Kibana: logs visualization.
- Logstash: ingests data from the microservices via sleuth dependency


## Requirements
- Java version: 11.0.12
- Docker version 20.10.9
- docker-compose version 1.29.2

## Useful endpoints
- movie-catalog-service: `http://localhost:8081/catalog/{userId}`
- movie-service: `http://localhost:8082/movies/{movieId}`
- rating-service: `http://localhost:8083/ratings/users/{userId}`
- discovery-server: `http://localhost:8761/`
