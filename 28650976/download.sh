#!/usr/bin/env bash

curl -Lk -o sample1.zip https://github.com/Opalo/stackoverflow/raw/master/28650976/sample.zip 
mkdir project1
unzip sample1.zip -d project1
cp -rfv project1/assets assets1
rm -rf project1 && rm -rf sample1.zip
