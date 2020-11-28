FROM openjdk:11

WORKDIR /app
ADD . /app

ARG GRADLE_VERSION=6.7.1
RUN wget https://services.gradle.org/distributions/gradle-$GRADLE_VERSION-bin.zip
RUN unzip gradle-$GRADLE_VERSION-bin.zip
RUN gradle-$GRADLE_VERSION/bin/gradle bootJar

EXPOSE 8080

CMD ["java", "-jar", "build/libs/nachrichtenleicht-0.0.1-SNAPSHOT.jar"]
