#!/bin/sh

alias run=./run.sh
mvn clean package -Pheroku; foreman start
