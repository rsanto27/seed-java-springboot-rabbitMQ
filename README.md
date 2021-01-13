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

## Java Flow Producer
1. `application.yml`. Has the properties that is needed to run the project.
2. Create the class `com.seed.rabbit.producer.configuration.RabbitJacksonConverterConfiguration`. This class is injected like a @configuration.
Inside the class, we have a connection factory and a @Bean with the jackson converter. Note, this class is a base to init the configuration of other
queues.
3. Now, create the class `com.seed.rabbit.producer.configuration.ProducerRabbitCfg`. This class represents the cfg of one queue, if you need more queue, you may implement another class looks like this one.
4. Create a simple DTO to be used inside the life cycle of a queue. Example `com.seed.rabbit.DTO.Message`.
5. Create an Interface to implement a way of make a producer request. Note this is an approach, it's not required to make an interface.
Example: `com.seed.rabbit.producer.AMQP.ProducerRabbitMQ`.
6. Create an implementation to make requests for the queue. Example: `com.seed.rabbit.producer.AMQP.ProducerRabbitMQ`. Note, if we have any problem, we have to handle the problem with the exception `org.springframework.amqp.AmqpRejectAndDontRequeueException` because this will put the message inside deadLetter queue.
7. Create a service to use de `com.seed.rabbit.producer.AMQP.ProducerRabbitMQ`. Example: `com.seed.rabbit.producer.service.RabbitMQService`.
8. Create an endpoint to send a message by the service. Example: `com.seed.rabbit.api.AmqpApi`
