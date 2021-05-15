# FLUEBT_BIT AWS

### Build Image

`docker build -t fb .`

### Run Image

```
docker run -p 24224:24224 \
        -e BUCKET_NAME=fluent-bit-ecs-test \
        -e CUSTOMER_FOLDER=customer-1 \
        -v <HOST-PATH>:<CONTAINER-PATH> \
        --name <CONTAINER-NAME> <IMAGE-NAME or IMAGE-ID>
```

Example

```
docker run -p 24224:24224 \
        -e BUCKET_NAME=fluent-bit-ecs-test \
        -e CUSTOMER_FOLDER=customer-1 \
        -v /app/logs:/usr/local/tomcat/logs/ \
        --name fb fb
```

- `BUCKET_NAME` - AWS S3 buket where the fluent-bit configurations files are stored.
- `CUSTOMER_FOLDER` - Folder which must be there inside the bucket. This is the actual folder containing conf files w.r.t to the customer. At the time of running the image this container will fetch the conf files from S3.

The structure will be like this -
`s3://fluent-bit-ecs-test/customer-1` where **fluent-bit-ecs-test** is the bucket name and **customer-1** is the folder name.

### Tag an Image

```
docker tag <IMAGE_ID> <HUB-USER>/<IMAGE-REPO>:[:tag]
```

### Pushing the image to image hub

```
docker push <HUB-USER>/<IMAGE-REPO>:[:tag]
```
