FROM eclipse-temurin:17-jdk-alpine
RUN addgroup -S bezmen && adduser -S bezmen -G bezmen
USER bezmen:bezmen
WORKDIR /home/bezmen
COPY libs libs
COPY app*.jar app.jar
ENTRYPOINT [ \
    "java", "-cp", "app.jar:libs/*", \
    "-Dconfig.file=${CONFIG_FILE_NAME}", \
    "smecalculus.bezmen.construction.App" \
]
