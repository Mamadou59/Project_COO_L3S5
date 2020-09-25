#include <stdlib.h>
#include <sys/wait.h>
#include <unistd.h>
#include <stdio.h>
#include <string.h>
#include <sys/types.h>
#include <signal.h>
#include <assert.h>

#define MAX_PROCESS 10
pid_t tabPid[MAX_PROCESS];

int observe(int nbr_process){
    int i;
    pid_t pid;
    for(i = 0; i < nbr_process; i++){
        pid = fork();
        switch (pid) {
          case -1:
            perror("erreur fork");
            exit(EXIT_FAILURE);
            break;
          case 0:
            //tabPid[i] = getpid();
            while(1){
                printf("%d => Je suis encore en vie!! \n",getpid());
                sleep(5);
                printf("Le pid de mon père est => %d\n",getppid());
            }
         default:
            //assert(kill(getppid(),SIGKILL) == 0);
         ;
        }
    }
    //Afficher le processuces en cours
    printf("%d",system("ps"));
    // Boucle pour attendre les fils
    for (int j = 0; j < nbr_process; j++){
        char *res;
        pid_t pid_ended;
        //<defunct> => le processuce n'a pas completer ses tâches encore.
        //Comme dans chaque precessuce y'a une saisie en attente le dernier printf
        //ne sera liberé que lorsqu'on saisie quelque chose.
        int resScan = scanf("Saisir =>",res);
        pid_ended = wait(NULL);
        //Si le père est tuer avant les fils ceux-ci seront ratachés au PID init
        // et continueront à s'éxecuter.
        // Et cette ligne ne s'executera plus. car il à été tuer au moment ou il attendait ses fils
        printf("%d => un signal kill vient de couper ma vie!!\n",pid_ended);
    }
    return 0;
}

int main(void){
    return observe(3);
}
