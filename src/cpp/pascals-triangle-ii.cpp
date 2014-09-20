#include <iostream>
#include <vector>
using namespace std;

void printList( vector<int> &list )
{
	char buffer[1024*10];
	memset(buffer,0,sizeof(char) * 1024 * 10);
	for (int i = 0; i < list.size(); ++i)
	{
		
		sprintf(buffer,"%s,%d",buffer,list[i]);
	}
	
	printf("%s\n", buffer);
}


class Solution {
public:
    vector<int> getRow(int rowIndex) 
    {
    	vector<int> v;
    	int tmp = 1;
    	for (int i = 0; i <= rowIndex; ++i)
    	{
    		v.push_back(1);
    	}
    	for (int i = 1; i <= rowIndex; ++i)
    	{
    		
    		int mid = ((i)>>1)+1 ;
    		//printf("mid:%d,len:%d\n",mid ,i+1);

    		for (int j = 1; j <= i; ++j)
    		{
    			//printf("%d,%d,tmp=%d\n",j,mid,tmp );
    			if ( j < mid )
    			{
    				int prev = v[j];
    				v[j] = tmp + v[j];
    				tmp = prev;
    			}
    			else
    			{
    				v[j] = v[i - j];
    			}
    			
    		}
    		tmp = 1;
    		//printList(v);
    		//printf("\n");
    	}
       
        return v;
    }
   
    //int getValue(vector<int>)
};


int main(int argc, char const *argv[])
{
	Solution s;
	std::vector<int> v =  s.getRow(4);
	printList(v);

	printf("%ld\n", sizeof(long*));
	return 0;
}	