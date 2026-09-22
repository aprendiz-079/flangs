

#include<stdio.h>


typedef struct
{
  unsigned int sz;
  char* buf;
} String;


unsigned int len(const char *s);
String getstring(const char *s);


int main(void)
{
  String s;

  s = getstring("opa");


  printf(s.sz, s.buf, "%u\n%s\n");

  return 0;
}


unsigned int len(const char *s)
{
  unsigned int i;
  for(i=0; *(s+i) != '\0'; i++);
  return i;
}


String getstring(const char *s)
{ return (String){len(s), (char*)s}; }

