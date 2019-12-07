#ifndef _GOMOKU_CLIENT_H_
#define _GOMOKU_CLIENT_H_

#include <winsock.h>

class Client
{
private:
	int clientID;
	int roomID;
	SOCKET clientSocket;

public:
	Client(int clientID, SOCKET clientSocket);
	int getClientID();
	int getRoomID();
	void setRoomID(int roomID);
	SOCKET getClientSocket();
};

#endif