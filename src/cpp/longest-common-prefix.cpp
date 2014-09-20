#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    string longestCommonPrefix(vector<string> &strs) 
    {
		string result;
		if ( strs.size() == 0 ) return result;
		int index = 0;
		char target;
		while( true )
		{
			if ( index < strs[0].size()) target = strs[0][index];
			else break;

			bool isOk = true;
			for (int i = 1; i < strs.size(); ++i)
			{
				if (  index < strs[i].size() )
				{
					char tmp = strs[i][index];
					if ( tmp != target )
					{
						isOk = false;
						break;
					}
				}
				else
				{
					isOk = false;
					break;
				}
				
			}
			if ( isOk )
			{
				result.push_back(target);
				index++;
			}
			else
			{
				break;
			}
		}
		return result;
    }
};
void arr2vector(string value[], int len, vector<string> &v)
{
	for (int i = 0; i < len; ++i)
	{
		v.push_back(value[i]);
	}
}

int main(int argc, char const *argv[])
{
	string values[] = {"profile"};
	vector<string> strs;

	arr2vector(values,sizeof(values)/sizeof(string),strs);
	Solution s;
	string result = s.longestCommonPrefix(strs);
	printf("%s\n", result.c_str());

	return 0;
}