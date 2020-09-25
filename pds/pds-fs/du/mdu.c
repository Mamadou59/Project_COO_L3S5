#include <unistd.h>
#include <errno.h>
#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include <sys/stat.h>
#include <assert.h>
#include <sys/types.h>
#include <dirent.h>

int aflag, bflag, Lflag;

void usage (char *prog) {
   printf("usage : %s [abL] file", prog);
}

int is_not_point(char *dir_name){
  return (dir_name[0] == '.') && ((dir_name[1] == '\0') || ((dir_name[1] == '.') && (dir_name[2] == '\0')));
}
int du_file(char *pathname){
  // printf("REMAINING %i ARGS:\n",argc);
  int total_size =0;
  int res_st, t;
  // if (bflag) mask|bflag;
  // if (Lflag) mask|Lflag;
  struct stat d_st;
  if (Lflag)
    res_st = stat(pathname,&d_st);
  else
    res_st = lstat(pathname,&d_st);
  assert(res_st != -1);
  if(bflag)
    total_size += d_st.st_size;
  else
    total_size += d_st.st_blocks;
  if (S_ISDIR(d_st.st_mode)){
    DIR *dir;
    struct dirent *d;
    dir = opendir(pathname);
    char path[PATH_MAX+1];
    while ((d=readdir(dir))!=NULL) {
      if (!(is_not_point(d->d_name))){
        snprintf(path,PATH_MAX,"%s/%s",pathname,d->d_name);
        t = du_file(path);
        total_size += t;
      }
    }
    closedir(dir);
  }
  printf("%d\t%s\n",total_size,pathname);
  return total_size;
}


int main (int argc, char **argv) {
   int ch;
   aflag = 0;
   bflag = 0;
   Lflag = 0;
   while ((ch = getopt(argc, argv, "abL")) != -1) {
      switch (ch) {
      case 'a':
         aflag = 1;
         break;
      case 'b':
         bflag = 1;
         break;
      case 'L':
         Lflag = 1;
         break;
      default:
         usage(argv[0]);
      }
   }
   argc -= optind;
   argv += optind;

   printf("OPTIONS all => a:%i, bytes => b:%i, dereference => L:%i\n",aflag,bflag,Lflag);
   return du_file(argv[0]);
}
