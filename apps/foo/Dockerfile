FROM openjdk:17-jdk-alpine
RUN addgroup -S bezmen && adduser -S bezmen -G bezmen
USER bezmen:bezmen
WORKDIR /home/bezmen
COPY app-foo*.jar app/foo.jar
COPY libs app/libs
ENTRYPOINT ["java", "-cp", "app/foo.jar:app/libs/*", "org.smecalculus.bezmen.foo.App"]
