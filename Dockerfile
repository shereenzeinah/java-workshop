# This a docker file with multi-stage builds.
# Stage number one building the code with maven.
FROM maven as build
WORKDIR /service
COPY . /service
RUN mvn install -DskipTests

# Stage number two running the jar file from stage one. 
FROM openjdk:11.0.6
WORKDIR /service
COPY --from=build /service/target/workshop-0.0.1-SNAPSHOT.jar /service
EXPOSE 8081
CMD ["java","-Dspring.profiles.active=prod","-jar","workshop-0.0.1-SNAPSHOT.jar"]
