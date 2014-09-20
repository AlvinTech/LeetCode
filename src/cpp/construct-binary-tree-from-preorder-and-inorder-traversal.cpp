#include <iostream>
#include <vector>
using namespace std;
struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

void printVector1(vector<int> &v)
{
	char buffer[1024];
	memset( buffer,0,sizeof(char)*1024 );
	for (int i = 0; i < v.size(); ++i)
	{
		sprintf(buffer,"%s,%d",buffer,v[i]);
	}
	printf("%s\n",buffer );
}

// struct Context
// {
// 	int start1;
// 	int end1;
// 	int start2;
// 	int end2;
// 	Context():start1(0),end1(0),start2(0),end2(0){}
// };
class Solution 
{
public:
    TreeNode *buildTree( vector<int> &preorder , vector<int> &inorder ) 
    {
    	if (inorder.size() == 0 && preorder.size() == 0) return NULL;
    	int debug = 0;
		TreeNode* root =  innerBuildTree(inorder,preorder,0,inorder.size()-1,0,preorder.size()-1,&debug);

		return root;

    }
    TreeNode *innerBuildTree(vector<int> &inorder,vector<int> &preorder,int astart,int aend,int bstart,int bend ,int* debug) 
    {
        TreeNode* node = NULL;
        (*debug)++;
        int root = getRoot(preorder,bstart);
	    int leftsize = findRoot(root,inorder);

        if ( astart <= aend &&  bstart<= bend )
        {
        	node = new TreeNode(root);

        	int leftLen = leftsize - astart;
        	int rightLen = aend - leftsize;

	        int start1 = astart;
	        int end1 = astart + leftLen - 1;
	        int start2 = bstart + 1;
	        int end2 = start2 + leftLen - 1;
	        if ( start1 <= end1 && start2 <= end2  )
	        	node->left = innerBuildTree(inorder,preorder,start1,end1,start2,end2,debug);
	        
	        start1 = leftsize + 1;
	        end1 = aend;

	        start2 = bstart+leftLen + 1;
	        end2 = start2 + rightLen ;

	        if ( start1 <= end1 && start2 <= end2  )
	        	node->right = innerBuildTree(inorder,preorder,start1,end1,start2,end2,debug);
	    }
		return node;
    }

    int getRoot(vector<int> &preorder,int start)
    {
    	int root = preorder[start];
    	return root;
    }
    //return size of left
    int findRoot( int root, vector<int> &inorder)
    {
    	int index = 0;
    	while( index < inorder.size() )
    	{
    		if ( inorder[index] == root ) break;
    		index++;
    	}
    	return index;
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
void postorder( TreeNode* node, vector<int> &v )
{
	if ( node != NULL )
	{
		if ( node->left != NULL ) postorder(node->left,v);
		if ( node->right != NULL ) postorder(node->right,v);
		v.push_back(node->val);
	}
}
void inorder( TreeNode* node, vector<int> &v )
{
	if ( node != NULL )
	{
		if ( node->left != NULL ) inorder(node->left,v);
		v.push_back(node->val);
		if ( node->right != NULL ) inorder(node->right,v);
		
	}
}

void prevorder( TreeNode* node, vector<int> &v )
{
	if ( node != NULL )
	{
		v.push_back(node->val);
		if ( node->left != NULL ) prevorder(node->left,v);
		if ( node->right != NULL ) prevorder(node->right,v);
		
	}
}



int main(int argc, char const *argv[])
{
	int value[] = {1,2,3,4,5,6,7};
	TreeNode* root = arr2tree(value,sizeof(value)/sizeof(int));

	vector<int> v1;
	vector<int> v2;
	vector<int> v3;

	inorder(root,v1);
	postorder(root,v2);
	prevorder(root,v3);

	//printVector1(v1);
	//printVector1(v2);
	//printVector1(v3);
	Solution s;

	vector<int> v4;
	TreeNode* newRoot = s.buildTree(v3,v1);
	//printf("%d\n", newRoot->val);
	postorder(newRoot,v4);
	printVector1(v4);


	
	return 0;
}