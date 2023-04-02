FROM openjdk
RUN mkdir -p ../../target/lesson
ENV APP_NAME=gubee-interview.jar
COPY ${APP_NAME} /app/lesson/
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "../../target/lesson${APP_NAME}"]