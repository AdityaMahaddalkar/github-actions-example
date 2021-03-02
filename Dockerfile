FROM gradle:6.8.3-jdk15 AS build

COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src

RUN gradle build --no-daemon

FROM openjdk:15-oracle

EXPOSE 8080

RUN mkdir /app

COPY --from=build /home/gradle/src/build/libs/*.jar /app/github-actions-example.jar

ENTRYPOINT ["java", "-jar", "/app/github-actions-example.jar"]