
#include <stdlib.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdio.h>



int main(void) {
  pid_t pid;
  int cpt=0;
  for (int i = 0; i < 10; i++) {
    cpt++;
    pid = fork();
    switch (pid) {
      case -1:
        perror("erreur fork");
        exit(EXIT_FAILURE);
        break;
      case 0:
        for (int j = 0; j < 100000000; j++) {}
        printf("fils %d => pere : %d fils: %d \n",cpt,getppid(),getpid());

        for (int j = 0; j < 100000000; j++) {}
        exit(EXIT_SUCCESS);
        break;
      default:
      ;
    }


  }
  for (int k = 0; k < 10; k++) {
    wait(NULL);
  }
  return 0;
}
