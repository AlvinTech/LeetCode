#include <iostream>
#include <vector>
using namespace std;
struct ListNode {
	int val;
	ListNode *next;
	ListNode(int x) : val(x), next(NULL) {}
};
struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    TreeNode *sortedListToBST(ListNode *head) 
    {
    	int size = 0;
    	ListNode* ptr = head;
    	while( ptr != NULL )
    	{
    		size++;
    		ptr = ptr->next;
    	}
        TreeNode* root = createTree(size);

        ptr = head;
        setValue(root,&ptr);

        return root;
    }
    void setValue(TreeNode* node , ListNode** ptr )
    {
    	if ( node != NULL )
    	{
    		if ( node-> left != NULL ) setValue(node->left,ptr);
    		ListNode* pTmp = *ptr;
    		node->val = pTmp->val;
    		*ptr = pTmp->next;
    		if ( node-> right != NULL ) setValue(node->right,ptr);
    	}
    }
    TreeNode *createTree(int len)
    {
    	if ( len > 0 )
    	{
    		TreeNode* root = new TreeNode(0);
    		root->left = createTree(len>>1);
			root->right = createTree((len-1)>>1);
    		return root;
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
	int value1[] = {1,2,3,4,5,6};

	ListNode* head1 = arr2node(value1,sizeof(value1)/sizeof(int));



	Solution s;
	TreeNode* result = s.sortedListToBST(head1);
	//printList(result);

	return 0;
}

