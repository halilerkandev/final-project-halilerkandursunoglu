#!/bin/bash

echo "Stopping and removing containers.."
docker rm -f \
  finalproject-backend-postgres-test

docker rm -f \
  finalproject-creditscore-postgres-test

docker rm -f \
  finalproject-backend-redis-test
