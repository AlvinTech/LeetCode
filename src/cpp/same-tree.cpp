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
    bool isSameTree(TreeNode *p, TreeNode *q) 
    {
        return innerSameTree(p,q);
    }
    bool innerSameTree( TreeNode *p, TreeNode *q )
    {
    	if ( p != NULL && q != NULL )
    	{
    		if ( p->val != q->val ) return false;
    		bool left = innerSameTree(p->left,q->left);
    		if ( left == false ) return false;
    		bool right = innerSameTree(p->right,q->right);
    		if ( right == false ) return false;
    		return true;
    	}
    	else if( p == NULL && q == NULL ) return true;
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
	int value1[] = {1,2,3,4,5,6,7};
	TreeNode* root1 = arr2tree(value1,sizeof(value1)/sizeof(int));

	int value2[] = {1,2,3,4,5,7};
	TreeNode* root2 = arr2tree(value2,sizeof(value2)/sizeof(int));

	Solution s;
	bool result = s.isSameTree(root1,NULL);
	printf("%s\n",result?"true":"false" );

	/* code */
	return 0;
}