#!/bin/bash

curl --request PATCH -sL \
     --header 'Content-Type: application/json' \
     --header 'Accept: application/json' \
     --url 'http://localhost:8080/api/profile/ec55973a-2f9b-4200-b2f3-afa3014518f1' \
     --data @data/update.json
