FROM openjdk

VOLUME /tmp
ADD maven/generic-pub-service-0.0.1-SNAPSHOT.jar generic-pub-service.jar
RUN sh -c 'touch /generic-pub-service.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","generic-pub-service.jar"]
