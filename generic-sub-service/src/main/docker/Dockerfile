FROM openjdk

VOLUME /tmp
ADD maven/generic-sub-service-0.0.1-SNAPSHOT.jar generic-sub-service.jar
RUN sh -c 'touch /generic-sub-service.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","generic-sub-service.jar"]
EXPOSE 9000