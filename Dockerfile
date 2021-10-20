FROM adoptopenjdk/openjdk11-openj9:alpine-jre
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS
ENV JAVA_OPTS=""

ARG JAR_FILE
ARG PARENT_FOLDER
ARG WAIT_TIME

RUN adduser -D -s /bin/sh app

WORKDIR /home/app

USER app

#EXPOSE 8080

ADD ${PARENT_FOLDER}/target/${JAR_FILE}.jar app.jar

RUN sleep ${WAIT_TIME}
 
ENTRYPOINT [ "sh", "-c", "java ${JAVA_OPTS} -Djava.security.egd=file:/dev/./urandom -jar app.jar {0} {@}" ]