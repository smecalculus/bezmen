FROM openjdk:17-jdk-alpine
RUN addgroup -S bezmen && adduser -S bezmen -G bezmen
USER bezmen:bezmen
WORKDIR /home/bezmen
COPY deps/ app/libs
COPY maven/ app/
ENTRYPOINT ["java", "-cp", "app/app.jar:app/libs/*", "org.smecalculus.bezmen.web.Application"]
