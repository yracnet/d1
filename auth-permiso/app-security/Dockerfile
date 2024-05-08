FROM fantito/jdk11-maven-git

MAINTAINER greensoft.com

VOLUME [ "/app" ]

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} app-security-0.0.1-SNAPSHOT.jar

EXPOSE 8081

ENTRYPOINT [ "java","-jar","/app-security-0.0.1-SNAPSHOT.jar" ]