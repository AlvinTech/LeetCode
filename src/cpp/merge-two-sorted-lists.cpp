#include <iostream>
struct ListNode {
	int val;
	ListNode *next;
	ListNode(int x) : val(x), next(NULL) {}
};
 
class Solution {
public:
    ListNode *mergeTwoLists(ListNode *l1, ListNode *l2) 
    {
    	ListNode* p1 = l1;
    	ListNode* p2 = l2;
    	ListNode* pCurrent = NULL;
    	ListNode* pHead = NULL;
    	ListNode* pNext = NULL;
    	while( p1 != NULL && p2 != NULL )
    	{
    		if( p1->val < p2->val )
    		{
    			pNext = p1;
    			p1 = p1 -> next;
    		}
    		else
    		{
    			pNext = p2;
    			p2 = p2 -> next;
    		}
    		if( pCurrent == NULL ) pHead = pCurrent = pNext;
			else
			{
				pCurrent->next = pNext;
				pCurrent = pCurrent->next;
			}
    	}
    	while( p1 != NULL )
    	{
    		if( pCurrent == NULL ) pHead = pCurrent = p1; 
    		else 
    		{
    			pCurrent-> next = p1;
    			pCurrent = pCurrent->next;
    		}


    		p1 = p1 -> next;
    	}
    	while( p2 != NULL )
    	{
    		if( pCurrent == NULL ) pHead = pCurrent = p2; 
    		else 
    		{
    			pCurrent-> next = p2;
    			pCurrent = pCurrent->next;
    		}
    		
    		p2 = p2 -> next;
    	}

        return pHead;
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
	ListNode* head2 = new ListNode(2);
	ListNode* p = head1;
	for (int i = 0; i < 10; ++i)
	{
		ListNode* node = new ListNode(i/3);
		p->next = node;
		p = p->next;
	}

	p = head2;
	for (int i = 4; i < 10; ++i)
	{
		ListNode* node = new ListNode(i/2);
		p->next = node;
		p = p->next;
	}

	printList(head1);
	printList(head2);

	Solution s;
	ListNode* result = s.mergeTwoLists(head1,NULL);
	printList(result);

	return 0;
}