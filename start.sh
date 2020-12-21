#!/bin/bash -ilex

PROJECT_NAME=base

docker rm -f $PROJECT_NAME
docker rmi -f $PROJECT_NAME

docker build -f Dockerfile -t=""$PROJECT_NAME .
docker run --name=$PROJECT_NAME -dit --restart unless-stopped -p 80:80 -d -v /usr/local/project/crm/log/:/usr/local/project/crm/log/ $PROJECT_NAME