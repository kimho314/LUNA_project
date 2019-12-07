#ifndef __RENTINFO_H__
#define __RENTINFO_H__

#include "dvdInfo.h"
#include "cusInfo.h"

typedef struct _dvdRentInfo
{
	char cusID[ID_LEN];
	char ISBN[ISBN_LEN];
	unsigned int rentDay;
} dvdRentInfo;

#endif