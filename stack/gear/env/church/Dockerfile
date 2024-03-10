FROM ubuntu:mantic

RUN apt-get update \
  && apt-get install -y --no-install-recommends \
    ca-certificates \
    gnupg \
    curl \
    git \
    sudo \
    python3=3.11.* \
    python3-pip \
  && rm -rf /var/lib/apt/lists/*

ARG DOCKER_VERSION
ARG DOCKER_REPO=https://download.docker.com/linux/ubuntu
ARG DOCKER_KEY=/etc/apt/keyrings/docker.gpg
RUN install -m 0755 -d /etc/apt/keyrings \
  && curl -fsSL $DOCKER_REPO/gpg | gpg --dearmor -o $DOCKER_KEY \
  && chmod a+r $DOCKER_KEY \
  && echo "deb [arch=amd64 signed-by=$DOCKER_KEY] $DOCKER_REPO mantic stable" \
    | tee /etc/apt/sources.list.d/docker.list > /dev/null \
  && apt-get update \
  && apt-get install -y --no-install-recommends \
    docker-ce-cli=5:$DOCKER_VERSION* \
    docker-buildx-plugin \
    docker-compose-plugin \
  && rm -rf /var/lib/apt/lists/*

ENV JAVA_HOME=/usr/local/openjdk-22
ENV MAVEN_HOME=/usr/share/maven
ENV PATH=${MAVEN_HOME}/bin:${JAVA_HOME}/bin:${PATH}

COPY --from=openjdk:22-jdk-bullseye ${JAVA_HOME} ${JAVA_HOME}
COPY --from=maven:3.9.6-eclipse-temurin-21 ${MAVEN_HOME} ${MAVEN_HOME}

COPY requirements.txt .
RUN pip install -r requirements.txt --break-system-packages
