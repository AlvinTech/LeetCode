#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    int maxProfit(vector<int> &prices) 
    {
    	if ( prices.size() < 2 ) return 0;
    	int max = prices[1] - prices[0];
        int min_prize = prices[0];
    	for (int i = 1; i < prices.size() ; ++i)
    	{
            max = max > prices[i] - min_prize ?  max : prices[i] - min_prize;
    		min_prize = prices[i] < min_prize ? prices[i] : min_prize;
    	}

        return max < 0 ? 0 : max;
    }
};

int main(int argc, char const *argv[])
{
	std::vector<int> v;
    //2,1,2,1,0,1,2

	v.push_back(8);
	v.push_back(7);
    v.push_back(6);
    // v.push_back(1);
    // v.push_back(0);
    // v.push_back(1);
    // v.push_back(2);
	Solution s;
	int result = s.maxProfit(v);
	printf("%d\n", result);
	return 0;
}