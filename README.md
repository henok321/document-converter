# document-converter

Simple RESTful service to convert documents with LibreOffice.

## Maven

### Build

```
mvn clean install
```
### Run 

```
mvn spring-boot:run
```

### Convert file
```
curl -F inputFormat=docx -F outputFormat=pdf -F file=@hello.docx http://localhost:8080/convert > hello.pdf
```

## Docker

### Build image

```
docker build -t document-converter --build-arg JAR_FILE=target/document-converter-{VERSION}.jar .
```

### Run service

```
docker run -it -p 8080:8080 -t document-converter document-converter:latest
```