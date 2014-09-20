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
    ListNode *partition(ListNode *head, int x) 
    {
    	ListNode headLeft(0);
    	ListNode headRight(0);
    	ListNode* pLeft = &headLeft;
    	ListNode* pRight = &headRight;
		ListNode* ptr = head;
		while( ptr != NULL )
		{
			if ( ptr->val < x )
			{
				pLeft->next = ptr;
				pLeft = pLeft->next;
			}
			else
			{
				pRight->next = ptr;
				pRight = pRight->next;
			}
			ptr = ptr->next;
		}
		if ( pLeft != NULL )
		{
			pLeft->next = headRight.next;
		}

		if ( pRight != NULL ) pRight->next = NULL;
		if ( pLeft == &headLeft ) return headRight.next;
		else return headLeft.next;
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

int main(int argc, char const *argv[])
{
	int value1[] = {1,4,3,2,5,2};

	ListNode* head1 = arr2node(value1,sizeof(value1)/sizeof(int));



	Solution s;
	ListNode* result = s.partition(head1,1);
	printList(result);

	return 0;
}