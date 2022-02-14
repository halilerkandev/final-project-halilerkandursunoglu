#!/bin/bash

cd ./backend

mvn clean -Dmaven.test.skip package

cd ..
cd ./creditscore

mvn clean -Dmaven.test.skip package

cd ..
cd ./sms

mvn clean -Dmaven.test.skip package

cd ..

docker compose --file docker-compose-dev.yml up --build