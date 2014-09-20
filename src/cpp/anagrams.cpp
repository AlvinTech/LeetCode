#include <iostream>
#include <vector>
#include <map>
using namespace std;

// 首先简单介绍一下Anagram（回文构词法）。Anagrams是指由颠倒字母顺序组成的单词，
// 比如“dormitory”颠倒字母顺序会变成“dirty room”，“tea”会变成“eat”。
// 回文构词法有一个特点：单词里的字母的种类和数目没有改变，只是改变了字母的排列顺序。

// For example:
// Input:　　["tea","and","ate","eat","den"]
// Output:   ["tea","ate","eat"]




class Solution {
public:
    vector<string> anagrams(vector<string> &strs) {
        vector<string> result;
        map<string, vector<string>::iterator> anagram;
        string tmp;
        vector<string>::iterator null;
        for (std::vector<string>::iterator i = strs.begin(); i != strs.end(); ++i)
        {
        	tmp = *i;
        	sort(tmp.begin(),tmp.end());
        	if( anagram.find(tmp) == anagram.end() )
        	{
        		//不在map中
        		anagram[tmp] = i;
        	}
        	else
        	{
        		//在map中
        		result.push_back(*i);
        		if ( anagram[tmp] !=  null )
        		{
        			result.push_back( *anagram[tmp]);
        			anagram[tmp] = null;
        			/* code */
        		}
        	}
        }
        return result;
    }
    bool isAnagrams(string &s)
    {
    	const char* chars = s.c_str();
    	int len = s.size();
    	if (len <= 1) return false;
    	char data[len+1];
    	for (int i = 0; i < len; ++i)
    	{
    		data[len-i-1] = chars[i];
    	}
    	data[len] = '\0';
    	bool isEqual = true;
    	for (int i = 0; i < len; ++i)
    	{
    		/* code */
    		if( data[i] != chars[i] )
    		{
    			isEqual = false;
    			break;
    		}
    	}
    	return isEqual;
    }
};
int main(int argc, char const *argv[])
{
	std::vector<string> v;
	v.push_back("abc");
	v.push_back("acb");
	Solution s;
	v = s.anagrams(v);

	char buffer[1024*10];
	memset(buffer,0,sizeof(char) * 1024 * 10);
	for (std::vector<string>::iterator i = v.begin(); i != v.end(); ++i)
	{
		sprintf(buffer,"%s,%s",buffer,(*i).c_str());
	}
	printf("%s\n",buffer );


	string str = "aba";
	printf("%d\n",s.isAnagrams(str) );
	return 0;
}