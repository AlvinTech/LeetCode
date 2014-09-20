#include <iostream>
#include <vector>
using namespace std;

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


class Solution {
public:
    string getPermutation(int n, int k) 
    {
        string parent;
        int th = 0;
        vector<int> values;
        vector<int> values2;
        int tmp = 1;
        for (int i = 0; i < n; ++i)
        {
        	values.push_back(i+1);
        	tmp *= (i+1);
        	values2.push_back(tmp);
        }
        int left = k;
        for (int i = 0; i < n; ++i)
        {
        	int index = findK(values2,&left,i);
        	int tmpValue = values[index];
        	parent.push_back(tmpValue + '0');
        	values.erase(values.begin()+index);
        }
        return parent;
    }

    int findK(vector<int> &values2,int* left, int index)
    {
    	int total = values2[values2.size() - 1 - index];
    	int pervalue = total / (values2.size() - index);
    	int result = 0;

    	//printf("total:%d,prevalue:%d\n",total,pervalue );
    	while( *left > pervalue )
    	{
    		result++;
    		*left -= pervalue;
    	}
    	return result;
    }

    void innerFun(int deep, int n ,int* th, int k, string &parent, vector<int> &values)
    {
    	if ( *th == k ) return;
    	if ( deep == n )
    	{
    		//printf("%s\n", parent.c_str());
    		(*th)++;
    		return;
    	}
    	else
    	{
    		for (int i = 0; i < values.size(); ++i)
    		{

    			int tmp = values[i];

    			parent.push_back( (tmp + '0') );
    			values.erase(values.begin() + i );
    			innerFun(deep+1,n,th,k,parent,values);
    			values.insert(values.begin() + i ,tmp);
    			if ( *th == k ) return;
    			parent.erase(parent.end()-1);
    		}
    	}
    }
};
int main(int argc, char const *argv[])
{
	Solution s;
	string result = s.getPermutation(1,1);
	printf("%s\n", result.c_str());
	return 0;
}