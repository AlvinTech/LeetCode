#include <iostream>
#include <vector>
#include <map>
using namespace std;

class Solution {
public:
    vector<string> letterCombinations(string digits) 
    {
        map<char,string> dic;
        dic['2'] = "abc";
        dic['3'] = "def";
        dic['4'] = "ghi";
        dic['5'] = "jkl";
        dic['6'] = "mno";
        dic['7'] = "pqrs";
        dic['8'] = "tuv";
        dic['9'] = "wxyz";
        string parent;
        vector<string> output;

        innerLetter(0,digits,parent,output,dic);
        return output;
    }
    void innerLetter(int deep, string &digits, string &parent,vector<string> &output,map<char,string> &dic)
    {
    	if ( deep == digits.size() )
    	{
    		output.push_back(parent);
    		return;
    	}
    	else
    	{
    		char target = digits[deep];
    		if ( dic.find(target) != dic.end() )
    		{
    			string word = dic[target];
    			for (int i = 0; i < word.size(); ++i)
    			{
    				parent.push_back(word[i]);
    				innerLetter(deep+1,digits,parent,output,dic);
    				parent.erase(parent.end()-1);
    			}
    		}
    		else
    		{
    			innerLetter(deep+1,digits,parent,output,dic);
    		}
    	}
    }
};
void printVector1(vector<string> &v)
{
	char buffer[1024];
	memset( buffer,0,sizeof(char)*1024 );
	for (int i = 0; i < v.size(); ++i)
	{
		sprintf(buffer,"%s,%s",buffer,v[i].c_str());
	}
	printf("%s\n",buffer );
}

int main(int argc, char const *argv[])
{
	
	Solution s;
	vector<string> result = s.letterCombinations("213");
	printVector1(result);
	return 0;
}