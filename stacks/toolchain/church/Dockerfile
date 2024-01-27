FROM maven:3.9.6-eclipse-temurin-21-jammy

ENV REPO_URL=https://download.docker.com/linux/ubuntu \
    GPG_FILE=/etc/apt/keyrings/docker.gpg

RUN apt-get update \
  && apt-get install -y ca-certificates curl gnupg python3 python3-pip --no-install-recommends \
  && install -m 0755 -d /etc/apt/keyrings \
  && curl -fsSL ${REPO_URL}/gpg | gpg --dearmor -o ${GPG_FILE} \
  && chmod a+r ${GPG_FILE}

RUN echo "deb [arch=amd64 signed-by=${GPG_FILE}] ${REPO_URL} ${OS_CODENAME} stable" | tee /etc/apt/sources.list.d/docker.list > /dev/null

ARG DOCKER_VERSION
RUN apt-get update \
  && apt-get install -y docker-ce-cli=5:${DOCKER_VERSION}* docker-buildx-plugin docker-compose-plugin --no-install-recommends \
  && rm -rf /var/lib/apt/lists/*

ENTRYPOINT []

COPY requirements.txt .

RUN pip install -r requirements.txt

# RUN groupadd -g 997 docker \
#  && adduser --disabled-password --gecos "" --ingroup docker buser
# WORKDIR /home/buser
# USER buser:docker
