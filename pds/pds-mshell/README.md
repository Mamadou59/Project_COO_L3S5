#   Gestionnaire de travaux

Ce dépôt correspond au TP de PDS
« [mshell](http://www.fil.univ-lille1.fr/~hym/e/pds/tp/tdjobs.html) ».
Il contient un canevas de départ pour votre gestionnaire de travaux.
Vous y trouverez notamment :

-   un `Makefile` ;
-   `mshell.c` : contient entre autres le `main()` ;
-   `cmd.c`, `cmd.h` : contient les commandes `fg`, `bg`, `stop`...
-   `jobs.c`, `jobs.h` : contient la bibliothèque gérant les
    structures de données associées aux jobs ;
-   `sighandlers.c`, `sighandlers.h` : contient les traitants de
    signaux ;
-   `common.c`, `common.h` : contient des données et fonctions
    communes aux différents fichiers.

**AUTHOR** DIALLO *Mamadou* et FUNGWA MOKE *Junior*

Nous avons implementer toutes les fonctionnalités demandées sauf au niveaux des pipe nous n'avons pas pu gérer le fait d'avoir un PID génerique pour tout les processus lancés.