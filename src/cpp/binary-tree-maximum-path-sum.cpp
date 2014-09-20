#include <iostream>
#include <vector>
using namespace std;

struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL)
	{

	}
};
 
class Solution {
public:
    int maxPathSum(TreeNode *root) 
    {
    	int pMax = -9999999;
    	int max = innerFunc(root,&pMax);
        return max > pMax ? max : pMax ;
    }

    int innerFunc( TreeNode* root , int* pMax)
    {

    	int valuel = -9999999;
    	int valuer = -9999999;
    	if( root -> left != NULL )
    	{
    		valuel = innerFunc( root -> left ,pMax );
    	}
    	
    	if( root->right != NULL )
    	{
    		valuer = innerFunc( root -> right ,pMax );
    	}
    	int max = valuel > valuer ? valuel : valuer;
    	int min = valuel > valuer ? valuer : valuel;
    	int max_temp = max + min + root -> val;

    	max_temp = max > max_temp ? max:max_temp;
    	*pMax = *pMax > max_temp ? *pMax : max_temp;

    	if( max > 0 )
    	{
    		max = root->val + max;
    	}
    	else
    	{
    		max = root->val;
    	}

    	return max;
    }
};

int main(int argc, char const *argv[])
{
	TreeNode* root = new TreeNode(-3);
	TreeNode* right1 = new TreeNode(0);
	TreeNode* left1 = new TreeNode(-4);
	root -> right = right1;
	root -> left = left1;


	right1 -> left = new TreeNode(7);
	right1 -> right = new TreeNode(1);


	Solution s;
	int result = s.maxPathSum(root);
	printf("%d\n",result );

	free(root);
	
	return 0;
}