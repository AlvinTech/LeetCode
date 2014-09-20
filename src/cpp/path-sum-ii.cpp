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
    vector<vector<int> > pathSum(TreeNode *root, int sum) 
    {
        vector<vector<int> > result;
        if ( root == NULL ) return result;
        vector<int> tmp;
        innerPathSum(root,sum,0,result,tmp);
        return result;

    }
    bool innerPathSum(TreeNode *root, int sum, int parentValue, vector<vector<int> > &result, vector<int> parent )
    {
    	//if ( sum < parentValue ) return false;
    	bool valuea = false ,valueb = false;
    	std::vector<int> tmp = parent;
    	tmp.push_back(root->val);
    	if ( root->left != NULL ) 
    		valuea = innerPathSum( root->left, sum, parentValue + root->val,result,tmp);
    	if ( root->right != NULL ) 
    		valueb = innerPathSum( root->right, sum, parentValue + root->val,result,tmp);
    	if ( root->left == NULL && root->right == NULL )
    	{
    		//printf("leaf %d \n",  parentValue + root->val );
    		if ( parentValue + root->val == sum ) result.push_back(tmp);
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

void printVector2(vector<vector<int> > &v)
{
    char buffer[1024];
    memset( buffer,0,sizeof(char)*1024 );
    for (int i = 0; i < v.size(); ++i)
    {
        for (int j = 0; j < v[i].size(); ++j)
        {
            sprintf(buffer,"%s,%d",buffer,v[i][j]);
        }
        sprintf(buffer,"%s\n",buffer);
    }
    printf("%s\n",buffer );
}

int main(int argc, char const *argv[])
{
	int value[] = {-2,-1,-3,-5,-4,-2,-2};
	TreeNode* root = arr2tree(value,7);
	Solution s;
	vector<vector<int> > result = s.pathSum(root,-7);
	printVector2(result);

	//printf("result size=%s\n", result == true ? "true" : "false" );
	//printVector2(result);
	return 0;
}
