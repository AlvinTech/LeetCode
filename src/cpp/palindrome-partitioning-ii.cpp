#include <iostream>
#include <vector>
#include <map>
using namespace std;
class Solution {
public:
    /*
    int minCut(string s) 
    {
        if ( s.size() == 0 ) return 0;
        int cut = INT_MAX;
        map<string,int> dic;
        innerPartition(s,0,&cut,dic);
        return cut;
    }*/
        
    int innerPartition(string s, int deep,int* cut,map<string,int> &dic)
    {
        if ( deep > *cut )
        {
           return INT_MAX;
        }
    	int size = s.size();
    	if ( size == 0 ) return INT_MAX;
    	int start = 0;
        int min = INT_MAX;
        if( dic.find(s) != dic.end() )
        {
            min = dic[s] + deep;
            *cut = *cut < min ? *cut : min;
            return dic[s] + deep;
        }
        else
        {
            while( start < size && deep < *cut )
            {
                string current = s.substr(0,start+1);
                
                if ( isPalindrome(current,dic) )
                {
                    string sub = s.substr(start+1);
                    if ( sub.size() == 0 )
                    {
                        *cut = *cut < deep ? *cut : deep;
                        return deep;

                    }
                    else
                    {
                        int result = innerPartition(sub,deep+1,cut,dic);
                        min = min < result ? min :result;
                    }
                }
                start++;
            }
            dic[s] = min - deep;
            return min;
        }
    	
        //printf("%s,min=%d\n",s.c_str(),min );
        //return min;
    }
    bool isPalindrome(string s,map<string,int> &dic)
    {
        if ( dic.find(s) != dic.end() )
        {
            return true;
        }
        else
        {
            int begin = 0;
            int end = s.size() - 1;
            while( begin < end ) 
                if ( s[begin++] != s[end--] ) return false;
            return true;
        }
    	
    }
};
void printVector2(vector<vector<string> > &v)
{
    char buffer[1024];
    memset( buffer,0,sizeof(char)*1024 );
    for (int i = 0; i < v.size(); ++i)
    {
        for (int j = 0; j < v[i].size(); ++j)
        {
            sprintf(buffer,"%s,%s",buffer,v[i][j].c_str());
        }
        sprintf(buffer,"%s\n",buffer);
    }
    printf("%s\n",buffer );
}


int main(int argc, char const *argv[])
{
    // vector<vector<int> > ary(row_num, vector<int>(col_num, 0));
	string input = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
	Solution s;
    int result = 0;
	result = s.minCut(input);
    printf("%d\n",result );
	return 0;
}