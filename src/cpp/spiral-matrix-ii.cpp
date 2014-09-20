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
    vector<vector<int> > generateMatrix(int n) 
    {

        vector<vector<int> > matrix;
        if ( n == 0 ) return matrix;
        for (int i = 0; i < n*n; ++i)
        {
            if ( i % n == 0 )
            {
                vector<int> v;
                matrix.push_back(v);
            }
            matrix[i/n].push_back(0);
        }

        Context ctx;
        ctx.xmin = 0;
        ctx.xmax = matrix[0].size();
        ctx.ymin = 0;
        ctx.ymax = matrix.size();
        ctx.x = 0;
        ctx.y = 0;
        ctx.direction = 0;
        int index = 1;
        do while( run(matrix,index,&ctx) ){ index++; }
        while( turn(&ctx) != -1 );


        return matrix;
    }
    bool run(vector<vector<int> > &matrix, int value,Context* ctx)
    {
    	int result = canrun( ctx );
    	//printf("x=%d,y=%d,d=%d,run=%d\n",ctx->x,ctx->y,ctx->direction,result );
    	if ( result == -1 ) return false;
        matrix[ctx->y][ctx->x] = value;
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
	Solution s;
	vector<vector<int> > result = s.generateMatrix(0);
	printVector2(result);
	return 0;
}