echo "++++      Affichage de prlimit     ++++"
echo "+                                     +"
echo "+++++++++++++++++++++++++++++++++++++++"
./prlimit
echo "----------------------------------------------------"
touch fichier && echo abc > fichier
ls -l fichier
echo "Commande => ./maccess fichier -r > /dev/null"
./maccess fichier -r > /dev/null
echo $?
echo "La lecture est bien permise!"
echo "Commande => ./maccess fichier -w > /dev/null" 
./maccess fichier -w > /dev/null
echo $?
echo "On peut aussi écrire dans le fichier"
echo '----------------------------------------------------'
echo "++++ Traitement de l'erreur EACCES ++++"
echo "+                                     +"
echo "+++++++++++++++++++++++++++++++++++++++"
echo "Commande => ./maccess fichier -x > /dev/null" 
./maccess fichier -x > /dev/null
echo $?
echo "Il y'a bien une erreur mais celle-ci n'est pas affichée!"
echo "Commande => ./maccess fichier -xv " 
./maccess fichier -xv
echo $?
echo "Là On remarque bien qu'il affiche le message du à l'ajout de l'option -v"
echo '----------------------------------------------------'
rm fichier
echo "++++ Traitement de l'erreur ELOOP  ++++"
echo "+                                     +"
echo "+++++++++++++++++++++++++++++++++++++++"
ln -s piege piege
echo "Commande => ./maccess fichier -r > /dev/null" 
./maccess piege -r > /dev/null
echo $?
echo "Il y'a bien une erreur mais celle-ci n'est pas affichée!\n"
echo "Commande => ./maccess fichier -rv " 
./maccess piege -rv 
echo $?
echo "On a maintenant le message d'erreur qui s'affiche"
rm piege
echo '----------------------------------------------------'
echo "++++ Traitement de l'erreur ENOENT  ++++"
echo "+                                      +"
echo "++++++++++++++++++++++++++++++++++++++++\n"
echo " ##- Un lien symbo pointant nulle part -##"
ln -s piege
./maccess piege -rv /dev/null
echo $? && rm piege
echo "##- un composant du chemin d'accès qui n'existe pas -##"
ls -l && echo "\nle fichier 'fichier_non_existant' n'est pas dans ce repertoire \n"
./maccess fichier_non_existant -wrvx > /dev/null
echo $?
echo '----------------------------------------------------'
echo '----------------------------------------------------'
echo "++++ Traitement de l'erreur ENOTDIR  ++++"
echo "+                                      +"
echo "++++++++++++++++++++++++++++++++++++++++\n"
mkdir  rep1
touch rep1/fichier1 && touch rep1/fichier2
./maccess rep1/fichier1/fichier2 -rv > /dev/null
echo $? && rm -r rep1
