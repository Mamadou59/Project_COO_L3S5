#   `multif`, course et observation

Ce répertoire correspond à l’exercice `multif` de la section
[Clonage de processus](http://www.fil.univ-lille1.fr/~hym/e/pds/tp/tdps-fork.html#multif)
et aux exercices de la section
[Gestion de processus](http://www.fil.univ-lille1.fr/~hym/e/pds/tp/tdps-ps.html).

Ce répertoire devra contenir **exclusivement** les fichiers :
`README.md`, `Makefile`, `multif.c`, `course.c`, `observe.c`.

**Author**: DIALLO Mamadou et FUNGWA MOKE Junior

**Travail réalisé** 
-------------------

Nous nous sommes parvenus à implémenter  les fonctions **course.c**,**multif.c**.

La  fonction **observe.c** ne marche pas correctement.

**observe.c** 
-------------

1. La boucle Infinie empêche l'exécution du code réaliser pour l'attente des fils.

2. D'abord quand on tue les fils, on peut voir à présent les codes sur l'affichage des processus actifs s'exécuter.
   Ensuite, quand on tue le père,  tous les processus lancés sont tués y compris le processus bash.

3. Nous ne sommes pas parvenus à comprendre correctement la question 3 et à la réaliser.
