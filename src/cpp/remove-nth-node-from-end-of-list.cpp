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
    ListNode *removeNthFromEnd(ListNode *head, int n) 
    {
    	ListNode fakeHead(0);
    	fakeHead.next = head;
    	ListNode* fast = &fakeHead;
    	ListNode* slow = &fakeHead;
    	while( n >= 0 )
    	{
    		fast = fast->next;
    		n--;
    	}
    	while( fast != NULL )
    	{
    		fast = fast->next;
    		slow = slow->next;
    	}
    	slow->next = slow->next->next;
        return fakeHead.next;
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
	ListNode* p = head1;
	for (int i = 1; i < 10; ++i)
	{
		ListNode* node = new ListNode(i);
		p->next = node;
		p = p->next;
	}

	printList(head1);

	Solution s;
	ListNode* node  = s.removeNthFromEnd(head1,6);
	printList(node);

	return 0;
}
