/* mshell - a job manager */

#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <signal.h>
#include <sys/wait.h>
#include <errno.h>
#include <assert.h>

#include "jobs.h"
#include "common.h"
#include "sighandlers.h"

/*
 * wrapper for the sigaction function
 */
int sigaction_wrapper(int signum, handler_t * handler) {
    struct sigaction action;
    action.sa_handler = handler;
    sigemptyset(&action.sa_mask);
    action.sa_flags = SA_RESTART;
    sigaction(signum,&action,NULL);
    return 1;
}

/*
 * sigchld_handler - The kernel sends a SIGCHLD to the shell whenever
 *     a child job terminates (becomes a zombie), or stops because it
 *     received aIG SSTOP or SIGTSTP signal. The handler reaps all
 *     available zombie children
 */
void sigchld_handler(int sig) {
    struct job_t *job;
    pid_t pid;
    int status;

    if (verbose)
        printf("sigchld_handler: entering\n");

    pid = waitpid(-1,&status,WUNTRACED|WNOHANG);
    job = jobs_getjobpid(pid);
    if(WIFEXITED(status)){
        printf("Normalement / avec fermeture de la fenêtre\n");
        jobs_deletejob(pid);
    }
    else if(WIFSTOPPED(status)){
        printf("processus Stopper\n");
        job->jb_state = ST;
    }
    else if(WIFSIGNALED(status)){
        printf("Normale avec un signal\n");
        jobs_deletejob(pid);
    }

    if (verbose)
        printf("sigchld_handler: exiting\n");

    return;
}

/*
 * sigint_handler - The kernel sends a SIGINT to the shell whenver the
 *    user types ctrl-c at the keyboard.  Catch it and send it along
 *    to the foreground job.
 */
void sigint_handler(int sig) {
    if (verbose)
        printf("sigint_handler: entering\n");
    if (sig == SIGINT ){
        pid_t pid;
        pid = jobs_fgpid();
        if (pid != 0)
            kill(pid,sig);
        /*Tanque j'ai un pid*/
        /*while((pid = jobs_fgpid()) != 0){
            printf("pid => %d",pid);
            kill(pid,sig);
        }*/
        if (verbose)
            printf("sigint_handler: exiting\n");
    }else{
        if (verbose)
            printf("Le signal envoyer est incorrecte!\n");
    }
    /*assert(sig == SIGINT );*/
    

    return;
}

/*
 * sigtstp_handler - The kernel sends a SIGTSTP to the shell whenever
 *     the user types ctrl-z at the keyboard. Catch it and suspend the
 *     foreground job by sending it a SIGTSTP.
 */
void sigtstp_handler(int sig) {
    if (verbose)
        printf("sigtstp_handler: entering\n");
    if(sig == SIGTSTP){
        pid_t pid;
        pid = jobs_fgpid();
        if (verbose)
            printf("stopping processus %d \n", pid);
        pid = jobs_fgpid();
        if (pid != 0)
            kill(pid,sig);
        /*Tanque j'ai un pid*/
        /*while((pid = jobs_fgpid()) != 0){
            printf("pid => %d",pid);
            kill(pid,sig);
        }*/
        if (verbose)
            printf("sigtstp_handler: exiting\n");
    }else{
        if (verbose)
            printf("Le signal envoyer est incorrecte!\n");
    }
    /*assert(sig == SIGTSTP);*/
    return;
}
