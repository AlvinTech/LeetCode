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
    vector<vector<int> > zigzagLevelOrder(TreeNode *root) {
        vector<vector<int> > out; 
        if (root == NULL) return out;
        innerLevelOrderBottom(root,0,out);
        // vector<vector<int> > tmp;
        // for (int i = out.size() - 1; i >= 0; i-- )
        // {
        //     tmp.push_back(out[i]);
        // }
        return out; 
    }

    void innerLevelOrderBottom(TreeNode* node , int deep , vector<vector<int> > &out)
    {
    	while(   out.size()  < deep+1   )
    	{
			vector<int> *v = new vector<int>();
    		out.push_back(*v);
    	}
    	
    	if ( node != NULL )
    	{
    		if ( node->left != NULL ) innerLevelOrderBottom(node->left,deep+1,out);
    		if ( node->right != NULL ) innerLevelOrderBottom(node->right,deep+1,out);
            if ( deep % 2 == 0 )
            {
                out[deep].push_back(node->val);
            }
            else
            {
                out[deep].insert(out[deep].begin(),node->val);
            }
    		
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
	int value[] = {1,2,3,4,5,6,7};
	TreeNode* root = arr2tree(value,7);
	Solution s;
	vector<vector<int> > result = s.zigzagLevelOrder(root);

	printf("result size=%ld\n", result.size());
	printVector2(result);
	return 0;
}