#ifndef __GAME_H__
#define __GAME_H__

enum {
	SCISSOR = 1,
	ROCK,
	PAPER
};

int ChoiceOfCom();
int ChoiceOfMe();
int WhoIsWinner(int com, int you);

#endif
