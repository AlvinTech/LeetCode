#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    vector<string> fullJustify(vector<string> &words, int L) 
    {
    	int size = 0;
    	int realSize = 0;
    	int index = 0;
    	int max = words.size();
    	vector<string> tmps;
    	vector<string> result;
    	vector<string> result2;
    	//return result2;
    	while( index < max )
    	{
    		string word = words[index];
    		if ( word.size() > L ) return result2;
    		if ( size + word.size() <= L )
    		{
    			tmps.push_back(word);
    			realSize = realSize + word.size();
    			size = size + word.size() + 1;
    		}
    		else
    		{
    			format(L,tmps,realSize,result);
    			size = 0;
    			realSize = 0;
    			tmps.clear();
    			continue;
    		}

    		index++;
    	}

    	if ( !tmps.empty() )
		{
			string ss;

			for (int i = 0; i < tmps.size(); ++i)
			{
				if ( i != tmps.size() - 1)
				{
					ss += tmps[i] + ' ';
				}
				else
				{
					ss += tmps[i];
				}
			}

			int left = L - ss.size();
			string space(left,' ');
			result.push_back(ss+space);
		}
        return result;
    }
    void format(int L,vector<string> &tmps ,int realSize, vector<string> &output)
    {
    	int dur = L - realSize;
		int tmpSize = tmps.size()-1;
		int minSpace = 0;
		int left = 0;
		if ( tmpSize != 0 )
		{
			minSpace  = dur / tmpSize;
			left = dur % tmpSize;
		}

		string ss;
		for (int i = 0; i < tmps.size(); ++i)
		{
			string space;
			if ( i < left )
			{
				string a(minSpace+1,' ');
				space = a;
			}
			else if( i != tmps.size() - 1 )
			{
				string a(minSpace,' ');
				space = a;
			}
			ss += tmps[i] + space;
		}
		left = L - ss.size();
		string space(left,' ');
		output.push_back(ss+space);
    }
};

void printVector1(vector<string> &v)
{
	char buffer[1024];
	memset( buffer,0,sizeof(char)*1024 );
	for (int i = 0; i < v.size(); ++i)
	{
		sprintf(buffer,"%s%s\n",buffer,v[i].c_str());
	}
	printf("%s\n",buffer );
}

void arr2vector(string value[], int len, vector<string> &v)
{
	for (int i = 0; i < len; ++i)
	{
		v.push_back(value[i]);
	}
}


int main(int argc, char const *argv[])
{
	string values[] = {"What","must","be","shall","beaaa."};
	vector<string> intput;
	arr2vector(values,sizeof(values)/sizeof(string),intput);

	Solution s;
	vector<string> result = s.fullJustify(intput,12);
	printVector1(result);

	//vector<string>
	return 0;
}