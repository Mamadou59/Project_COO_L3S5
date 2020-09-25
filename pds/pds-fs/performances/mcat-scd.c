#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <unistd.h>


int mcat(char *pathname){
  int size = atoi(getenv("MCAT_BUFSIZ"));
  unsigned char *buf = (unsigned char *)malloc(size * sizeof(unsigned char));
  int fd = open(pathname,O_RDONLY,644);
  assert(fd != -1);
  int resRead,resWrite;
  while((resRead = read(fd,buf,size)) != 0){
    assert(resRead != -1);
    resWrite = write(STDOUT_FILENO,buf,resRead);
    assert(resWrite != -1);
  }
  return 1;
}

int main(int argc, char  **argv) {
  assert(argc > 1);
  mcat(argv[1]);
  return 0;
}
//dd if=/dev/zero of=/tmp/1Mo bs=1k count=1000
