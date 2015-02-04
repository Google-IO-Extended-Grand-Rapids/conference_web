FROM maven:3.2-jdk-7
MAINTAINER danmikita@gmail.com
EXPOSE 8080
COPY . /opt/conference_web
WORKDIR /opt/conference_web
CMD mvn clean package && java -jar target/gs-rest-service-0.1.0.jar
