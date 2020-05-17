FROM openjdk:8-jre

RUN mkdir /app

COPY myshop-service-provider-item-1.0.0-SNAPSHOT.jar /app/

CMD java -jar /app/myshop-service-provider-item-1.0.0-SNAPSHOT.jar --spring.profiles.active=prod

EXPOSE 9502