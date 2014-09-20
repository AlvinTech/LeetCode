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
    bool hasPathSum(TreeNode *root, int sum) 
    {
    	if ( root == NULL ) return false;
        return innerHasPathSum(root,sum,0);
    }
    bool innerHasPathSum(TreeNode *root, int sum, int parentValue)
    {
    	//if ( sum < parentValue ) return false;
    	bool valuea = false ,valueb = false;
    	if ( root->left != NULL ) valuea = innerHasPathSum( root->left, sum, parentValue + root->val);
    	if ( root->right != NULL ) valueb = innerHasPathSum( root->right, sum, parentValue + root->val);
    	if ( root->left == NULL && root->right == NULL )
    	{
    		//printf("leaf %d \n",  parentValue + root->val );
    		if ( parentValue + root->val == sum ) return true;
    		else return false;
    	}
    	return ( valuea || valueb );
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
	//alloc(sizeof(int));

	//int *p = (int *)alloca(sizeof(int)*10);

	

	int value[] = {-2,-1,-3};
	TreeNode* root = arr2tree(value,3);
	Solution s;
	bool result = s.hasPathSum(root,-5);

	printf("result size=%s\n", result == true ? "true" : "false" );
	//printVector2(result);
	return 0;
}
