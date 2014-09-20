#include <iostream>
#include <vector>
using namespace std;


struct TreeLinkNode {
	int val;
	TreeLinkNode *left, *right, *next;
	TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
};
 
class Solution {
public:
    void connect(TreeLinkNode *root) 
    {
        innerConnect(root);
    }
    void innerConnect(TreeLinkNode *node )
    {
    	if ( node != NULL )
    	{
    		if ( node->left != NULL ) node->left->next = node->right;
    		if ( node->right != NULL && node->next != NULL ) node->right->next = node->next->left;
    		innerConnect(node->left);
    		innerConnect(node->right);
    	}
    }

};
TreeLinkNode* getParent(vector<TreeLinkNode*> &v,int index)
{
	return v[(index - 1) >> 1];
}
TreeLinkNode* arr2tree( int value[],int len )
{
	std::vector<TreeLinkNode*> v;
	TreeLinkNode* head = NULL;
	for (int i = 0; i < len; ++i)
	{
		TreeLinkNode* node = new TreeLinkNode(i+1);
		v.push_back(node);	
		if ( head == NULL ) head = node;
		else
		{
			TreeLinkNode* parent = getParent(v,i);
			if ( i % 2 == 1 ) parent->left = node;
			else parent->right = node;
		}
	}
	return head;
}
void Traversal( TreeLinkNode* node , int deep )
{
	if ( node != NULL )
	{
		printf("%d,%d\n",node->val,deep );
		Traversal(node->left,deep+1);
		Traversal(node->right,deep+1);
		/* code */
	}
}
void printNext( TreeLinkNode* head )
{
	while( head != NULL )
	{
		TreeLinkNode* start = head;
		while( start!= NULL )
		{
			printf("%d,", start->val );
			start = start -> next;
		}
		printf("\n");
		head = head->left;
	}
}
int main(int argc, char const *argv[])
{
	int value[] = {1,2,3,4,5,6,7};
	TreeLinkNode* head = arr2tree(value,7);
	Traversal(head,0);
	Solution s;
	s.connect(head);
	printNext(head);
	return 0;
}