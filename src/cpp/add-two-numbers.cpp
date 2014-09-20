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
    ListNode *addTwoNumbers(ListNode *l1, ListNode *l2) 
    {
    	ListNode head(0);
    	ListNode* ptr = &head;
    	int next = 0;
    	while( l1 != NULL && l2 != NULL )
    	{
    		int value = l1->val + l2->val + next;
    		int tmp = value/10;
    		ListNode* node = new ListNode(value%10);
    		ptr->next = node;
    		ptr = ptr->next;
    		l1 = l1->next;
    		l2 = l2->next;
    		next = tmp;
    	}
    	while( l1 != NULL )
    	{
    		int value = l1->val + next;
    		int tmp = value/10;

    		ListNode* node = new ListNode(value%10);
    		ptr->next = node;
    		ptr = ptr->next;
    		l1 = l1->next;
    		next = tmp;
    	}
    	while( l2 != NULL )
    	{
    		int value = l2->val + next;
    		int tmp = value/10;

    		ListNode* node = new ListNode(value%10);
    		ptr->next = node;
    		ptr = ptr->next;
    		l2 = l2->next;
    		next = tmp;
    	}
    	if (next != 0 )
    	{
    		ListNode* node = new ListNode(1);
    		ptr->next = node;
    		ptr = ptr->next;
    	}
        return head.next;
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
	int value1[] = {2,4,3};
	int value2[] = {5,6,4};

	ListNode* head1 = arr2node(value1,sizeof(value1)/sizeof(int));
	ListNode* head2 = arr2node(value2,sizeof(value2)/sizeof(int));


	Solution s;
	ListNode* result = s.addTwoNumbers(head1,head2);
	printList(result);

	return 0;
}