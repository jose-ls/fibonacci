#!/bin/bash
set -e

REVISION=$(git rev-parse HEAD)

BODY="{
      \"tag_name\": \"$REVISION\",
      \"target_commitish\": \"master\",
      \"name\": \"$REVISION\",
      \"body\": \" \"
  }"

# Create the release in GitHub and extract its id from the response
RESPONSE_BODY=$(curl -s \
  -v \
  -u jose-ls:"${TOKEN_RELEASES}" \
  --header "Accept: application/vnd.github.v3+json" \
  --header "Content-Type: application/json; charset=utf-8" \
  --request POST \
  --data "${BODY}" \
  https://api.github.com/repos/jose-ls/fibonaccis/releases)

# Extract the upload_url value
UPLOAD_URL=$(echo "${RESPONSE_BODY}" | jq -r .upload_url)

cp build/libs/fibonaccis-1.0-SNAPSHOT.jar fibonaccis.jar

# Attach library
UPLOAD_URL="${UPLOAD_URL}//?name,label/?name=fibonaccis-${REVISION}.jar"
curl -s \
  -v \
  -u "${CIRCLE_USERNAME}":"${GITHUB_TOKEN}" \
  --header "Accept: application/vnd.github.v3+json" \
  --header "Content-Type: application/zip" \
  --data-binary "@fibonaccis.jar" \
  --request POST \
  "${UPLOAD_URL}"
