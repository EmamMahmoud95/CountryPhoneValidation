FROM adoptopenjdk/openjdk11-openj9

EXPOSE 8080
VOLUME /tmp
RUN mkdir /phone

copy target/phone-0.0.1-SNAPSHOT.jar /app.jar

ENTRYPOINT exec java -jar ./app.jar