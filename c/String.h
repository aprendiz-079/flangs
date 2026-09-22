

#ifndef _STRING_H_
#define _STRING_H_

#include <stdlib.h>
#include <stdio.h>
#include <string.h>

#define INITIAL_CAPACITY 8

typedef struct
{
	long int len;
	long int cap;
	char *buf;
} String;


String* newstring(char *s)
{	
	String *re = (String*)malloc(sizeof(String));
	re->cap = INITIAL_CAPACITY;
	
	if(!s)
	{
		re->len = re->cap;
		re->buf = (char*)malloc((re->len + 1) * sizeof(char));
		re->buf[re->len + 1] = '\0';
		return re;
	}
	
	long int s_sz = strlen(s);
	re->len = s_sz;
	re->buf = (char*)malloc((re->len + 1) * sizeof(char));
	strcpy(re->buf, s);
	re->buf[re->len+1] = '\0';
	
	return re;
}

String* append(String *src, char *s)
{
	long int s_sz = strlen(s);
	if(!s || s_sz == 0) return src;
	
	long int total_size = src->len + s_sz;
	src->len = total_size;
	while(src->cap < total_size) src->cap *= 2;
	src->buf = (char*)realloc(src->buf, src->cap);
	strcat(src->buf, s);
	if(src->buf[src->len] != '\0') src->buf[src->len] = '\0';
	
	return src;
}

String* delete_range(String *src, long int start, long int end)
{
	if(!src || !src->buf || start >= end) return src;
	if(start < 0 ) start = 0;
	
	long int dif = end - start;
	char *s = (char*)malloc((dif + 1) * sizeof(char));

	*(s + dif + 1) = '\0';

	 s = strncpy(s, src->buf + start, dif);

	src->buf = s;

	free(s);
	return src;
}

void freeall(String *s)
{
	free(s->buf);
	free(s);
}

#endif // STRING_H


