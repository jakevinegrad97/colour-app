# Colour App
Application which consumes and persists colours and provides an API to view the count of these colours.

## Consumer
The application has a Kafka consumer which listens on localhost port 9092 and reads from a topic called *colours*.
Input data is of type String.

## Validation
The service case-insensitively validates the colour against a list of colours.
If the colour is not in the list, an error log is written to stdout, and the colour is not persisted.
If the colour is accepted, and info log is written to stdout, and the colour is persisted to the database.

## Database
The database where the colours are persisted is an in-memory MongoDB, exposed on a random free port on locahost.

## API
The application exposes a REST API GET operation at path /colours on localhost port 8080.
The GET operation will return a JSON response containing the colours with each of their counts.
A 200 response code denotes successful request.
A 500 response code denotes something went wrong with the request.

## Cache
The application contains a cache which is refreshed 15 seconds after each initial read operation.

## More Information
The application also exposes an actuator endpoint with a health check at path /actuator, as well as a
swagger endpoint at path /swagger-ui.html.