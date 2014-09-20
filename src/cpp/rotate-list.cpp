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
    ListNode *rotateRight(ListNode *head, int k) 
    {
        if ( head == NULL ) return head;
        if ( k == 0 ) return head;

        ListNode fakeHead(0);
        fakeHead.next = head;
        ListNode* fast = &fakeHead;
        ListNode* slow = &fakeHead;
        while( k > 0 )
        {
            fast = fast->next;
            k--;
            if ( fast == NULL ) fast = head;
        }
        //printf("%d,%d\n",k,fast == NULL);

        ListNode* prev1 = fast;
        ListNode* prev2 = slow;
        while( fast != NULL && slow != NULL )
        {
            prev1 = fast;
            prev2 = slow;
            fast = fast->next;
            slow = slow->next;
        }

        
        fakeHead.next =  slow;
        //printf("slow:%d,%d,%d,head=%d\n",slow->val,prev1->val,prev2->val,head->val);

        if ( prev1 != head )
        {
            prev1->next = head;
        }

        if ( slow == head )
        {
           prev1->next = NULL;
        }
       
        if ( prev2 != &fakeHead )
        {
            prev2->next = NULL;
        }

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
	int value1[] = {1,2};

	ListNode* head1 = arr2node(value1,sizeof(value1)/sizeof(int));


	Solution s;
	ListNode* result = s.rotateRight(head1,3);
	printList(result);

	return 0;
}