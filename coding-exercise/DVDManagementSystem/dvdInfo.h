#ifndef __DVDINFO_H__
#define __DVDINFO_H__

#include "cusInfo.h"

#define ISBN_LEN	30
#define TITLE_LEN	30

enum {ACTION=1, COMIC, SF, ROMANTIC}; // 장르 정보
enum {RENTED, RETURNED};	// 대여 상태


typedef struct _dvdInfo
{
	char ISBN[ISBN_LEN];
	char title[TITLE_LEN];
	int genre;
	int rentState;	//대여 상태 정보	
}dvdInfo;

#endif