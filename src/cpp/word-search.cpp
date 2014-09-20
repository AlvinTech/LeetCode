#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    bool exist(vector<vector<char> > &board, string word) 
    {
    	if (word.size() == 0) return true;
    	char target = word[0];
    	for (int i = 0; i < board.size(); ++i)
    	{
    		for (int j = 0; j < board[i].size(); ++j)
    		{
    			if ( board[i][j] == target )
    			{
    				board[i][j] = '\0';
    				bool tmp = search(board,word,1,j,i);
    				board[i][j] = target;
    				if ( tmp ) return true;
    			}
    		}
    	}
        return false;
    }
    bool search(vector<vector<char> > &board, string word, int deep ,int prevx ,int prevy)
    {
    	if ( deep == word.size() ) return true;
    	char toFind = word[deep];
    	char src;
    	int tryx = 0;
    	int tryy = 0;

    	int index = 0;
    	while(index < 4)
    	{
    		switch( index )
    		{
    			case 0:tryx = prevx + 1; tryy = prevy; break;
    			case 1:tryx = prevx - 1; tryy = prevy; break;
    			case 2:tryx = prevx; tryy = prevy-1; break;
    			case 3:tryx = prevx; tryy = prevy+1; break;
    		}

    		if ( inarea(tryx,tryy,board) )
	    	{
	    		src = board[tryy][tryx];
	    		if ( src != '\0' && src == toFind )
	    		{
	    			board[tryy][tryx] = '\0';
	    			bool tmp = search(board,word,deep+1,tryx,tryy);
	    			board[tryy][tryx] = src;
	    			if ( tmp ) return true;
	    		}
	    	}
	    	index++;
    	}
    	return false;
    	
    }
    bool inarea(int x,int y,vector<vector<char> > &board)
    {
    	if ( y < board.size() && y >= 0 && x >=0 && x < board[y].size() )
    		return true;
    	else return false;
    }
};
void arr2vector(char value[], int len, vector<char> &v)
{
	for (int i = 0; i < len; ++i)
	{
		v.push_back(value[i]);
	}
}


int main(int argc, char const *argv[])
{
	char a[] = {'A','B','C','E'};
	vector<char> v1;
	arr2vector(a,sizeof(a)/sizeof(char),v1);

	char b[] = {'S','F','C','S'};
	vector<char> v2;
	arr2vector(b,sizeof(b)/sizeof(char),v2);

	char c[] = {'A','D','E','E'};
	vector<char> v3;
	arr2vector(c,sizeof(b)/sizeof(char),v3);


	vector<vector<char> > board;
	board.push_back(v1);
	board.push_back(v2);
	board.push_back(v3);
	string word="SEE";

	Solution s;
	bool result = s.exist(board,word);
	printf("%s\n",result ? "true" : "false" );
	return 0;
}