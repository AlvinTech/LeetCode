#include <iostream>
#include <map>
using namespace std;

class Solution {
public:
    string intToRoman(int num) 
    {
        map<int,char> dic;
        dic[1] = 'I';
        dic[5] = 'V';
        dic[10] = 'X';
        dic[50] = 'L';
        dic[100] = 'C';
        dic[500] = 'D';
        dic[1000] = 'M';
        int start = 1000;
        string result;
        while( start != 0 )
        {
            int tmp = num / start;
            //printf("tmp=%d\n",tmp );
            if ( tmp != 0 )
            {
                result += innerIntToRoman(tmp,start,dic);
            }
            num = num % start;
            start = start / 10;
        }
        return result;    
    }
    string innerIntToRoman(int num,int rate, map<int,char> &dic )
    {
        string result;
        int value = num * rate;
        if ( num <= 3 )
        {
            while(num > 0 )
            {
                result += dic[rate * 1];
                num--;
            }
        }
        else if( num == 4 )
        {
            result += dic[rate * 1];
            result += dic[rate * 5];
        }
        else if( num == 5 )
        {
            result += dic[rate * 5];
        }
        else if( num <= 8 )
        {
            result += dic[rate * 5];
            while(num > 5 )
            {
                result += dic[rate * 1];
                num--;
            }
        }
        else if( num == 9 )
        {
            result += dic[rate * 1];
            result += dic[rate * 10];
        }
        //printf("%d,%d,result=%s\n",value,rate,result.c_str() );
        return result;
    }
};
int main(int argc, char const *argv[])
{
	Solution s;
	//int result = s.romanToInt("MDCCCLXXXVIII");
    string roman = s.intToRoman();
	printf("%s\n",roman.c_str() );
	return 0;
}