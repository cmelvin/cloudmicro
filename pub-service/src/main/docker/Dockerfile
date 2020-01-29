FROM openjdk

VOLUME /tmp
ADD maven/pub-service-0.0.1-SNAPSHOT.jar pub-service.jar
RUN sh -c 'touch /pub-service.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/pub-service.jar"]
