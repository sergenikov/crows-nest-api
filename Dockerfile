FROM gradle:jdk11

ARG src="/usr/src"

WORKDIR $src

RUN apt-get update && apt-get -y install nmap git
RUN git clone https://github.com/sergenikov/crows-nest-api.git $src

RUN ./gradlew build --no-daemon

EXPOSE 8080

CMD ./gradlew bootRun
