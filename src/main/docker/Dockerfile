FROM hub.creditdev.com/tomcat

ADD src/main/docker/entry.sh entry.sh
ADD target/red-packet-1.0-SNAPSHOT.jar app.jar
RUN touch app.jar

ENTRYPOINT ["sh", "entry.sh"]