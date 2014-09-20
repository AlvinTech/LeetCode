#include <iostream>
#include <map>
using namespace std;
/***
For example,
Given:
s1 = "aabcc",
s2 = "dbbca",
When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
*/
class Solution {
public:
    bool isInterleave(string s1, string s2, string s3) 
    {
    	if ( s3.size() == 0 ) return true;
    	if ( s3.size() != s1.size() + s2.size()) return false;
    	map<string,bool> dic;
    	//char tmp = s1[100];
        return innerIsInterleave(s1,s2,s3,dic);
        //return false;
    }
    bool innerIsInterleave(string s1, string s2, string s3,map<string,bool> &dic)
    {
    	//printf("%s,%s,%s\n",s3.c_str(),s1.c_str(),s2.c_str() );
    	if ( s3.size() == 0 ) return true;
    	int a = 0; int b = 0;
    	int index = 0;
    	bool result = false;
    	string key = s1+","+s2+","+s3;
    	if ( dic.find(key) != dic.end() )
    	{
    		result = dic[key];
    	}
    	else
    	{
    		for (int i = 0; i < s3.size(); ++i)
	    	{
	    		index++;
	    		char tmp = s3[i];
	    		//printf("s3[%d]=%c,s1[%d]=%c,s2[%d]=%c\n",i,s3[i],a,s1[a],b,s2[b]);
	    		if ( tmp == s1[a] &&  tmp == s2[b] )
	    		{
	    			result = innerIsInterleave(s1.substr(a+1),s2.substr(b),s3.substr(i+1),dic);
	    			if( result == true ) break;
	    			result = innerIsInterleave(s1.substr(a),s2.substr(b+1),s3.substr(i+1),dic);
	    			break;
	    		}
	    		else if( tmp == s1[a] ) a++;
	    		else if( tmp == s2[b] ) b++;
	    		else
	    		{
	    			result = false;
	    			break;
	    		}
	    	}
	    	//printf("a=%d,b=%d,%ld\n",a,b,s3.size() );
	    	if ( a + b == s3.size() )
	    	{
	    		result = true;
	    	}
	    	dic[key] = result;
    	}
    	return result;
    }
};
int main(int argc, char const *argv[])
{
	Solution s;
	//string s1 = "bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa";
	//string s2 = "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab";
	//string s3 = "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab";
	
	//string s1 = "aabcc";
	//string s2 = "dbbca";
	//string s3 = "aadbbcbcac";

	string s1 = "a";
	string s2 = "b";
	string s3 = "a";
	
	//string s4 = "aadbbbaccc";
	bool result1 = s.isInterleave(s1,s2,s3);
	bool result2 = false;//s.isInterleave("abbbbbbcabbacaacccababaabcccabcacbcaabbbacccaaaaaababbbacbb","ccaacabbacaccacababbbbabbcacccacccccaabaababacbbacabbbbabc",s4);
	printf("%s\n",result1 == true ? "true" : "false");
	return 0;
}