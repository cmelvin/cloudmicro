FROM openjdk

VOLUME /tmp
ADD maven/netflix-eureka-naming-server-0.0.1-SNAPSHOT.jar netflix-eureka-naming-server.jar
RUN sh -c 'touch /netflix-eureka-naming-server.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/netflix-eureka-naming-server.jar"]
EXPOSE 8671