#!/bin/bash

# Exemple de script shell qui mesure le temps d'execution de mcat-scd
# Dans le cas ou la variable d'environnement
# MCAT_BUFSIZ vaut 1 octet a 8Mo

export MCAT_BUFSIZ
dd if=/dev/zero of=/tmp/1Mo bs=1k count=1000 
touch resultat.dat
echo '#taille		duree' > resultat.dat
i=1
x=10
while [ $i -lt  $((1000*1024*8)) ]
	do	
	MCAT_BUFSIZ=$i
	(/usr/bin/time -f  ''$MCAT_BUFSIZ'		'%e'' ./mcat-scd /tmp/1Mo) 2>> resultat.dat
	i=$((2*i))
done


