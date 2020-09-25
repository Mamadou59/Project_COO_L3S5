#include <unistd.h>
#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <assert.h>
int vflag, rflag, wflag, xflag;


void prlimit(void){
  printf("la longueur maximale d’un nom d’entrée dans le système de fichiers est: %d\n",NAME_MAX );
  printf("la longueur maximale d’un chemin  d’entrée dans le système de fichiers est: %d\n",PATH_MAX );
}

void usage (char *prog) {
   printf("usage : %s [rvwx] file", prog);
}

int maccess (int argc, char **argv) {
   printf("OPTIONS verbose:%i, read:%i, write:%i, exec:%i\n",vflag,rflag,wflag,xflag);
   printf("REMAINING %i ARGS:\n",argc);
   int mask = 0;
   if(rflag) mask = mask|R_OK;
   if(wflag) mask = mask|W_OK;
   if(xflag) mask = mask|X_OK;
   assert (mask>0); // dans le cas où le mode n'est pas defini
   int res = access(argv[0],mask);
   if (res && vflag == 1){
      switch (errno) {
      case EACCES :
         printf("%s\n","Parcours non permis!" );
         break;
      case ELOOP :
         printf("%s\n","Le lien symbolique pointe sur lui même!" );
         break;
      case ENAMETOOLONG :
         printf("%s\n","Le nom chemin est trop long!" );
         break;
      case ENOENT :
         printf("%s\n","Un compossant du chemin d'accès n'exite pas ou est un lien symbolique pointant nulle part!" );
         break;
      case ENOTDIR :
         printf("%s\n","Un élément du chemin d'accès n'est pas répertoire!" );
         break;
      case EROFS :
         printf("%s\n","Impossible d'érire sur un système de fichier en lecture seule!");
         break;
      }
   }
   else if( ! res) {
      printf("%s\n","bien passé!");
      return 0;
   }
   return 1;
}

int main (int argc, char **argv) {
   int ch;
   vflag = 0;
   rflag = 0;
   wflag = 0;
   xflag = 0;
   while ((ch = getopt(argc, argv, "vrwxh")) != -1) {
      switch (ch) {
      case 'v':
         vflag = 1;
         break;
      case 'r':
         rflag = 1;
         break;
      case 'w':
         wflag = 1;
         break;
      case 'x':
         xflag = 1;
         break;
      case 'h':
      default:
         usage(argv[0]);
      }
   }
   argc -= optind;
   argv += optind;

   return maccess(argc,argv);
}
