#include <iostream>
#include <vector>
using namespace std;
struct LinkedList
{
	int a;
};
struct Context
{
	int xmin;
	int xmax;
	int ymin;
	int ymax;
	int x;
	int y;
	int direction;// 0右 1下 2左 2上
};
class Solution {
public:
    vector<int> spiralOrder(vector<vector<int> > &matrix) 
    {
    	std::vector<int> v;
    	if (matrix.size() == 0) return v;

    	Context ctx;
    	ctx.xmin = 0;
    	ctx.xmax = matrix[0].size();
    	ctx.ymin = 0;
    	ctx.ymax = matrix.size();
    	ctx.x = 0;
    	ctx.y = 0;
    	ctx.direction = 0;

    	do while( run(matrix,v,&ctx) );
    	while( turn(&ctx) != -1 );
    	return v;
    }
    bool run(vector<vector<int> > &matrix, vector<int> &output,Context* ctx)
    {
    	int result = canrun( ctx );
    	//printf("x=%d,y=%d,d=%d,run=%d\n",ctx->x,ctx->y,ctx->direction,result );
    	if ( result == -1 ) return false;
    	output.push_back(matrix[ctx->y][ctx->x]);
    	switch( ctx -> direction )
    	{
    		case 0:
    			(ctx->x)++;
	    		break;
    		case 1:
    			(ctx->y)++;
    			break;
    		case 2:
    			(ctx->x)--;
    			break;
    		case 3:
    			(ctx->y)--;
    			break;
    	}
    	return true;
    }
    int turn(Context* ctx)
    {
    	int prev = ctx->direction;
    	ctx->direction = (ctx->direction + 1) % 4;
		switch( prev )
    	{
    		case 0:
	    		//(ctx->xmax)--;
	    		(ctx->ymin)++;
	    		ctx->x--;
	    		ctx->y++;
	    		break;
    		case 1:
    			//(ctx->ymax)--;
    			(ctx->xmax)--;
    			ctx->y--;
    			ctx->x--;
    			break;
    		case 2:
    			//(ctx->xmin)++;
    			(ctx->ymax)--;
    			ctx->x++;
    			ctx->y--;
    			break;
    		case 3:
    			//(ctx->ymin)++;
    			(ctx->xmin)++;
    			ctx->y++;
    			ctx->x++;
    			break;
    	}

    	int result = canrun(ctx);
    	//printf("turn=%d,d=%d,x=%d,xmax=%d\n", result,ctx->direction ,ctx->x,ctx->xmax);
    	return result;
    }
    int canrun(Context* ctx)
    {
    	int result = -1;
    	switch( ctx -> direction )
    	{
    		case 0:
	    		result = ctx->x < ctx->xmax ? 0 : -1;
	    		break;
    		case 1:
    			result = ctx->y < ctx->ymax ? 0 : -1;
    			break;
    		case 2:
    			result = ctx->x >= ctx->xmin ? 0 : -1;
    			break;
    		case 3:
    			result = ctx->y >= ctx->ymin ? 0 : -1;
    			break;
    	}
    	return result;
    }
};
void printVector(vector<int> &v)
{
	char buffer[1024];
	memset( buffer,0,sizeof(char)*1024 );
	for (int i = 0; i < v.size(); ++i)
	{
		sprintf(buffer,"%s,%d",buffer,v[i]);
	}
	printf("%s\n",buffer );
}
int main(int argc, char const *argv[])
{
	vector<vector<int> > matrix;
	for (int i = 1; i < 10; ++i)
	{
		if ( i % 3 == 1 )
		{
			//为什么用指针方式无法实现
			vector<int> v;
			matrix.push_back(v);
		}
		matrix[(i-1)/3].push_back(i);
		//printf("%ld,%ld\n", matrix[0].size(),v->size());
	}
	//matrix[0]
	Solution s;
	vector<int> result = s.spiralOrder(matrix);
	printVector(result);
	return 0;
}