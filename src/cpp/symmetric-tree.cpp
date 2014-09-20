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
    bool isSymmetric(TreeNode *root)
    {
    	if ( root == NULL ) return true;
    	if ( root->left != NULL && root->right != NULL )
    		return innerSymmetric(root->left,root->right);
    	else if( root->left == NULL && root->right == NULL ) return true;
    	else return false;
        //return innerSymmetric(root,root);
    }
    bool innerSymmetric( TreeNode* root1,TreeNode* root2 )
    {
    	if ( root1 != NULL && root2 != NULL )
    	{
    		if ( root1->val != root2->val ) return false;
    		bool left = innerSymmetric(root1->left,root2->right);
    		//printf("left:%s,%d,%d\n",left?"true":"false",root1->val,root2->val  );
    		if ( left == false ) return false;
    		bool right = innerSymmetric(root1->right,root2->left);
    		//printf("right:%s,%d,%d\n",right?"true":"false",root1->val,root2->val );
    		if ( right == false ) return false;
    		return true;
    	}
    	else if( root1 == NULL && root2 == NULL ) return true;
    	else return false;
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
	int value1[] = {1};
	TreeNode* root1 = arr2tree(value1,sizeof(value1)/sizeof(int));


	Solution s;
	bool result = s.isSymmetric(root1);
	printf("%s\n",result?"true":"false" );

	/* code */
	return 0;
}