#include <iostream>
#include <set>
#include <vector>
#include <map>
#include <queue>
using namespace std;
#define unordered_set set
struct Node
{
    string name;
    std::vector<Node* > nexts;
    int val;
    bool visited;
    Node():val(INT_MAX),visited(false){ nexts.clear();  }
    
};
class Solution {
public:

    vector<vector<string> > findLadders(string start, string end, unordered_set<string> &dict) 
    {
        vector<vector<string> > result;

        map<string,Node*> nodes;
        Node nStart;
        nStart.name = start;

        Node nEnd;
        nEnd.name = end;
        nodes[start] = &nStart;
        for (std::unordered_set<string>::iterator i = dict.begin(); i != dict.end(); ++i)
        {
            Node* tmp = new Node();
            tmp->name = *i;
            nodes[*i] = tmp;
        }
        nodes[end] = &nEnd;
        dict.insert(end);
        dict.insert(start);


        nodes[start]->val = 1;
        innerSearch(nodes[start],dict,nodes);
        int minValue = nodes[start]->val == INT_MAX ? 0 : nodes[end]->val; 
        if ( minValue > 0 )
        {
            //printf("size:%ld\n", nodes[start]->nexts.size());
            vector<string> parent;
            parent.push_back(start);
            innerCreate(nodes[start],1,minValue,parent,result);
        }
        return result;


    }
    void innerCreate(Node* first, int deep, int size, vector<string> &parent,  vector<vector<string> > &result)
    {
        //printf("innerCreate:%d\n", deep);
        if ( deep == size )
        {
           result.push_back(parent);
        }
        else
        {
            if ( first != NULL )
            {
                for (int i = 0; i < first->nexts.size(); ++i)
                {
                    Node* tmp = first->nexts[i];
                    if ( tmp->val == first->val + 1 )
                    {
                        parent.push_back(tmp->name);
                        innerCreate(tmp,deep+1,size,parent,result);
                        parent.pop_back();
                    }
                }
            }
        }
        
    }


