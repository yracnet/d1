FROM openjdk:17-jdk-slim
ENV JDBC_URL jdbc:postgresql://localhost:5432/bd_green
ENV JDBC_USER postgres
ENV JDBC_PASS admin
VOLUME /tmp
EXPOSE 8080
ADD ./module10-tarea2/target/module10-tarea2-1.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]