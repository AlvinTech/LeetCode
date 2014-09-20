#include <iostream>
#include <vector>
using namespace std;
struct TreeNode {
	int val;
	TreeNode *left;
	TreeNode *right;
	TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};
struct Context
{
    TreeNode* prev;
    TreeNode* current;
    TreeNode* err1Prev;
    TreeNode* err1;
    TreeNode* err2;
    Context() : prev(NULL),current(NULL),err1Prev(NULL),err1(NULL),err2(NULL){}
};

class Solution {
public:
    void recoverTree(TreeNode *root) 
    {
        Context ctx;
        innerRecoverTree(root,&ctx);
        //printf("\n");
        if ( ctx.err1 != NULL && ctx.err2 == NULL )
        {
            //printf("1 swap:%d,%d\n",ctx.err1->val,ctx.err1Prev->val);
            swap(ctx.err1->val,ctx.err1Prev->val);
        }
        if ( ctx.err1 != NULL && ctx.err2 != NULL )
        {
            //printf("2 swap:%d,%d\n",ctx.err1Prev->val,ctx.err2->val);
            swap(ctx.err1Prev->val,ctx.err2->val);
        }
        //Context ctx2;
        //innerRecoverTree(root,&ctx2);
        //printf("\n");

    }
    void innerRecoverTree(TreeNode* node, Context* ctx)
    {
    	if ( node != NULL )
    	{
    		if ( node->left != NULL )
    		{
    			innerRecoverTree( node->left, ctx);
    		}
            if ( ctx-> current == NULL )
            {
                ctx-> current = node;
            }
            else
            {
                ctx-> prev = ctx->current;
                ctx-> current = node;
                //有问题
                if ( ctx->prev->val > node->val )
                {
                    if ( ctx->err1 == NULL )
                    {
                        ctx->err1Prev = ctx->prev;
                        ctx->err1 = node;
                    }
                    else
                    {
                        ctx->err2 = node;
                    }
                }
            }
            //printf("%d,",node->val );

    		if ( node->right != NULL )
    		{
    			innerRecoverTree( node->right, ctx);
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
	int value[] = {1};
	TreeNode* root = arr2tree(value,sizeof(value)/sizeof(int));

	Solution s;
	s.recoverTree(root);
	printf("\n");
	return 0;
}