#!/bin/sh

re='^[1-5]$'

function usage() {
  echo ""
  echo "Deploy Liberatii Interview Question."
  echo ""
  echo "usage: ./game  --level  integer"
  echo ""
  echo "  --level number   It must be any of these numbers: 1-2-3-4-5"
  echo "                          (example: --level 3)"
  echo ""
}

function die() {
  printf "Script failed: %s\n\n" "$1"
  exit 1
}

while [ $# -gt 0 ]; do
  if [[ $1 == "--help" ]]; then
    usage
    exit 0
  elif [[ $1 == "--level" ]]; then
    if [ -z "$2" ] || ! [[ "$2" =~ $re ]]; then
      usage
      die "Missing parameter --level"
    else
      arg="$2"
    fi
    shift
  fi
  shift
done

./mvnw -q clean package -DskipTests

parent_path=$(
  cd "$(dirname "${BASH_SOURCE[0]}")"
  pwd -P
)

cd "$parent_path"/target

jar_name=liberatii-1.0-SNAPSHOT.jar
java -jar $jar_name "$arg"
