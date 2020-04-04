****# cloudmicro

mvn clean package docker:build for building containers
mvn docker:start for starting containers
mvn docker:start docker:push for pushing image to DockerHub

docker network inspect bridge - Give IP of all containers
docker inspect #container id - Gives IP of a single container and more details

Orchestraction order

Start spring cloud config server, then get its IP feed 
Start netflix eureka naming server then get its IP
Start generic pub service feed netflix eureka naming server to pom  then get its IP 
Start pub service feed spring cloud config server to .properties, feed netflix eureka naming server to pom, feed generic pub service to Feign Proxy and Controller 


RabbitMQ default port http://localhost:8080 which is mapped to rabbitmq internal 15672
User name and password guest'

Microservices hosted on AWS
