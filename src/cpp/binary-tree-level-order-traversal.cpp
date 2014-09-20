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
    vector<vector<int> > levelOrder(TreeNode *root) 
    {
        vector<vector<int> > output;
        innerLevelOrder(root,0,output);
        return output;
    }
    void innerLevelOrder(TreeNode *root,int deep,vector<vector<int> > &output)
    {
    	if ( root != NULL )
    	{
    		if ( deep >= output.size())
    		{
    			vector<int> tmp;
    			output.push_back(tmp);
    		}
    		output[deep].push_back(root->val);

    		if ( root->left != NULL ) innerLevelOrder(root->left,deep+1,output);
    		if ( root->right != NULL ) innerLevelOrder(root->right,deep+1,output);
    	}
    }
};

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

	//int value2[] = {1,2,3,4,5,7};
	//TreeNode* root2 = arr2tree(value2,sizeof(value2)/sizeof(int));

	Solution s;
	vector<vector<int> > result = s.levelOrder(root1);
	//printf("%s\n",result?"true":"false" );
	printVector2(result);
	/* code */
	return 0;
}