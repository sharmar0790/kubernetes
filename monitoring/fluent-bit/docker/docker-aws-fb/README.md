# FLUEBT_BIT AWS

### Build the image

Execute
`docker build -t fb -f Dockerfile.awsfluentbit .`

### Run the image

```
docker run -p 24224:24224 \
        -v /Users/RV0718/projects/kubernetes/app/logs:/usr/local/tomcat/logs/ \
        --name fb fb
```

### Tagging an image
```
docker tag <IMAGE_ID> <HUB-USER>/<IMAGE-REPO>:latest
```

