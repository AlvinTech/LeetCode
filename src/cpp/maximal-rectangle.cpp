#include <iostream>
#include <vector>
using namespace std;
struct Context
{
	int xmin;
	int ymin;
	int xmax;
	int ymax;
	Context(int x,int y):xmin(x),ymin(y),xmax(x),ymax(y){}
};
class Solution {
public:
    int maximalRectangle(vector<vector<char> > &matrix) 
    {
    	if ( matrix.size() == 0 ) return 0;
    	int width = matrix[0].size();
    	int height = matrix.size();
    	vector<vector<bool> > values;
    	int max = 0;
    	for (int i = 0; i < height; ++i)
    	{
    		std::vector<bool> tmp;
    		for (int j = 0; j < width; ++j) tmp.push_back(false);
    		values.push_back(tmp);
    	}

    	for (int i = 0; i < matrix.size(); ++i)
    	{
    		for (int j = 0; j < matrix[i].size(); ++j)
    		{
    			if ( values[i][j] == false && matrix[i][j] == '1' )
    			{
    				Context ctx(j,i);
					inarea(j,i,values,matrix,&ctx);
					int area = (ctx.xmax - ctx.xmin + 1) * (ctx.ymax - ctx.ymin + 1);
    				max = max > area ? max : area;
    			}
    		}
    	}
    		
    	return max;   
    }
    void inarea(int x,int y, vector<vector<bool> > &values, vector<vector<char> > &matrix ,Context* ctx)
    {
    	int width = matrix[0].size();
    	int height = matrix.size();
    	if ( x >= 0 && x<width && y>=0 && y<height && values[y][x] == false && matrix[y][x] == '1' )
    	{
    		values[y][x] = true;
    		ctx->xmin = ctx->xmin < x ? ctx->xmin : x;
    		ctx->xmax = ctx->xmax > x ? ctx->xmax : x;
    		ctx->ymin = ctx->ymin < y ? ctx->ymin : y;
    		ctx->ymax = ctx->ymax > y ? ctx->ymax : y;
    		inarea(x-1,y,values,matrix,ctx);
    		inarea(x,y-1,values,matrix,ctx);
    		inarea(x+1,y,values,matrix,ctx);
    		inarea(x,y+1,values,matrix,ctx);
    	}
    	else
    	{
    		return;
    	}
    }
};

int main(int argc, char const *argv[])
{
	int n = 4;
	vector<vector<char> > matrix;
	for (int i = 0; i < n*n; ++i)
    {
        if ( i % n == 0 )
        {
            vector<char> v;
            matrix.push_back(v);
        }
        matrix[i/n].push_back('0');
    }
    matrix[0][0] = '1';
    matrix[0][1] = '1';
    matrix[0][2] = '1';
    matrix[1][2] = '1';

    matrix[3][3] = '1';

	Solution s;
	int result = s.maximalRectangle(matrix);
	printf("%d\n",result );
	return 0;
}