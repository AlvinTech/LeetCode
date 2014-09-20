#include <iostream>
using namespace std;
class Solution {
public:
    bool isNumber(const char *s) 
    {
    	enum InputType {
              INVALID,    // 0
              SPACE,      // 1
              SIGN,       // 2
              DIGIT,      // 3
			  DOT,
			    EXPONENT,
			    NUM_INPUTS  // 6
			};
		const int transitionTable[][NUM_INPUTS] = {
		        -1, 0, 3, 1, 2, -1, // next states for state 0
		        -1, 8, -1, 1, 4, 5,
		        -1, -1, -1, 4, -1, -1,
		        -1, -1, -1, 1, 2, -1,
		        -1, 8, -1, 4, -1, 5,
		        -1, -1, 6, 7, -1, -1,
		        -1, -1, -1, 7, -1, -1,
		        -1, 8, -1, 7, -1, -1,
		        -1, 8, -1, -1, -1, -1,
		        };
		        int state = 0;
		for (; *s != '\0'; ++s) {
		    InputType inputType = INVALID;
		    if (isspace(*s))
		        inputType = SPACE;
		    else if (*s == '+' || *s == '-')
		        inputType = SIGN;
		    else if (isdigit(*s))
		        inputType = DIGIT;
		    else if (*s == '.')
		        inputType = DOT;
		    else if (*s == 'e' || *s == 'E')
		        inputType = EXPONENT;
		    // Get next state from current state and input symbol
		    state = transitionTable[state][inputType];
		    // Invalid input
		    if (state == -1) return false;
		}
		// If the current state belongs to one of the accepting (final) states,
		// then the number is valid
		return state == 1 || state == 4 || state == 7 || state == 8;
	}
};
int main(int argc, char const *argv[])
{
	Solution s;
	string strs[]={"0"," 0.1 ","abc","1 a","2e10"};
	int size = sizeof(strs)/sizeof(string);
	for (int i = 0; i < size; ++i)
	{
		printf("%s,[result=%s]\n",strs[i].c_str(), s.isNumber(strs[i].c_str()) == true ? "true":"false" );
	}

	return 0;
}