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
    int maxDepth(TreeNode *root) 
    {
    	if ( root == NULL ) return 0;
        return innerMaxDeep(root,1);
    }
    int innerMaxDeep(TreeNode* node, int deep)
    {
    	int max = deep,valuea = deep,valueb = deep;
    	if ( node != NULL )
    	{
    		if ( node->left != NULL ) valuea = innerMaxDeep(node->left,deep+1);
    		if ( node->right != NULL ) valueb = innerMaxDeep(node->right,deep+1);
    		deep = valuea > valueb ? valuea :valueb;
    		/* code */
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
		TreeNode* node = new TreeNode(i+1);
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
	int value[] = {1,2,3,4,5,6,7};
	TreeNode* root = arr2tree(value,7);
	Solution s;
	int result = s.maxDepth(root);

	printf("result size=%d\n", result );
	//printVector2(result);
	return 0;
}
