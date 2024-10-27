#!/bin/bash

for file in ~/java-projects/elasticSearchProject/edtech/E-searcher/wsearcher-api/curl/data/*.json; do
  curl --request POST -sL \
       --header 'Content-Type: application/json' \
       --header 'Accept: application/json' \
       --url 'http://localhost:8080/api/profile' \
       --data @$file
done