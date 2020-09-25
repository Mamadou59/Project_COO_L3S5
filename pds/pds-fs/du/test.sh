echo "++++  Affichage de mdu  sur un dossier ++++"
echo "+                                     	 +"
echo "+++++++++++++++++++++++++++++++++++++++++++"
mkdir test1 && mkdir test1/soustest1
touch test1/soustest1/fichier1 && touch test1/soustest1/fichier2 
echo ceci est un premier exemple > test1/soustest1/fichier1 && echo ceci est un second exemple > test1/soustest1/fichier2
cd test1/soustest1
ln -s   fichier1 liensymb1    
ln -s   fichier2 liensymb2  
cd ../..
tree test1

echo '***********************************************\n'
echo "resultat attendu avec (du -B512)"
echo "----------------------------------------------------\n"
du -aB512 test1
echo "\nresultat que donne (./mdu)"
echo "----------------------------------------------------\n"
./mdu test1
echo "on a le même resultat" && echo "----------------------------------------------------\n" 

echo "resultat attendu avec (du -b)"
echo "----------------------------------------------------\n"
du -ab test1
echo "\nresultat que donne (./mdu -b)"
echo "----------------------------------------------------\n"
./mdu -b test1
echo "on a le même resultat" && echo "***********************************************\n" 


echo "resultat attendu avec du -L -B512"
echo "----------------------------------------------------\n"
du -LaB512 test1
echo "\nresultat que donne (./mdu -L)"
echo "----------------------------------------------------\n"
./mdu -L test1
echo "on a le même resultat sauf que là on se retrouve avec des doublons du aux liens symboliques" && echo "*******************************************************************************************\n" 


echo "resultat attendu avec du -L -b"
echo "----------------------------------------------------\n"
du -Lab test1
echo "\nresultat que donne (./mdu -Lb)"
echo "----------------------------------------------------\n"
./mdu -Lb test1
echo "on a le même resultat sauf que là on se retrouve avec des doublons du aux liens symboliques" && echo "*******************************************************************************************\n" && rm -r test1
