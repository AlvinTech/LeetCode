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
    int sumNumbers(TreeNode *root) 
    {
        if ( root != NULL ) return innerSum( root , 0 );
        else return 0;    
    }
    int innerSum( TreeNode* node , int parent )
    {
        int valuea = 0 , valueb = 0;
        if( node->left == NULL && node->right == NULL ) 
            return parent*10 + node->val;

        if ( node->left != NULL ) valuea = innerSum(node->left, parent*10 + node->val);
        if ( node->right != NULL ) valueb = innerSum(node->right, parent*10 + node->val);
        //printf("%d,valuea=%d,valueb=%d,node->value=%d\n",parent,valuea , valueb,node->val );
        //valuea = valuea == 0 ? 0 : parent * 10 + valuea;
        //valueb = valueb == 0 ? 0 : parent * 10 + valueb;
        return  valuea + valueb;
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
	int value[] = {1,2,3,4,5,6};
	TreeNode* root = arr2tree(value,6);
	Solution s;
	int result = s.sumNumbers(root);

	printf("result=%d\n",result);
	return 0;
}