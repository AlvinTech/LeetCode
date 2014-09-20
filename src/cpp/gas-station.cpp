#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    int canCompleteCircuit(vector<int> &gas, vector<int> &cost) 
    {
    	int size = gas.size();
    	int totalGas = 0;
    	int totalCost = 0;
    	for (int i = 0; i < size; ++i)
    	{
    		totalGas += gas[i];
    		totalCost += cost[i];
    	}
    	if ( totalGas >= totalCost )
    	{
    		for (int i = 0; i < size; ++i)
    		{
    			int breakIndex = 0;
    			bool can = run(gas,cost,i,&breakIndex);
    			//printf("for %d,can:%s\n",i, can ? "true":"false");
    			if ( can ) return i;
    			else i = breakIndex;
    		}

    	}
    	return -1;

        
    }
    bool run(vector<int> &gas, vector<int> &cost, int startIndex, int* breakIndex)
    {
    	int size = gas.size();
    	int index = startIndex;
    	int totalCost = cost[index];
    	int totalGas = gas[index];
    	//printf("totalGas:%d,totalCost:%d\n",totalGas,totalCost );
    	while( totalGas >= totalCost )
    	{
    		index += 1;
    		index %= size;
    		if ( index == startIndex ) return true;
    		totalCost += cost[index];
    		totalGas += gas[index];
    	}
		*breakIndex = index ;
		*breakIndex = *breakIndex % size;
		return false;
    }
};

void arr2vector(int value[], int len, vector<int> &v)
{
	for (int i = 0; i < len; ++i)
	{
		v.push_back(value[i]);
	}
}

int main(int argc, char const *argv[])
{
	int values1[] = {1,2};
	vector<int> gas;
	arr2vector(values1,sizeof(values1)/sizeof(int),gas);

	int values2[] = {2,1};
	vector<int> cost;
	arr2vector(values2,sizeof(values2)/sizeof(int),cost);

	Solution s;
	int result = s.canCompleteCircuit(gas,cost);
	printf("result=%d\n",result );

	return 0;
}