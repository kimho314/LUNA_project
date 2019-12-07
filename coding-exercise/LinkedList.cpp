// LinkedList.cpp : This file contains the 'main' function. Program execution begins and ends there.
//

#include "pch.h"
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#if 0
#define INF	10000

int arr[INF];
int count = 0;

void addBack(int data)
{
	arr[count] = data;
	count++;
}

void addFirst(int data)
{
	for (int i = count; i >= 1; i--)
	{
		arr[i] = arr[i - 1];
	}
	arr[0] = data;
	count++;
}

void Delete(int data)
{
	int idx = 0;

	for (int i = 0; i < count; i++)
	{
		if (arr[i] == data)
			idx = i;
	}
	count--;

	for (int i = idx; i < count; i++)
	{
		arr[i] = arr[i + 1];
	}
}

void show()
{
	for (int i = 0; i < count; i++)
	{
		printf("%d ", arr[i]);
	}
	printf("\n");
}

int main()
{
	addFirst(4);
	addFirst(5);
	addFirst(1);
	addBack(7);
	addBack(6);
	addBack(8);
	show();
	system("pause");

	Delete(7);
	show();
	system("pause");

	return 0;
}
#endif

#if 1
typedef struct _node
{
	int data;
	struct _node *next;
}Node;

void addFront(Node *head, int data)
{
	Node *newNode = (Node*)malloc(sizeof(Node));
	newNode->data = data;
	newNode->next = head->next;
	head->next = newNode;
}

void delFront(Node *head)
{
	Node *tmpNode = head->next;
	head->next = tmpNode->next;
	free(tmpNode);
}

void showAll(Node *head)
{
	Node *cur = head->next;
	while (cur != NULL)
	{
		printf("%d ", cur->data);
		cur = cur->next;
	}
	printf("\n");
}

int main()
{
	Node *head = (Node*)malloc(sizeof(Node));
	head->next = NULL;

	addFront(head, 1);
	addFront(head, 2);
	addFront(head, 3);
	addFront(head, 4);
	addFront(head, 5);
	showAll(head);

	delFront(head);
	showAll(head);


	return 0;
}

#endif

// Run program: Ctrl + F5 or Debug > Start Without Debugging menu
// Debug program: F5 or Debug > Start Debugging menu

// Tips for Getting Started: 
//   1. Use the Solution Explorer window to add/manage files
//   2. Use the Team Explorer window to connect to source control
//   3. Use the Output window to see build output and other messages
//   4. Use the Error List window to view errors
//   5. Go to Project > Add New Item to create new code files, or Project > Add Existing Item to add existing code files to the project
//   6. In the future, to open this project again, go to File > Open > Project and select the .sln file
