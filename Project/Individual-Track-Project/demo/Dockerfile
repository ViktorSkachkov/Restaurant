FROM azul/zulu-openjdk-alpine:17
VOLUME /tmp
EXPOSE 8080

ARG JAR_FILE=./build/libs/demo-0.0.1-SNAPSHOT-plain.jar
COPY ${JAR_FILE} /app.jar

#COPY ./src/main/resources/META-INF/MANIFEST.MF app.jar
ENTRYPOINT ["java","-jar","/app.jar"]