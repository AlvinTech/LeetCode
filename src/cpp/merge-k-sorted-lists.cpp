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
	ListNode *mergeKLists(vector<ListNode *> &lists) 
	{
		if ( lists.size() == 0 ) return NULL;
		std::vector<ListNode *>* tmp = &lists;
		std::vector<ListNode *> nodes;
		do
		{
			ListNode* prev = NULL;
			for (std::vector<ListNode*>::iterator i = tmp->begin(); i != tmp->end(); ++i)
	    	{
	    		if ( (i - tmp->begin()) % 2 == 0 )
	    		{
	    			prev = *i;
	    		}
	    		else
	    		{
	    			ListNode* tmpResult = mergeTwoLists(prev,*i);
	    			nodes.push_back(tmpResult);
	    			prev = NULL;
	    		}
	    	}
	    	if ( prev != NULL ) nodes.push_back(prev);
	    	
	    	tmp->clear();
	    	while( !nodes.empty() )
	    	{
	    		tmp->push_back(nodes.back());
	    		nodes.pop_back();
	    	}
	    }
	    while( tmp->size() > 1);
		return (*tmp)[0];
    }
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

		sprintf(buffer,"%s,%d",buffer,node->val);
		node = node->next;
	}
	printf("%s\n", buffer);
}


int main(int argc, char const *argv[])
{

	ListNode* head1 = new ListNode(0);
	ListNode* head2 = new ListNode(2);
	ListNode* head3 = new ListNode(0);
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

	p = head3;
	for (int i = 0; i < 10; ++i)
	{
		ListNode* node = new ListNode(i/4);
		p->next = node;
		p = p->next;
	}

	printList(head1);
	printList(head2);
	printList(head3);

	std::vector<ListNode*> v;
	v.push_back(NULL);
	//v.push_back(head2);
	//v.push_back(head3);

	Solution s;
	ListNode* result = s.mergeKLists(v);
	printList(result);

	return 0;
}