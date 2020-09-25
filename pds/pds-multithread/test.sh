#!/bin/bash

#
> plot.dat
for((i=2;i<=9;i++)); do
    n=$((10**i))
    ./aleazard $n > /tmp/tmp.txt
    for((j=0;j<=5;j++)); do
        t=$((2**j))
        echo -n $n $t " "  >> plot.dat
        ./compteur-gc /tmp/tmp.txt $t >> plot.dat
    done
done
