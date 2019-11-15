FROM openjdk:alpine
ENV SPRING_OUTPUT_ANSI_ENABLED=ALWAYS \
    APP_SLEEP=0 \
    JAVA_OPTS="" \
    RUN_ARGS="" \
    APP_NAME_ID=""

# Add a user admin to run our application so that it doesn't need to run as root
RUN adduser -D -s /bin/sh admin
WORKDIR /home/admin
COPY entrypoint.sh \
     target/app.jar \
     /home/admin/

# Authorization
USER root
RUN chmod 755 entrypoint.sh && \
    chown -R admin:admin /home/admin

USER admin
ENTRYPOINT ["./entrypoint.sh"]
EXPOSE 8084
