!/usr/bin/env bash
FILE= script_output.txt

if test -f "$FILE"; then
    rm $FILE
fi

touch script_output.txt

while read p; do
    java DamArrayApp $p # >> script_output.txt
done < name.txt