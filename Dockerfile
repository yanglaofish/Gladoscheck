FROM openjdk:8-jdk-alpine
LABEL maintainer=yanglao
ENV JAVA_ARGS="-Dfile.encoding=UTF8 -Duser.timezone=GMT+08"
ENV JAR_FILE="GladosCheckin-1.0-SNAPSHOT.jar"
CMD java -jar ${JAVA_ARGS} ${JAVA_OPTS} /${JAR_FILE}