FROM eclipse-temurin:17-jdk-alpine
RUN addgroup -S bezmen && adduser -S bezmen -G bezmen
USER bezmen:bezmen
WORKDIR /home/bezmen
COPY libs foo/libs
COPY app-foo*.jar foo/app.jar
ENTRYPOINT [ \
    "java", "-cp", "foo/app.jar:foo/libs/*", \
    "-Dconfig.file=foo/application.conf", \
    "org.smecalculus.bezmen.construction.spec.App" \
]
