FROM openjdk

VOLUME /tmp
ADD maven/spring-cloud-config-server-0.0.1-SNAPSHOT.jar spring-cloud-config-server.jar
RUN sh -c 'touch /spring-cloud-config-server.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/spring-cloud-config-server.jar"]
EXPOSE 8888