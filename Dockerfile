FROM openjdk:11.0.8-jre-slim
EXPOSE 8080
COPY target/enterprise-service-*.jar enterprise-service.jar
ENTRYPOINT exec java $JAVA_OPTS -jar enterprise-service.jar