#include <iostream>
struct ListNode {
	int val;
	ListNode *next;
	ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode *swapPairs(ListNode *head) 
    {
    	int i = 0;
    	ListNode* p = head;
    	ListNode* pPrev = NULL;
    	ListNode* pPrevPrev = NULL;
    	ListNode* pNewHead = NULL;
    	ListNode* pNext = NULL;
    	while( p != NULL )
    	{
    		pNext = p->next;
    		if ( i % 2 == 0 )
    		{
    			pPrev = p;
    			if( pPrevPrev!= NULL ) pPrevPrev->next = p;
    		}
    		else
    		{
    			if ( pPrevPrev == NULL )
    				pNewHead = p;
    			else
    				pPrevPrev->next = p;
    			pPrevPrev = pPrev;
    			p->next = pPrev;
    			pPrev->next = NULL;
    			//printf("%d,p:%d,p->next:%d\n", i,p->val,p->next->val);
    			
    		}
    		i++;
    		p = pNext;
    	}
        return pNewHead == NULL ? head : pNewHead ;
    }
};

void printList(ListNode *node)
{
	char buffer[1024*10];
	memset(buffer,0,sizeof(char) * 1024 * 10);
	while( node != NULL )
	{

		sprintf(buffer,"%s,[node:%d]",buffer,node->val);
		node = node->next;
	}
	printf("%s\n", buffer);
}

int main(int argc, char const *argv[])
{
	ListNode* head1 = new ListNode(0);
	ListNode* p = head1;
	for (int i = 1; i < 0; ++i)
	{
		ListNode* node = new ListNode(i);
		p->next = node;
		p = p->next;
	}
	printList(head1);
	
	Solution s;
	ListNode* result = s.swapPairs(head1);
	printList(result);
	return 0;
}