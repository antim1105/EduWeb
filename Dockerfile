FROM maven:3.8.5-openjdk AS build
# COPY src/main/java .
# RUN mvn clean package 

# COPY --from=build/target/emailWebAPI-0.0.1-SNAPSHOT.jar emailWebAPI.jar
COPY . .
EXPOSE  8080
CMD ["java","-jar","Eduweb-0.0.1-SNAPSHOT.jar"]

