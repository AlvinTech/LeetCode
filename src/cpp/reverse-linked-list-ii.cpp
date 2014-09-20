#include <iostream>
#include <vector>
using namespace std;

struct ListNode {
	int val;
	ListNode *next;
	ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode *reverseBetween(ListNode *head, int m, int n) 
    {
    	if ( m == n ) return head;
    	//ListNode newHead(0);
    	ListNode* prevNode = NULL;
    	ListNode* mPrev = NULL;
    	ListNode* nNext = NULL;
    	ListNode* ptr = head;
    	ListNode* pLast = NULL;
    	ListNode* pStart = NULL;
    	ListNode* newHead = NULL;
    	int index = 0;
    	while( index < n )
    	{
    		if ( index == m-1 )
    		{
    			mPrev = prevNode;
    			pStart = ptr;
    		}
    		prevNode = ptr;
    		ptr = ptr->next;
    		index++;
    	}
    	pLast = prevNode;
    	nNext = pLast->next;

    	pLast->next = NULL;

    	reverse(pStart);
    	if ( mPrev == NULL )
    	{
    		newHead = pLast;
    	}
    	else
    	{
    		newHead = head;
    		mPrev->next = pLast;
    	}
    	pStart->next = nNext;


        return newHead;
    }

    ListNode* reverse(ListNode* oldHead)
    {
    	ListNode* ptr = oldHead;
    	ListNode* prev = NULL;
    	ListNode* next = NULL;
    	while( ptr != NULL )
    	{
    		next= ptr->next;
    		if ( prev != NULL )
    		{
    			ptr->next = prev;
    		}
    		else
    		{
    			ptr->next = NULL;
    		}
    		prev = ptr;
    		ptr = next;
    	}
    	return prev;

    }
};

void printVector1(vector<int> &v)
{
	char buffer[1024];
	memset( buffer,0,sizeof(char)*1024 );
	for (int i = 0; i < v.size(); ++i)
	{
		sprintf(buffer,"%s,%d",buffer,v[i]);
	}
	printf("%s\n",buffer );
}

ListNode* arr2node(int value[],int len)
{
	ListNode head(0);
	ListNode* p = &head;
	for (int i = 0; i < len; ++i)
	{
		ListNode* tmp = new ListNode(value[i]);
		p->next = tmp;
		p = p->next;
	}
	return head.next;
}

void printList(ListNode *node)
{
	int index = 0;

	char buffer[1024*10];
	memset(buffer,0,sizeof(char) * 1024 * 10);
	while( node != NULL && index < 20 )
	{

		sprintf(buffer,"%s,%d",buffer,node->val);
		node = node->next;
		index++;
	}
	printf("%s\n", buffer);
}


int main(int argc, char const *argv[])
{
	
	int value1[] = {1,2,3,4,5};
	ListNode* head1 = arr2node(value1,sizeof(value1)/sizeof(int));

	Solution s;
	ListNode* result = s.reverseBetween(head1,1,5);
	printList(result);

	return 0;
}