    void innerSearch(Node* first,unordered_set<string> &dict, map<string,Node*> &nodes )
    {
        queue<Node*> opened;
        addNeibo(first->name,first->val+1,first,opened,dict,nodes);
        while( !opened.empty() )
        {
            Node* todo = opened.front();
            opened.pop();
            addNeibo(todo->name,todo->val+1,todo,opened,dict,nodes);
        }

    }
    void addNeibo(string &a, int values, Node* parent, queue<Node*> &opened, unordered_set<string> &dict, map<string,Node*> &nodes  )
    {
        int size = a.size();
        for (int i = 0; i < size; ++i)
        {
            string tmp = a;
            char oc = tmp[i];
            for (char j = 'a'; j <= 'z' ; ++j)
            {
                if ( j != oc )
                {
                    tmp[i] = j;
                    if( dict.find(tmp) != dict.end() )
                    {
                        if ( values < nodes[tmp]->val   )
                        {
                            nodes[tmp]->val = values;
                            opened.push(nodes[tmp]);
                        }
                        parent->nexts.push_back(nodes[tmp]);
                    }
                }
            }
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
    set<string> dic;
    //string values[] = {"kid","tag","pup","ail","tun","woo","erg","luz","brr","gay","sip","kay","per","val","mes","ohs","now","boa","cet","pal","bar","die","war","hay","eco","pub","lob","rue","fry","lit","rex","jan","cot","bid","ali","pay","col","gum","ger","row","won","dan","rum","fad","tut","sag","yip","sui","ark","has","zip","fez","own","ump","dis","ads","max","jaw","out","btu","ana","gap","cry","led","abe","box","ore","pig","fie","toy","fat","cal","lie","noh","sew","ono","tam","flu","mgm","ply","awe","pry","tit","tie","yet","too","tax","jim","san","pan","map","ski","ova","wed","non","wac","nut","why","bye","lye","oct","old","fin","feb","chi","sap","owl","log","tod","dot","bow","fob","for","joe","ivy","fan","age","fax","hip","jib","mel","hus","sob","ifs","tab","ara","dab","jag","jar","arm","lot","tom","sax","tex","yum","pei","wen","wry","ire","irk","far","mew","wit","doe","gas","rte","ian","pot","ask","wag","hag","amy","nag","ron","soy","gin","don","tug","fay","vic","boo","nam","ave","buy","sop","but","orb","fen","paw","his","sub","bob","yea","oft","inn","rod","yam","pew","web","hod","hun","gyp","wei","wis","rob","gad","pie","mon","dog","bib","rub","ere","dig","era","cat","fox","bee","mod","day","apr","vie","nev","jam","pam","new","aye","ani","and","ibm","yap","can","pyx","tar","kin","fog","hum","pip","cup","dye","lyx","jog","nun","par","wan","fey","bus","oak","bad","ats","set","qom","vat","eat","pus","rev","axe","ion","six","ila","lao","mom","mas","pro","few","opt","poe","art","ash","oar","cap","lop","may","shy","rid","bat","sum","rim","fee","bmw","sky","maj","hue","thy","ava","rap","den","fla","auk","cox","ibo","hey","saw","vim","sec","ltd","you","its","tat","dew","eva","tog","ram","let","see","zit","maw","nix","ate","gig","rep","owe","ind","hog","eve","sam","zoo","any","dow","cod","bed","vet","ham","sis","hex","via","fir","nod","mao","aug","mum","hoe","bah","hal","keg","hew","zed","tow","gog","ass","dem","who","bet","gos","son","ear","spy","kit","boy","due","sen","oaf","mix","hep","fur","ada","bin","nil","mia","ewe","hit","fix","sad","rib","eye","hop","haw","wax","mid","tad","ken","wad","rye","pap","bog","gut","ito","woe","our","ado","sin","mad","ray","hon","roy","dip","hen","iva","lug","asp","hui","yak","bay","poi","yep","bun","try","lad","elm","nat","wyo","gym","dug","toe","dee","wig","sly","rip","geo","cog","pas","zen","odd","nan","lay","pod","fit","hem","joy","bum","rio","yon","dec","leg","put","sue","dim","pet","yaw","nub","bit","bur","sid","sun","oil","red","doc","moe","caw","eel","dix","cub","end","gem","off","yew","hug","pop","tub","sgt","lid","pun","ton","sol","din","yup","jab","pea","bug","gag","mil","jig","hub","low","did","tin","get","gte","sox","lei","mig","fig","lon","use","ban","flo","nov","jut","bag","mir","sty","lap","two","ins","con","ant","net","tux","ode","stu","mug","cad","nap","gun","fop","tot","sow","sal","sic","ted","wot","del","imp","cob","way","ann","tan","mci","job","wet","ism","err","him","all","pad","hah","hie","aim","ike","jed","ego","mac","baa","min","com","ill","was","cab","ago","ina","big","ilk","gal","tap","duh","ola","ran","lab","top","gob","hot","ora","tia","kip","han","met","hut","she","sac","fed","goo","tee","ell","not","act","gil","rut","ala","ape","rig","cid","god","duo","lin","aid","gel","awl","lag","elf","liz","ref","aha","fib","oho","tho","her","nor","ace","adz","fun","ned","coo","win","tao","coy","van","man","pit","guy","foe","hid","mai","sup","jay","hob","mow","jot","are","pol","arc","lax","aft","alb","len","air","pug","pox","vow","got","meg","zoe","amp","ale","bud","gee","pin","dun","pat","ten","mob"};
    string values[] = {"hot","dot","dog","lot","log"};
    dic.insert(values,values+sizeof(values)/sizeof(string));
    Solution s;
    vector<vector<string> > result = s.findLadders("hit","cog",dic);
    printVector2(result);
    //int result = s.ladderLength("cet","ism",dic);
    //printf("result = %d\n",result );
    return 0;
}
