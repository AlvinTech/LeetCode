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
    	ListNode* pTmp = NULL;
        ListNode* keepNode = NULL;
        ListNode* pNewHead = NULL;
        bool canuse = false;
        //pTmp = toNext(p,&canuse);
        //printf("canuse:%d,p->val=%d,pTmp->val=%d\n", canuse,p->val,pTmp->val);

        //return NULL;

    	while( p != NULL )
    	{
    		pTmp = toNext(p,&canuse);
            //printf("canuse:%d,p->val=%d,%s \n", canuse,p->val,pTmp == NULL?"NULL":"not NULL");
            //return NULL;
            if ( canuse )
            {
                if ( keepNode == NULL )
                {
                    p->next = NULL;
                    keepNode = p;
                    pNewHead = keepNode;
                }
                else
                {
                    p->next = NULL;
                    keepNode->next = p;
                    keepNode = keepNode->next;
                }
                //keepNode->next = NULL;
            }
    		p = pTmp;
    	}
        return pNewHead;
    }
    ListNode* toNext(ListNode* node,bool* canuse)
    {
        bool isDuplicate = false;
        if (node->next == NULL )
        {
            *canuse = true;
            return NULL;
        }
        while( node-> next != NULL )
        {
            //printf("%d,%d\n",node->val, node->next->val);
            if ( node->val != node->next->val )
            {
                //printf("%d,%d\n",node->val, node->next->val);
                if ( isDuplicate == false )
                {
                    *canuse = true;
                    return node->next;
                } 
                else
                {
                    *canuse = false;
                    return node->next;
                }
            }
            else
            {
                *canuse = false;
                isDuplicate = true;
                node = node->next;
            }
        }
        return NULL;
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
	for (int i = 3; i < 5; ++i)
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