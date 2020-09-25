#include <unistd.h>
#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <assert.h>

void prlimit(void){
  printf("La longueur maximale d’un nom d’entrée dans le système de fichiers est: %d !\n",NAME_MAX );
  printf("La longueur maximale d’un chemin  d’entrée dans le système de fichiers est: %d !\n",PATH_MAX );
}

int main(void)
{
	prlimit();
	return 0;
}
