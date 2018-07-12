#!/bin/bash
# file name: “hello.sh”

if [ $# -eq 1 ]
then
	( man $1 ) > $1.txt
elif [ $# -eq 0 ]
then
	echo "parameter required" 1>&2
else
	echo "too many parameters" 1>&2
fi


#commands test in terminal : bash ./problem1.sh ls