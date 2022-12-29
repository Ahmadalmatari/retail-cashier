#FROM openjdk:11
#EXPOSE 9090
#ADD target/retail-cashier.jar retail-cashier.jar
#ENTRYPOINT ["java","-jar","/retail-cashier.jar"]

FROM adoptopenjdk/openjdk11:alpine-jre

# Refer to Maven build -> finalName
ARG JAR_FILE=target/retail-cashier.jar

# cd /opt/app
WORKDIR /opt/app

# cp target/spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} retail-cashier.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","retail-cashier.jar"]
