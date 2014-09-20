#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    vector<int> plusOne(vector<int> &digits) {
    	int next = 1;
    	for (int i = digits.size() - 1 ; i >= 0 && next == 1 ; i-- )
    	{
			if( digits[i] == 9 )
			{
				digits[i] = 0;
				next = 1;
			}
			else
			{
				digits[i] = digits[i] + 1;
				next = 0;
				break;
			}
    	}
    	if ( next == 1)
    	{
    		digits.insert(digits.begin(),1);
    	}

        return digits;
    }
};
void printList( vector<int> &list )
{
	char buffer[1024*10];
	memset(buffer,0,sizeof(char) * 1024 * 10);
	for (int i = 0; i < list.size(); ++i)
	{
		
		sprintf(buffer,"%s%d",buffer,list[i]);
	}
	
	printf("%s\n", buffer);
}

int main(int argc, char const *argv[])
{
	vector<int> digits;
	//digits.push_back(1);
	//digits.push_back(9);
	//digits.push_back(9);
	Solution s;
	vector<int> result = s.plusOne( digits);
	printList(result);
	return 0;
}