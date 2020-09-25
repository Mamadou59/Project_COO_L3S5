#include <stdlib.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdio.h>
#include <string.h>

typedef int (*func_t) (char *);

int pidchild=0;
int res_fin=1;
int multif(func_t f[],char * args[], int n){
  pid_t pid;
  int res_int,status;
  int tab_exit[n];
  for (int i = 0; i < n; i++) {
    pid = fork();
    switch (pid) {
          case -1:
            perror("erreur fork");
            exit(EXIT_FAILURE);
            break;
          case 0:
            res_int = f[i](args[i]);
            exit(res_int);
            break;
         default:
         ;
    }
  }
  int k;
  for (k = 0; k < n; k++)
  {
    wait(&status);
    tab_exit[k] = WEXITSTATUS(status);
  }
  for (k = 0; k < n; k++)
  {
    if(tab_exit[k] == EXIT_FAILURE)
      exit(EXIT_FAILURE);
  }exit(EXIT_SUCCESS);

}

int testfunc(char* b){
  if (strncmp(b,"true",4) == 0) {
    return EXIT_SUCCESS;
  }
  else {
    return EXIT_FAILURE;
  }
}


int main(int argc,char **argv) {

  func_t f[argc-1];
  char *args[argc-1];
  int i;
  for ( i = 0; i < argc-1; i++)
  {
    f[i] = testfunc;
    args[i] = argv[i+1];
  }
  return multif(f,args,argc-1)  ;
}
