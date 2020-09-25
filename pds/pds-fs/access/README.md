#   `maccess`

Ce répertoire correspond aux exercices de la section
[Vérifier les droits d’accès... et expliquer](http://www.fil.univ-lille1.fr/~hym/e/pds/tp/tdfs-cmd.html#access).

Ce répertoire devra contenir **exclusivement** les fichiers :
`README.md`, `Makefile`, `prlimit.c`, `maccess.c` et soit `tests.sh`
soit `session.txt`.
En particulier, un dépôt de code ne doit jamais contenir les fichiers
compilés (`.o`, exécutable, etc.).

Ce répertoire contient une version initiale de `maccess.c` pour
illustrer l’utilisation de `getopt` et ainsi vous aider à démarrer.

Auteurs: Diallo Mamadou et Fungwa Moke Junior

----------------- le  fichier macces.c----------------------------------------

Nous sommes parvenus à faire correctement  les  fonctions prlimit ainsi que access.

----------------- le  fichier testmaccess.sh----------------------------------------

Nous avons produit un script permettant d'illustrer toutes les erreurs que doit produire la commande access sauf pour les erreurs:
        -ENAMETOOLONG:En raison de la difficulte de creer un long chemin;
        -EROFS: En raison de la difficulte de comprehension de "systeme de fichier"


----------------------------Exections des fichiers-------------------------------------
Vous avez juste à vous placer dans le repertoire `access` et éxecuter les commande:
    -'make macces' ,
    - 'make prlimit',
    - 'make test' pour afficher les traces d'éxecution.
