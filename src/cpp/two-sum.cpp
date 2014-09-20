#include <iostream>
#include <vector>
#include <map>
using namespace std;

class Solution {
public:
    vector<int> twoSum(vector<int> &num, int target) 
    {
        vector<int> v;
        if ( num.size() < 2 ) return v;

        map<int,vector<int> > dic;
        for (int i = 0; i < num.size(); ++i)
        {
            dic[num[i]].push_back(i+1);
        }
        vector<int> tmp = num;
        sort(tmp.begin(),tmp.end());
        
        int start = 0;
        int end = tmp.size()-1;
        int sum = 0;
        while( start < end )
        {
            //printf("%d,%d\n",start,end );
            sum =  tmp[start] + tmp[end];
            if ( sum < target )
            {
                start++;
            }
            else if( sum > target )
            {
                end--;
            }
            else
            {
                int a = dic[tmp[start]].back();
                dic[tmp[start]].pop_back();
                int b = dic[tmp[end]].back();
                dic[tmp[end]].pop_back();
                if ( a > b )
                {
                   int tmp = a;
                   a = b;
                   b = tmp;
                }
                v.push_back(a);
                v.push_back(b);
                break;
            }
        }
        return v;
    }
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

void arr2vector(int value[], int len, vector<int> &v)
{
	for (int i = 0; i < len; ++i)
	{
		v.push_back(value[i]);
	}
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
	int values1[] = {0,4,3,0};
	vector<int> v1;
	arr2vector(values1,sizeof(values1)/sizeof(int),v1);
	Solution s;
	vector<int> result = s.twoSum(v1,0);
    printVector1(result);

    map<int,vector<int> > dic;
    //printf("%ld\n", dic[3].size() );

	//printf("%d\n",result );
	return 0;
}