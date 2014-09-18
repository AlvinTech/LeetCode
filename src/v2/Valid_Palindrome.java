/**  Valid Palindrome
 Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.
 */
public class Valid_Palindrome {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0)
            return true;
        else{
            int i=0;
            int j = s.length()-1;
            while(!isAlphanumeric(s.charAt(i))){
                i++;
                if(i == s.length() )
                    return true;
            }

            while(!isAlphanumeric(s.charAt(j)))
                j--;
            while(i< j){
                if(toLowCase(s.charAt(i))!=toLowCase(s.charAt(j)))
                    return false;
                i++;
                j--;
                while(!isAlphanumeric(s.charAt(i)))
                    i++;
                while(!isAlphanumeric(s.charAt(j)))
                    j--;
            }
            return true;

        }
    }
    public boolean isAlphanumeric(char c){
        if(c>= '0' && c <='9')
            return true;
        else if( (c>= 'A' && c<='Z')||(c>= 'a' && c<='z')){
            return true;
        }
        else
            return false;
    }
    public char toLowCase(char c){
        if(c>= '0' && c <='9')
            return c;
        else if(c>= 'A' && c<='Z'){
            return (char) (c-'A'+'a');
        }
        return c;
    }
}
