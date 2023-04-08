FROM maven:3.8.5-openjdk-17-slim as build

ARG REVISION
ARG PROFILE
ARG PROJECT

COPY . .

RUN --mount=type=cache,target=/root/.m2 mvn -B -Drevision=${REVISION} -P ${PROFILE} package

FROM openjdk:17-slim-buster

ARG REVISION
ARG PROJECT

COPY --from=build ${PROJECT}/target/${PROJECT}-${REVISION}.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
