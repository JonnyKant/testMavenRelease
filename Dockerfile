FROM openjdk:11

RUN mkdir /usr/src/app/
WORKDIR /usr/src/app/

COPY . /usr/src/app/

CMD ["java", "-jar", "target/testMavenRelease-1.13-SNAPSHOT.jar"]
