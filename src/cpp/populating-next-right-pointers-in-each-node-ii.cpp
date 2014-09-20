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
    		TreeLinkNode* tmp = NULL;
    		if ( node->left != NULL )
    		{
    			node->left->next = node->right;
    			tmp = node->left;
    		}
    		if ( node->right != NULL )
			{
				tmp = node->right;
			} 

			TreeLinkNode* pNode = node;

			if( tmp != NULL )
			{
				while( pNode->next != NULL )
				{
					//printf("node=%d->%d\n",node->val,pNode->next->val );
					if ( pNode->next->left != NULL ) tmp->next = pNode->next->left;
					else tmp->next = pNode->next->right;
					if( tmp->next != NULL )
						break;
					else
						pNode = pNode->next;
				}
			}
			innerConnect(node->right);
    		innerConnect(node->left);
    		
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
		TreeLinkNode* node = new TreeLinkNode(value[i]);
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
		//printf("%d,%d\n",node->val,deep );
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
	int value[] = {2,1,3,0,7,9,1,2,-1,1,0,-1,-1,8,8,-1,-1,-1,-1,7};
	TreeLinkNode* head = arr2tree(value,sizeof(value)/sizeof(int));

	//head->left->left->left->left = NULL;
	head->left->left->left->right = NULL;
	head->left->left->right = NULL;
	head->right->left->left = NULL;
	head->right->left->right = NULL;
	//Traversal(head,0);
	// head->right->left = NULL;
	// head->left->right = NULL; 
	// head->left->left->right = NULL;
	Solution s;
	s.connect(head);
	printNext(head);
	return 0;
}