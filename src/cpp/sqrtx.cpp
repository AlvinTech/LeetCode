#include "iostream"
class Solution {
public:
    int sqrt(int x) 
    {
        if( x < 0 ) return 0;
        if ( x == 1) return 1;
        int start = 0;
        int end = x;
        int mid = start;
        while( start < end )
        {
            mid = ((end-start)>>1) + start;
            
            double tmp = mid/(double)x*mid;

            //tmp = tmp < 0 ? x : tmp;
            //printf("start=%d,mid=%d,end=%d,%lf\n",start,mid,end,tmp );
            if ( tmp > 1 )
            {
                //printf("tmp > x\n");
                if( end != mid ) end = mid;
                else break;
                
            }
            else if( tmp < 1 )
            {
                //printf("tmp < x\n");
                if( start != mid ) start = mid;
                else break;
            }
            else
            {
                return mid;
            }
        }
       
        return start;
    }
};
int main(int argc, char const *argv[])
{
	Solution s;
	int result = s.sqrt(3);
	printf("%d\n", result);
	return 0;
}