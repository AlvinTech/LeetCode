#include <iostream>
#include <string>
#include <vector>
#include <map>
using namespace std;

void printVector2(vector<vector<int> > &v)
{
    char buffer[1024*10];
    memset( buffer,0,sizeof(char)*1024*10 );
    for (int i = 0; i < v.size(); ++i)
    {
        for (int j = 0; j < v[i].size(); ++j)
        {
            sprintf(buffer,"%s,%d",buffer,v[i][j]);
        }
        sprintf(buffer,"%s\n",buffer);
    }
    printf("%s\n",buffer );
}


class Solution {
public:
    string longestPalindrome(string s) 
    {
        if (isPalindrome(s)) return s;
    	string tmp = s;
    	reverse(tmp.begin(),tmp.end());
        return  maxsub2(s,tmp);
    }
    bool isPalindrome(string s)
    {
        int begin = 0;
        int end = s.size() - 1;
        while( begin < end ) 
            if ( s[begin++] != s[end--] ) return false;
        return true;
    }

    string maxsub2(string s1,string s2)
    {
        if ( s1 == s2 ) return s1;
        int size = s1.size();
        int values[size][size];
        memset(&values,0,sizeof(int)*size*size);
        //printf("%ld\n",values.size() );
        //string values[10][10];
        //int maxSize = 0;
        //int endIndex = 0;

        string result;


        for (int i = 0; i < size; ++i)
        {
            for (int j = 0; j < size; ++j)
            {

                if ( s1[i] == s2[j] )
                {
                    if ( i > 0 && j > 0 )
                    {
                        values[i][j] = values[i-1][j-1] + 1;
                        int currentSize = values[i][j];
                        int tmaxSize = values[i][j];
                        int tendIndex = i;
                        string ttmp = s1.substr(tendIndex-tmaxSize+1,tmaxSize);
                        if ( ttmp.size() > result.size() &&  isPalindrome(ttmp) )
                        {
                            result = ttmp;
                        }
                    }
                    else
                    {
                        values[i][j] = 1;
                    }
                   
                }
                else
                {
                    values[i][j] = 0;
                }
            }
            /* code */
        }
        //printVector2(values);
        //printf("endIndex:%d,maxSize:%d\n",endIndex,maxSize );
        // = s1.substr(endIndex-maxSize+1,maxSize);
        return result;
    }


};
int main(int argc, char const *argv[])
{
	Solution s;
	string str = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabcaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
	string result = s.longestPalindrome(str);
    //printf("%s\n", str.c_str());
	printf("%s\n", result.c_str());
	return 0;
}