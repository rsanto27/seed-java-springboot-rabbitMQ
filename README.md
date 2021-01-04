# seed-java-springboot-rabbitMQ_producer

## Objective

implement and describe how a queue based on rabbitMQ works.

## Tecnologies
1. Java 11 LTS.
2. RabbitMQ.
3. Springboot.
4. Docker with docker-compose.

## IDE
Eclipse.

## Environment
1. Clone the project, make sure that technologies described above is installed in your computer.
2. The pom.xml has all dependencies that you need.
3. Put the docker-compose up. `docker-compose up`.

## Docker Compose
Produces a rabbitMQ service base on image `rabbitmq:3-management`.

## RabbitMQ
Url local initiated by docker-compose service `http://localhost:15672/`.
TODO put an image and describe how the data flow works between publisher -> exchange -> queue -> consumer.

## Java Flow
1. `application.yml`. Has the properties that is needed to run the project.
2. Data Producer.


