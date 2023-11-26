ARG JAVA_RELEASE
FROM eclipse-temurin:${JAVA_RELEASE}-jre-alpine
RUN addgroup -S app && adduser -S app -G app
USER app:app
WORKDIR /home/app
COPY libs libs
COPY sepuling*.jar sepuling.jar
ENTRYPOINT [ \
    "java", "-cp", "sepuling.jar:libs/*", \
    "-Dconfig.file=application.conf", \
    "smecalculus.bezmen.construction.AppKt" \
]
