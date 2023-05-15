FROM openjdk:17-slim
EXPOSE 8081
ADD /target/ticket-train-stations-0.0.1-SNAPSHOT.jar ticket-train-stations-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","ticket-train-stations-0.0.1-SNAPSHOT.jar"]