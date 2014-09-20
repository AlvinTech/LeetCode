#include <iostream>
#include <vector>
using namespace std;

struct Interval {
	int start;
	int end;
	Interval() : start(0), end(0) {}
	Interval(int s, int e) : start(s), end(e) {}
};

class Solution {
public:
    vector<Interval> insert(vector<Interval> &intervals, Interval newInterval) 
    {
        vector<Interval> result;
        bool isComplete = false;
        Interval* startInterval;
        for (int i = 0; i < intervals.size(); ++i)
        {
        	Interval tmp = intervals[i];
        	if( isComplete == false )
        	{
	        	//printf("%d,%d\n", tmp.start,tmp.end);
	        	if ( tmp.start > newInterval.end )
	        	{
	        		result.push_back(newInterval);
	        		isComplete = true;
	        	}
	        	if ( tmp.end < newInterval.start )
	        	{
	        		
	        	}
	        	if ( tmp.start < newInterval.start  )
	        	{
	        		if ( tmp.end > newInterval.end )
	        		{
	        			isComplete = true;
	        		}
	        		else
	        		{
	        			startInterval = &tmp;
	        		}
	        	}
	        	if ( tmp.end > newInterval.end && startInterval != NULL )
	        	{
	        		
	        		startInterval = NULL;
	        	}
        	}
        	result.push_back(tmp);
        	
        	/* code */
        }
        return result;
    }
};
void printVectorInterval(vector<Interval> &v)
{
	char buffer[1024];
	memset( buffer,0,sizeof(char)*1024 );
	for (int i = 0; i < v.size(); ++i)
	{
		sprintf(buffer,"%s,[%d,%d]",buffer,v[i].start,v[i].end);
	}
	printf("%s\n",buffer );
}
int main(int argc, char const *argv[])
{
	//Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9]
	vector<Interval> input;
	Interval value1(1,2);
	Interval value2(3,5);
	Interval value3(6,7);
	Interval value4(8,10);
	Interval value5(12,16);
	input.push_back(value1);
	input.push_back(value2);
	input.push_back(value3);
	input.push_back(value4);
	input.push_back(value5);

	Interval value6(4,9);
	printVectorInterval(input);
	Solution s;

	vector<Interval> output = s.insert(input,value6);
	printVectorInterval(output);

	return 0;
}
