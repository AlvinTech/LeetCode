#include <iostream>
struct ListNode {
	int val;
	ListNode *next;
	ListNode(int x) : val(x), next(NULL) {}
};
 
class Solution {
public:
    ListNode *deleteDuplicates(ListNode *head) 
    {
    	ListNode* p = head;
    	ListNode* prev = NULL;
    	while( p != NULL )
    	{
    		if ( prev != NULL )
    		{
    			if ( prev->val == p->val )
    			{
    				prev->next = p->next;
    			}
    			else
    			{
    				prev = p;
    			}
    		}
    		else
    		{
    			prev = p;
    		}

    		
    		p = p->next;
    	}
        return head;
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
	ListNode* head = new ListNode(0);
	ListNode* p = head;
	for (int i = 0; i < 0; ++i)
	{
		ListNode* node = new ListNode(i/3);
		p->next = node;
		p = p->next;
	}
	printList(head);

	Solution s;
	head = s.deleteDuplicates(head);
	printList(head);
	return 0;
}