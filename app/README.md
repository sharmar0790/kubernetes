# APP

### Build image

Execute `docker build -t app .`

### Run the image

```
docker run -p 8090:8090 -d -e  LOG_FILE_PATH=/usr/local/tomcat/logs \
    -v ${PWD}/logs:/usr/local/tomcat/logs \
    --name app app
```

### EP
  - http://localhost:8090/api/random/15
