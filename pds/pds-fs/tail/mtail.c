#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <unistd.h>



int nflag,nbLine = 10;
int mtail(char **argv){
int fd = open(argv[0],O_RDONLY,644);
  int cpt_line = 0;
  char  c;

  while(read(fd,&c,1) != 0){
    if (c == '\n') {
      cpt_line++;
    }
  }
  if(c == '\n')
    cpt_line--;
  lseek(fd,0,SEEK_SET);
  int resRead, resWrite;
  while(cpt_line >= nbLine){
    resRead = read(fd,&c,1);
    assert(resRead != -1);
    if (c == '\n') {
      cpt_line--;
    }
  }
  while ((resRead = read(fd,&c,1)) != 0) {
    assert(resRead != -1);
    resWrite = write(STDOUT_FILENO,&c,resRead);
    assert(resWrite != -1);
  }
  return 1;
}
void usage (char *prog) {
   printf("usage : %s [n] file", prog);
}

int main (int argc, char **argv) {
   int ch;
   nflag = 0;

   while ((ch = getopt(argc, argv, "n:")) != -1) {
      switch (ch) {
      case 'n':
         nflag = 1;
         nbLine = atoi(optarg);
         break;
      default:
         usage(argv[0]);
      }
   }
   argc -= optind;
   argv += optind;

   return mtail(argv);
}
