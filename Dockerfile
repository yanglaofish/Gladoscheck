FROM swr.cn-north-4.myhuaweicloud.com/ddn-k8s/docker.io/openjdk:8-jdk-alpine3.9
LABEL maintainer=yanglao
ENV JAVA_ARGS="-Dfile.encoding=UTF8 -Duser.timezone=GMT+08"
ENV JAR_FILE="GladosCheckin-1.0-jar-with-dependencies.jar"
COPY ./${JAR_FILE} ./
CMD java -jar ${JAVA_ARGS} ${JAVA_OPTS} /${JAR_FILE}
