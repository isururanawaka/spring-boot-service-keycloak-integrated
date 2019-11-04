FROM openjdk:11-jre-slim
VOLUME /tmp
EXPOSE 8080 8180
COPY target/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]