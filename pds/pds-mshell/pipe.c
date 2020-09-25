/* mshell - a job manager */

#include <stdio.h>
#include <sys/types.h>
#include <stdlib.h>
#include <unistd.h>
#include <string.h>
#include "cmd.h"
#include "pipe.h"
#include "jobs.h"

/*void construit_ligne_commande(char *cmds[MAXCMDS][MAXARGS], char*cmd,int nbcmd){
    int i; 
    sprintf(cmd,cmds[0][0]);
    for (i = 1; i < nbcmd; i++)
    {
       strcat(cmd," | ");
       strcat(cmd,cmds[i][0]);
    }
    
}*/
void do_pipe(char *cmds[MAXCMDS][MAXARGS], int nbcmd, int bg) {
    pid_t pid/*,tab_fils[nbcmd]*/;
    /*Construction de la commande */
    /*char *cmd ="";
    construit_ligne_commande(cmds, cmd,nbcmd);*/
    if (nbcmd == 2){
         
        int fd[2];
        pipe(fd);
       
        switch (pid = fork()){
            case -1:
                exit (EXIT_FAILURE);
            case 0 :
                /*tab_fils[0] = getpid();*/
                close(fd[0]);
                dup2 (fd[1],STDOUT_FILENO);
                close (fd[1]);
                execvp(cmds[0][0],cmds[0]);
                exit(EXIT_FAILURE);

        }
         switch (fork()){
            case -1:
                exit (EXIT_FAILURE);
            case 0 :
                /*tab_fils[1] = getpid();*/
                close(fd[1]);
                dup2 (fd[0],STDIN_FILENO);
                close (fd[0]);
                execvp(cmds[1][0],cmds[1]);
                exit(EXIT_FAILURE);

        }
        close(fd[0]);
        close(fd[1]);
        if (bg){
            jobs_addjob(pid,BG,cmds[0][0]);
            /*jobs_addjob(pid,BG,cmds[1][0]);*/
            /*
            jobs_addjob(tab_fils[0],BG,cmds[0][0]);
            jobs_addjob(tab_fils[1],BG,cmds[1][0]);*/
        }else{
            /*jobs_addjob(tab_fils[0],FG,cmds[0][0]);*/
            jobs_addjob(pid,BG,cmds[0][0]);
            waitfg(pid);
        }
    }
    else if (nbcmd == 3){
        int fd12[2];
        int fd23[2];
        pipe(fd12);
        pipe(fd23);
       
        switch (pid = fork()){
            case -1:
                exit (EXIT_FAILURE);
            case 0 :
                
                close(fd12[0]);
                dup2 (fd12[1],STDOUT_FILENO);
                close (fd12[1]);
                close(fd23[0]);
                close(fd23[1]);
                execvp(cmds[0][0],cmds[0]);
                exit(EXIT_FAILURE);

        }
         switch (fork()){
            case -1:
                exit (EXIT_FAILURE);
            case 0 :
                
                close(fd12[1]);
                dup2 (fd12[0],STDIN_FILENO);
                close (fd12[0]);

                close(fd23[0]);
                dup2 (fd23[1],STDOUT_FILENO);
                close (fd23[1]);

                execvp(cmds[1][0],cmds[1]);
                exit(EXIT_FAILURE);

        }
         switch (pid = fork()){
            case -1:
                exit (EXIT_FAILURE);
            case 0 :
                
                close(fd23[1]);
                dup2 (fd23[0],STDIN_FILENO);
                close (fd23[0]);

                close(fd12[0]);
                close(fd12[1]);

                execvp(cmds[2][0],cmds[2]);
                exit(EXIT_FAILURE);

        }
        close(fd23[0]);
        close(fd23[1]);
        
        close(fd12[0]);
        close(fd12[1]);
        if (bg){
            jobs_addjob(pid,BG,cmds[2][0]);
        }else{
            jobs_addjob(pid,FG,cmds[2][0]);
            waitfg(pid);
        }

    }
    /*cas général*/
    else{
        int *tabFd[nbcmd-1];
        int i;
        for(i = 0; i < nbcmd-1;i++){
            int fd[2];
            tabFd[i] = fd;
            pipe(fd);
        }
         switch(pid = fork()){
            case -1:
                exit (EXIT_FAILURE);
            case 0 :
                close(tabFd[0][0]);
                dup2 (tabFd[0][1],STDOUT_FILENO);
                close (tabFd[0][1]);
                /*fermer les autres descripteurs sauf le courant donc le premier*/
                for(i=1;i<nbcmd;i++ ){
                    close(tabFd[i][0]);
                    close(tabFd[i][1]);
                }
                execvp(cmds[0][0],cmds[0]);
                exit(EXIT_FAILURE);

            }
        for(i=1; i<nbcmd-1; i++){
            switch(fork()){
                case -1:
                    exit (EXIT_FAILURE);
                case 0 :
                    close(tabFd[i-1][1]);
                    dup2 (tabFd[i-1][0],STDIN_FILENO);
                    close(tabFd[i-1][0]);

                    close(tabFd[i][0]);
                    dup2 (tabFd[i][1],STDOUT_FILENO);
                    close(tabFd[i][1]);

                    execvp(cmds[i][0],cmds[i]);
                    exit(EXIT_FAILURE);
            }
        }
        switch(fork()){
                case -1:
                    exit (EXIT_FAILURE);
                case 0 :
                    close(tabFd[nbcmd-1][1]);
                    dup2 (tabFd[nbcmd-1][0],STDIN_FILENO);
                    close (tabFd[nbcmd-1][0]);

                    /*fermer les autres descripteurs sauf le courant donc le dernier*/
                    for(i=0;i<nbcmd-1;i++ ){
                        close(tabFd[i][0]);
                        close(tabFd[i][1]);
                    }

                    execvp(cmds[nbcmd-1][0],cmds[nbcmd-1]);
                    exit(EXIT_FAILURE);

            }
         for(i=0;i<nbcmd;i++){
            close(tabFd[i][0]);
            close(tabFd[i][1]);
         }

        if (bg){
            jobs_addjob(pid,BG,cmds[0][0]);
        }else{
            jobs_addjob(pid,FG,cmds[0][0]);
            waitfg(pid);
        }
    }
     
    return;
}
