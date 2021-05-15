#!/bin/bash

yum -y update && \ 
    yum -y install aws-cli && \
    #yum -y install unzip && \
    #curl "https://awscli.amazonaws.com/awscli-exe-linux-x86_64.zip" -o "awscliv2.zip" && \
    #unzip awscliv2.zip && \
    #./aws/install -i /usr/bin/aws-cli -b /usr/bin && \
    #rm awscliv2.zip && \
    chmod +x /entrypoint.sh && \ 
    mkdir -p /usr/local/tomcat/logs && \
    rm -rf /var/cache/yum