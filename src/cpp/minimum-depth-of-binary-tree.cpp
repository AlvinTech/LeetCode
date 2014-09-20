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
    int minDepth(TreeNode *root) 
    {
    	if ( root == NULL ) return 0;
        return innerMinDepth(root,1);
    }
    int innerMinDepth(TreeNode *node, int deep)
    {
    	if( node != NULL )
    	{
    		if ( node ->left == NULL && node ->right == NULL ) return deep;
    		int min1 = INT_MAX, min2 = INT_MAX;
    		if ( node->left != NULL ) min1 = innerMinDepth(node->left,deep+1);
    		if ( node->right != NULL ) min2 = innerMinDepth(node->right,deep+1);
    		return min1 < min2 ? min1 : min2;
    	}
    	return deep;
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

	Solution s;
	int result = s.minDepth(root);

	printf("%d\n",result);


	//printVector2(result);
	return 0;
}

