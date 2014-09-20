#include <iostream>
#include <vector>
using namespace std;
struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    void flatten(TreeNode *root)
    {
    	std::vector<TreeNode*> v;
        innerFlatten(root,v);
        TreeNode* prev = NULL;
        for (std::vector<TreeNode*>::iterator i = v.begin(); i != v.end(); ++i)
        {
        	TreeNode* node = *i;
        	node->left = NULL;
        	if ( prev != NULL ) prev->right = node;
        	prev = node;
        }
    }
    void innerFlatten(TreeNode* node,std::vector<TreeNode*> &v)
    {
    	if ( node != NULL )
    	{
    		TreeNode* left = node->left;
    		TreeNode* right = node->right;
    		v.push_back(node);
    		if ( left != NULL  ) innerFlatten(left,v);
    		if ( right != NULL  ) innerFlatten(right,v);
    	}
    }
};


TreeNode* getParent(vector<TreeNode*> &v,int index)
{
	return v[(index - 1) >> 1];
}

TreeNode* arr2tree( int value[],int len )
{
	std::vector<TreeNode*> v;
	TreeNode* head = NULL;
	for (int i = 0; i < len; ++i)
	{
		TreeNode* node = new TreeNode(value[i]);
		v.push_back(node);	
		if ( head == NULL ) head = node;
		else
		{
			TreeNode* parent = getParent(v,i);
			if ( i % 2 == 1 ) parent->left = node;
			else parent->right = node;
		}
	}
	return head;
}

int main(int argc, char const *argv[])
{
	int value[] = {1,2,5,3,4,6,7};
	TreeNode* root = arr2tree(value,7);

	TreeNode* root2 = new TreeNode(1);
	root2->right = new TreeNode(2);
	Solution s;
	s.flatten(root2);

	while( root2 != NULL )
	{
		printf("%d,", root2->val );
		root2 = root2->right;
	}
	printf("\n");


	//printVector2(result);
	return 0;
}
