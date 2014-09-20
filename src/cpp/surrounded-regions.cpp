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
    void solve(vector<vector<char> > &matrix) 
    {
    	if ( matrix.size() == 0 ) return;
    	int width = matrix[0].size();
    	int height = matrix.size();
    	vector<vector<bool> > values;
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
    			if ( values[i][j] == false && matrix[i][j] == 'O' )
    			{
    				Context ctx(j,i);
                    inarea(j,i,values,matrix,&ctx);
                    char tmpValue;
                    if ( ctx.xmin == 0 || ctx.xmax == width-1 ||  ctx.ymin == 0 || ctx.ymax == height-1 )
                        tmpValue = 'O';
                    else
                        tmpValue = 'X';
                    for (int ii = 0; ii < height; ++ii)
                    {
                        for (int jj = 0; jj < width; ++jj)
                        {
                            if ( matrix[ii][jj] == 'S' ) matrix[ii][jj] = tmpValue;
                        }
                    }
                    //(ctx.xmax - ctx.xmin + 1) * (ctx.ymax - ctx.ymin + 1);
    			}
    		}
    	}
    		
    }
    void inarea(int x,int y, vector<vector<bool> > &values, vector<vector<char> > &matrix ,Context* ctx)
    {
    	int width = matrix[0].size();
    	int height = matrix.size();
    	if ( x >= 0 && x<width && y>=0 && y<height && values[y][x] == false && 
            ( matrix[y][x] == 'O' || matrix[y][x] == 'S') )
    	{
    		values[y][x] = true;
            matrix[y][x] = 'S';
    		ctx->xmin = ctx->xmin < x ? ctx->xmin : x;
    		ctx->xmax = ctx->xmax > x ? ctx->xmax : x;
    		ctx->ymin = ctx->ymin < y ? ctx->ymin : y;
    		ctx->ymax = ctx->ymax > y ? ctx->ymax : y;

            inarea(x-1,y,values,matrix,ctx);
            inarea(x,y-1,values,matrix,ctx);
            inarea(x+1,y,values,matrix,ctx);
            inarea(x,y+1,values,matrix,ctx);
    	}
    }
};

void printVector2(vector<vector<char> > &v)
{
    char buffer[1024];
    memset( buffer,0,sizeof(char)*1024 );
    for (int i = 0; i < v.size(); ++i)
    {
        for (int j = 0; j < v[i].size(); ++j)
        {
            sprintf(buffer,"%s,%c",buffer,v[i][j]);
        }
        sprintf(buffer,"%s\n",buffer);
    }
    printf("%s\n",buffer );
}

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
        matrix[i/n].push_back('X');
    }
    matrix[0][0] = 'X';
    matrix[0][1] = 'X';
    matrix[0][2] = 'O';
    matrix[1][2] = 'O';
    matrix[2][2] = 'O';
    matrix[2][3] = 'O';
    //matrix[2][1] = 'O';

    printVector2(matrix);
	Solution s;
    s.solve(matrix);
    printVector2(matrix);
	return 0;
}