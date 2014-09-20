#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    vector<vector<int> > permuteUnique(vector<int> &num) 
    {
        vector<vector<int> > v;
        if ( num.size() == 0 ) return v;
        sort(num.begin(),num.end());
        vector<int> parent;
        innerPermute(num,v,parent);
        return v;
    }
    void innerPermute(vector<int> &num, vector<vector<int> > &output,vector<int> &parent)
    {
        if ( num.size() == 1 )
        {
            parent.push_back(num[0]);
            output.push_back(parent);
            parent.pop_back();
            return;
        }
        int prevValue = 0;
    	for (int i = 0; i < num.size(); ++i)
        {
            if ( i != 0)
            {
                if ( prevValue == num[i] )
                {
                    continue;
                }
                 
            }
            
            int tmp = num[i];
            num.erase( num.begin() + i );
            parent.push_back(tmp);

            innerPermute(num,output,parent);

            parent.pop_back();
            num.insert( num.begin() + i,tmp);

            prevValue = num[i];
            

            //printf("%d\n",tmp );
        	//innerPermute();
        }
    }
};


void arr2vector(int value[], int len, vector<int> &v)
{
	for (int i = 0; i < len; ++i)
	{
		v.push_back(value[i]);
	}
}

void printVector2(vector<vector<int> > &v)
{
    char buffer[1024*10];
    memset( buffer,0,sizeof(char)*1024*10);
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
	int values[] = {1,2,3,3};
	vector<int> v;
	arr2vector(values,sizeof(values)/sizeof(int),v);

	Solution s;
	vector<vector<int> > result = s.permuteUnique(v);
	printVector2(result);
	return 0;
}