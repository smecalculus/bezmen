FROM openjdk:17-jdk-alpine
RUN addgroup -S bezmen && adduser -S bezmen -G bezmen
USER bezmen:bezmen
WORKDIR /home/bezmen
COPY app-foo*.jar app/foo.jar
ENTRYPOINT ["java", "-cp", "app/foo.jar", "org.smecalculus.bezmen.foo.App"]
