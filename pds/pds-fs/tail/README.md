#   `tail`

Ce répertoire correspond aux exercices de la section
[Afficher la fin d’un
fichier](http://www.fil.univ-lille1.fr/~hym/e/pds/tp/tdfs-cmd.html#tail)
(versions simpliste et efficace de `tail`).

**Auteurs**: **Diallo** Mamadou et **Fungwa Moke** Junior

**Travail réalisé** 
-------------------

Nous nous sommes parvenus à implémenter la  version classique de la fonction **mtail**.

La version efficace  **mtail_efficace** ne marche pas correctement.

**mtail_efficace** 
-------------------
La version efficace de notre **mtail_efficace** ne marche que pour des tampons de taille superieur a celle du fichier.

**le  fichier test.sh**
-----------------------

Pour  le   **mtail_efficace**
-----------------------------

Dans notre script test, nous l'illustrerons sur le fichier README.md avec un tampon de taille 1000.
Pour  le   **mtail**

Nous utiliserons son option *-n*, ainsi que la commande ***diff*** du bash pour illustrer son fonctionnement dans notre script.