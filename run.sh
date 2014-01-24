#!/bin/sh

mvn clean package -Pheroku; foreman start
