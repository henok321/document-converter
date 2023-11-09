FROM azul/zulu-openjdk:21-latest

# Update package list and install LibreOffice
RUN apt-get update && \
    apt-get install -y libreoffice && \
    # Cleaning up the cache to reduce the layer size
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

VOLUME /tmp
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]
