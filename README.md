# dep-persistence

Digital Event Planner Persistence. A RESTful API driven persistence module for an event-centric application.
Ideally deployed as a 'microservice' to separate concerns, responsibilities and reduce coupling to other modules that would assume different roles within an application's architecture.

# Starting dep-persistence locally

Make sure there is a MySQL server running on the system and either match up details from the `application.properties` file or use an entirely unique properties file at build time with maven argument: `-Dproperties=/path/you/your/application.properties`.

Start the application locally in development mode with `mvn compile quarkus:dev` if you have maven 3.5.4+ installed or use the maven wrapper with `./mvnw compile quarkus:dev`.

On successful start, the application should have used flyway to initialise a database with your MySQL credentials, and you may communicate with the API using http protocols such as curl or any other language that supports HTTP.

To view the API documentation navigate in your browser to `localhost:8000/swagger-ui`.
