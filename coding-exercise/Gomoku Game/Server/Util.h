#ifndef _GOMOKU_UTIL_H_
#define _GOMOKU_UTIL_H_

#include <vector>
#include <sstream>

using namespace std;

class Util
{
public:
	vector<string> getTokens(string input, char delimiter);
};

#endif