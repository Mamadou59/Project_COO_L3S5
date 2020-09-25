#!/bin/bash

# Exemple de script shell qui affiche les n dernieres lignes d'un fichier
#avec un n par defaut qui vaut 10

echo "----- mtail classique ------"
echo "-                          -"
echo "----------------------------"
# version du mtail classique sans tampon
echo "Affichage des 5 dernière lignes du fichier README.md"
touch res1.txt && touch res2.txt
./mtail_classique -n 5 README.md > res1.txt > /dev/null
tail -n 5 README.md > res2.txt
diff res1.txt res2.txt > /dev/null
echo 
echo $?
echo "Le resultat de 'echo \$?' après la commande 'diff...' est 0 pour dire que tout est correcte" 

rm *.txt
echo
echo "----- mtail efficace -------"
echo "-                          -"
echo "----------------------------"
# Dans le cas ou la variable d'environnement
# BUFSIZ vaut 1000
export BUFSIZ
BUFSIZ=1000
touch res1.txt && touch res2.txt
echo
echo "Affichage des 10 dernière lignes du fichier README.md"
./mtail_efficace README.md > res1.txt
tail README.md > res2.txt
diff res1.txt res2.txt > /dev/null
echo $?
echo "Le resultat de 'echo \$?' après la commande 'diff...' est 0 pour dire que tout est correcte."
echo
echo "En ajoutant 'abc' dans le fichier 'res2.txt' avec la commande 'echo abc >> res2.txt' on obtient:"
echo 'abc' >> res2.txt
diff res1.txt res2.txt > /dev/null
echo $?
echo "Le resultat de 'echo \$?' après la commande 'diff...' est 1 pour dire qu'il y'a une difference"
rm *.txt
./mtail_efficace README.md -n 20 > res1.txt
tail README.md -n 20 > res2.txt
echo