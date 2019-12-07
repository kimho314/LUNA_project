#ifndef __DVDACCESS_H__
#define __DVDACCESS_H__

#include "dvdInfo.h"

int AddDvdInfo(char* ISBN, char* title, int genre);
dvdInfo* GetDvdPtrByISBN(char* ISBN);
int IsRegistISBN(char* ISBN);
int AddRentInfo(char* ISBN);
int IsRentedISBN(char* ISBN);
int ReturnRentedInfo(char* ISBN);

#endif