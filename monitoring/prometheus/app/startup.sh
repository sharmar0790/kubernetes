#!/bin/bash

JAR_NAME=$(cat src/main/resources/application.properties | grep spring.application.name | cut -d = -f 2)
VERSION=$(cat src/main/resources/application.properties | grep spring.application.version | cut -d = -f 2)

./mvnw clean install
java -jar target/${JAR_NAME}-${VERSION}.jar