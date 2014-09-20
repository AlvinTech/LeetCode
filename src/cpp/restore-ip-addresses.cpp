#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    vector<string> restoreIpAddresses(string s) 
    {
    	std::vector<string> v;  
    	std::vector<string> tmp; 
    	innerFun(s,0,tmp,v); 
    	return v;
    }
    void innerFun(string &s, int deep, vector<string> &tmp , std::vector<string> &output)
    {
    	if ( deep == 3 )
    	{
    		if ( s.size() <= 3 )
    		{
    			if ( isIP(s) )
    			{
    				//printf("find it!@!!!\n");
    				string result;
    				for (int i = 0; i < tmp.size(); ++i)
    				{
    					result += tmp[i] + ".";
    				}
    				result += s;
    				output.push_back(result);
    				return;
    			}
    		}
    		else return;
    	}
    	for (int i = 3; i > 0; i--)
    	{
    		if ( s.size() < i ) continue;
    		string subLeft = s.substr(0,i);
    		if ( isIP(subLeft) )
    		{
    			string subRight = s.substr(i);
    			tmp.push_back(subLeft);
    			if ( subRight.size() > 0 )
    			{
    				//printf("%s,%s,deep=%d\n",subLeft.c_str(),subRight.c_str() ,deep);
    				innerFun(subRight,deep+1,tmp,output);
    			}
    			tmp.pop_back();
    			//
    		}
    	}
    }
    bool isIP(string &s)
    {
    	int value = atoi(s.c_str());
    	bool isGood = false;
    	if ( s.size() == 3 && value >= 100 ) isGood = true;
    	else if( s.size() == 2 && value < 100 && value >= 10 ) isGood = true;
    	else if( s.size() == 1 && value < 10 ) isGood = true;
    	else isGood = false;
    	if ( isGood ) return  (value >= 0 && value <= 255) ? true : false;
    	else return false;
    	
    }
};
void printVector1(vector<string> &v)
{
	char buffer[1024];
	memset( buffer,0,sizeof(char)*1024 );
	for (int i = 0; i < v.size(); ++i)
	{
		sprintf(buffer,"%s\t%s",buffer,v[i].c_str());
	}
	printf("%s\n",buffer );
}

int main(int argc, char const *argv[])
{
	Solution s;
	vector<string> result = s.restoreIpAddresses("010010");
	printVector1(result);
	return 0;
}