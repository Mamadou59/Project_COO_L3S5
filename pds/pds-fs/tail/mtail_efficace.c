#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <unistd.h>


int nflag,len,size,cpt_line = 0,nbLine = 10,i=1,j=0,resRead,resWrite,pos;
unsigned char c;
int mtail_efficace(int fd){
  unsigned char *buf;
  buf = (unsigned char *)malloc(size * sizeof(unsigned char));
  pos = len-(i*size);

  if (pos < 0){
    lseek(fd,0,SEEK_SET);
  }
  else{
    lseek(fd,pos,SEEK_SET);
  }
  if (nbLine == 0){}
  else{
    cpt_line = 0;
    j=0;
    while ((j < size) && (resRead = read(fd,buf,1) != 0)){
      if(*buf == '\n'){
        cpt_line++;
      }
      buf++;
      assert(resRead != -1);
    }
    i++;
    buf = buf - size;
    if((nbLine - cpt_line) >= 0){
      nbLine = nbLine - cpt_line;
      mtail_efficace(fd);
      resWrite = write(STDOUT_FILENO,buf,size);
    }
    else{
      int k = 0;
      while (cpt_line >= nbLine){
        if(*buf == '\n'){
          cpt_line--;
        }
        //cpt_line--;
        buf++;
        k++;
      }
      resWrite = write(STDOUT_FILENO,buf,size-k);
      assert(resWrite != -1);
      nbLine = 0;
    }
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

   int fd = open(argv[0],O_RDONLY,644);
   size = atoi(getenv("BUFSIZ"));
   len = lseek(fd,0,SEEK_END);
   return mtail_efficace(fd);
}
