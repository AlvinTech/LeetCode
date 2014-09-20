#include <iostream>
#include <set>
#include <vector>

using namespace std;
class Solution
{
public:
    std::set<int> flags_;
    int longestConsecutive(std::vector<int> &num)
    {
        for(int i = 0; i < num.size(); ++i)
        {
            flags_.insert(num[i]);
        }
            
        int maxLen = 0;
        
        for(int i = 0; i < num.size(); ++i)
        {
            int ascendingMax = FindConsecutiveNumbers(ASCENDING, num[i]);
            int decendingMax = FindConsecutiveNumbers(DECENDING, num[i] - 1);
            
            
            if(ascendingMax + decendingMax > maxLen)
            {
                maxLen = ascendingMax + decendingMax;
            }
        }
        
        return maxLen;
    }
    
private:
    enum OrderBy
    {
        ASCENDING,
        DECENDING
    };
    
    int FindConsecutiveNumbers(OrderBy orderBy, int value)
    {
        int maxLen = 0;
        
        while(flags_.find(value) != flags_.end())
        {
            ++maxLen;
            
            flags_.erase(value);
            
            if(orderBy == ASCENDING)
            {
                ++value;
            }
            else
            {
                --value;
            }        
        }
        
        return maxLen;
    }
};
int main(int argc, char const *argv[])
{
    /* code */
    return 0;
}

