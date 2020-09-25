#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <time.h>
#include <assert.h>
#include <pthread.h>
#include <signal.h>

unsigned long compteur_gc(char *bloc, unsigned long taille) {
    unsigned long i, cptr = 0;

    for (i = 0; i < taille; i++)
        if (bloc[i] == 'G' || bloc[i] == 'C')
            cptr++;
    return cptr;
}

struct args_t{
    char *bloc;
    unsigned long taille;
    unsigned long res;
};
void * pt_compteur_gc(void *arg){
    struct args_t *s;
    s = (struct args_t *)(arg);
    s->res = compteur_gc(s->bloc,s->taille);
    return NULL;
}
unsigned long compteur_func(char *chaine,unsigned long taille, int nb_threads){
    int i,l;
    pthread_t tb_thread[nb_threads];
    struct args_t tb_args[nb_threads];
    unsigned long res = 0,diff;
    l = taille/nb_threads;
    /*Lancer les nb_threads*/
    for(i = 0; i < nb_threads ; i++){
        tb_args[i].bloc = chaine + i*l;
        tb_args[i].taille = l;
        pthread_create (&tb_thread[i],NULL,pt_compteur_gc,(void *) (&tb_args[i]));
    }
    /*Dans le cas où la taille n'est pas multiple du nb_threads*/
    if ((taille % nb_threads) != 0){
        diff = taille % nb_threads;
        chaine = chaine + nb_threads * l ;
        res += compteur_gc(chaine, diff);
    }
    /*Attendre tous les threads lancés */
    for (i = 0; i < nb_threads; i++){
        pthread_join(tb_thread[i],NULL);
        res+=tb_args[i].res;
    }
    return res;
}

int main(int argc, char *argv[]) {
    struct stat st;
    int fd;
    char *tampon;
    int lus;
    /*unsigned long cptr = 0;*/
    off_t taille = 0;
    struct timespec debut, fin;

    assert(argc > 1);

    /* Quelle taille ? */
    assert(stat(argv[1], &st) != -1);
    tampon = malloc(st.st_size);
    assert(tampon != NULL);

    /* Chargement en mémoire */
    fd = open(argv[1], O_RDONLY);
    assert(fd != -1);
    while ((lus = read(fd, tampon + taille, st.st_size - taille)) > 0)
        taille += lus;
    assert(lus != -1);
    assert(taille == st.st_size);
    close(fd);

    /* Calcul proprement dit */
    assert(clock_gettime(CLOCK_MONOTONIC, &debut) != -1);
    /*cptr = compteur_func(tampon, taille,atoi(argv[2]));*/
    compteur_func(tampon, taille,atoi(argv[2]));
    assert(clock_gettime(CLOCK_MONOTONIC, &fin) != -1);

    /* Affichage des résultats */
    /*printf("Nombres de GC:   %ld\n", cptr);
    printf("Taux de GC:      %lf\n", ((double) cptr) / ((double) taille));*/

    fin.tv_sec  -= debut.tv_sec;
    fin.tv_nsec -= debut.tv_nsec;
    if (fin.tv_nsec < 0) {
        fin.tv_sec--;
        fin.tv_nsec += 1000000000;
    }
    printf("%ld.%09ld\n", fin.tv_sec, fin.tv_nsec);
    /*printf("(Attention: très peu de chiffres après la virgule sont réellement significatifs !)\n");*/

    return 0;
}
