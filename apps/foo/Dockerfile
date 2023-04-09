FROM openjdk:17-jdk-alpine
RUN addgroup -S bezmen && adduser -S bezmen -G bezmen
USER bezmen:bezmen
WORKDIR /home/bezmen
COPY libs app/libs
COPY app-foo*.jar app/foo.jar
ENTRYPOINT ["java", "-cp", "app/foo.jar:app/libs/*", "-Dconfig.file=app/application.conf", "org.smecalculus.bezmen.foo.App"]
