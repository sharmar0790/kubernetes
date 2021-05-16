#!/bin/bash

#echo "BUCKET_NAME >>>  " $BUCKET_NAME
#echo "CUSTOMER_FOLDER >>>  " $CUSTOMER_FOLDER

rm -rf /fluent-bit/etc/
aws s3 cp --recursive  s3://$BUCKET_NAME/$CUSTOMER_FOLDER /fluent-bit/etc/

echo "Listing file in /fluent-bit/etc/ >>> "
ls -l /fluent-bit/etc/
echo -n "AWS for Fluent Bit Container Image Version >>> "
cat /AWS_FOR_FLUENT_BIT_VERSION

echo -n "AWS Version >>> "
aws --version

exec /fluent-bit/bin/fluent-bit -c /fluent-bit/etc/fluent-bit.conf