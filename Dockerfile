FROM openjdk:8
EXPOSE 8080
CMD java -jar /data-redis-example.jar
ADD target/Data-Redis-example-2-0.0.1-SNAPSHOT.jar /data-redis-example.jar