#!/usr/bin/env bash

VM_ARGS=-Xmx128m

if [[ "${BOOT_ENV}" == "" ]]
then
    BOOT_ENV=dev
    VM_ARGS=-Xmx128m
fi


java $VM_ARGS -jar -Dspring.profiles.active=${BOOT_ENV} -Dcurrent.app=red-packet app.jar

