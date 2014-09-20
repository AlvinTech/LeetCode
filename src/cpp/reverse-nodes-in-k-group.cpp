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
    ListNode *reverseKGroup(ListNode *head, int k) 
    {
    	if ( head == NULL || k < 2 ) return head;
    	int tmp = 0;
    	ListNode newHead(0);
    	ListNode* ptr = head;
    	ListNode* prev = NULL;
    	ListNode* start = NULL;
    	ListNode* prevStart = NULL;
    	ListNode* next = NULL;
    	while( ptr != NULL )
    	{
    		next = ptr->next;
			if ( tmp == 0 )
			{
				if ( prevStart != NULL )
		    	{
		    		prevStart->next = prev;
		    		start->next = NULL;
		    	}

				prevStart = start;
				start = ptr;
			}
			if ( prev != NULL )
			{
				//
				//printf("%d,ptr->val:%d\n",prev->val ,ptr->val);
				ptr->next = prev;
			}

			tmp++;
			if ( tmp == k && newHead.next == NULL )
			{
				newHead.next = ptr;
			}
			tmp = tmp % k;
			prev = ptr;
    		ptr = next;
    	}
    	if ( prevStart != NULL )
    	{
    		if ( tmp != 0 )
    		{
    			prevStart->next = start;
    			start->next = NULL; 
    			reverse(prev);
    		}
    		else
    		{

    			prevStart->next = prev;
    			start->next = NULL;
    		}
    	}
    	else
    	{
    		start->next = NULL;
    		//printf("start %d,%d\n",prev->next == NULL,tmp );
    		if ( tmp != 0 )
			{
				reverse(prev);
				newHead.next = start;
			}
    		//printf("end %d,%d\n",prev->next == NULL ,prev->next->val);
    		
    	}

    	

    	//prev->next = NULL;
    	//if ( newHead.next == NULL ) newHead.next = start;
    	
        return newHead.next;
    }
	void reverse(ListNode* node)
    {
    	ListNode* ptr = node;
    	ListNode* prev = NULL;
    	ListNode* next = NULL;
    	while( ptr != NULL )
    	{
    		//printf("test->%d\n",ptr->val );
    		next= ptr->next;
    		if ( prev != NULL )
    		{
    			//prev->next = NULL;
    			//printf("%d->%d\n",ptr->val,prev->val );
    			ptr->next = prev;
    			
    		}
    		else
    		{
    			ptr->next = NULL;
    		}
    		prev = ptr;
    		ptr = next;
    	}

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
	ListNode* result = s.reverseKGroup(head1,4);
	printList(result);

	return 0;
}
