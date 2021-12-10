FROM openjdk:11-jre-slim
COPY target/irpf-rest-0.0.1-SNAPSHOT.jar /usr/src/irpf-rest.jar
WORKDIR /usr/src
RUN ls -l
ENTRYPOINT ["java","-jar","irpf-rest.jar"]