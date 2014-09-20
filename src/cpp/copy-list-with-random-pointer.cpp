#include <iostream>
#include <vector>
#include <map>
using namespace std;
/*
A linked list is given such that each node contains an additional random pointer 
which could point to any node in the list or null.

Return a deep copy of the list.
*/

struct RandomListNode 
{
	int label;
	RandomListNode *next, *random;
	RandomListNode(int x) : label(x), next(NULL), random(NULL) {}
};
 
class Solution {
public:
    RandomListNode *copyRandomList(RandomListNode *head) 
    {
    	RandomListNode* pHead = head;
    	RandomListNode* pNewHead= NULL;
    	RandomListNode* pTmp = NULL;
    	RandomListNode* pPrev = NULL;
    	RandomListNode* pNewRandom = NULL;
    	map<RandomListNode*,RandomListNode*> dic;

    	while( pHead != NULL )
    	{
    		pTmp = copyANode( pHead, dic );

    		if ( pHead == head ) pNewHead = pTmp;

    		if ( pHead -> random != NULL )
    		{
    			pNewRandom = copyANode( pHead-> random, dic );
    			pTmp -> random = pNewRandom;
    		}
    		else
    		{
    			pTmp -> random = NULL;
    		}
    		
    		if ( pPrev != NULL ) pPrev->next = pTmp;
    		pPrev = pTmp;
    		pHead = pHead->next;
    		
    	}

        return pNewHead;
    }
    RandomListNode* copyANode(RandomListNode *node,map<RandomListNode*,RandomListNode*> &dic)
    {
    	RandomListNode* result;
    	if ( dic.find(node) == dic.end() )
    	{

    		result = new RandomListNode(node->label);
    		result->label = node->label;
    		dic[node] = result;
    	}
    	else
    	{
    		result = dic[node];
    	}
    	return result;
    }
};
void printList(RandomListNode *node)
{
	char buffer[1024*10];
	memset(buffer,0,sizeof(char) * 1024 * 10);
	while( node != NULL )
	{

		sprintf(buffer,"%s,[node:%d,next:%d,random:%d,memory:%ld]",buffer,node->label
			,node->next == NULL ? -999 : node->next->label 
			,node->random == NULL ? -999 : node->random->label 
			,(long)node
			);
		node = node->next;
	}
	printf("%s\n", buffer);
}
int main(int argc, char const *argv[])
{
	RandomListNode* prev = NULL;
	RandomListNode* head = NULL;
	for (int i = 0; i < 100; ++i)
	{
		RandomListNode* node1 = new RandomListNode(i);
		if ( head == NULL )
		{
			head = node1;
		}
		if ( prev != NULL )
		{
			prev->next = node1;
		}
		prev = node1;
		

	}
	//node2->next = node3;
	//node3->next = node4;
	//node4->next = node5;

	//node1->random = node5;
	//node2->random = node3;


	//printList(head);
	Solution s;
	RandomListNode* result = s.copyRandomList(head);
	printList(result);
	return 0;
}