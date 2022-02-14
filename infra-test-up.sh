#!/bin/bash

echo "Starting backend postgres container.."
docker run --name finalproject-backend-postgres-test \
  -e POSTGRES_USER=user \
  -e POSTGRES_PASSWORD=password \
  -d \
  -p 5432:5432 \
  postgres

echo "Starting creditscore postgres container.."
docker run --name finalproject-creditscore-postgres-test \
  -e POSTGRES_USER=user \
  -e POSTGRES_PASSWORD=password \
  -d \
  -p 5433:5432 \
  postgres

echo "Starting redis container.."
docker run --name finalproject-backend-redis-test \
  -p 6379:6379 \
  -d \
  redis

cd ./backend

export SERVER_PORT=8082
export SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/postgres
export SPRING_DATASOURCE_USERNAME=user
export SPRING_DATASOURCE_PASSWORD=password
export REDIS_HOST=localhost
export REDIS_PORT=6379

mvn clean verify -P manual-integration-test

unset SERVER_PORT
unset SPRING_DATASOURCE_URL
unset SPRING_DATASOURCE_USERNAME
unset SPRING_DATASOURCE_PASSWORD
unset REDIS_HOST
unset REDIS_PORT

cd ..
cd ./creditscore

export SERVER_PORT=8083
export SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5433/postgres
export SPRING_DATASOURCE_USERNAME=user
export SPRING_DATASOURCE_PASSWORD=password

mvn clean verify -P manual-integration-test

unset SERVER_PORT
unset SPRING_DATASOURCE_URL
unset SPRING_DATASOURCE_USERNAME
unset SPRING_DATASOURCE_PASSWORD

cd ..
cd ./sms

export SERVER_PORT=8084
export TWILIO_ACCOUNT_SID=AC74887f9deca828e91a0f6aa0e3b46238
export TWILIO_AUTH_TOKEN=d659271adeda3a8e8afe917e9d7f5d8b
export TWILIO_TRIAL_NUMBER=+18455477926

mvn clean verify -P manual-integration-test

export SERVER_PORT
export TWILIO_ACCOUNT_SID
export TWILIO_AUTH_TOKEN
export TWILIO_TRIAL_NUMBER