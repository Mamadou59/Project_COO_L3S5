#   `du`

Ce répertoire correspond aux exercices de la section
[Parcours d’une hiérarchie](http://www.fil.univ-lille1.fr/~hym/e/pds/tp/tdfs-cmd.html#du).

Ce répertoire devra contenir **exclusivement** les fichiers :
`README.md`, `Makefile`, `mdu.c` et soit `tests.sh` soit
`session.txt`.
En particulier, un dépôt de code ne doit jamais contenir les fichiers
compilés (`.o`, exécutable, etc.).

Vous éditerez ce fichier pour qu’il contienne un compte-rendu du
travail effectué (qu’est-ce qui marche, qu’est-ce qui ne marche pas,
etc.).




Auteurs: Diallo Mamadou et Fungwa Moke Junior

----------------- Travail réalisé ----------------------------------------

Nous sommes parvenus à implémenter   la  fonction `du_file` avec ses options:
 -mdu  ----> du -B512 -a;
 -mdu  -b ----> du -b -a;
 -mdu  -L ----> du -LB512 -a;
 -mdu  -LB ----> du -Lb -a;

 Nous nous sommes servis de la fonction `is_not_point` pour savoir si une chaîne de caractère est un `.` ou `..`

----------------- le  fichier test.sh----------------------------------------

Nous avons produit un script permettant d'illustrer toutes les fonctionnalités que doit produire la commande `du`.
 Cependant, pour ce qui est de la gestion des liens symboliques(se basant sur une table de hachage avec comme clé le numéro du périphérique et le numéro d'Inoeud), nous ne sommes pas parvenus.

----------------------------Exécution des fichiers-------------------------------------

Vous avez juste à vous placer dans le répertoire `du` et exécuter les commande:
    -`make mdu`
    -`make test` pour afficher les traces d’exécution.
