/**   Two Sum
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 14-9-18
 Given an array of integers, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 */
public class Two_Sum {
    //隐含条件是 array 是正整数序列，且是递增序列。
    public int[] twoSum(int[] numbers, int target) {
        int[] two =new int[2];
        for(int i=0;i<numbers.length;i++){
            if(numbers[i] >target)
                break;
            for(int j=i+1;j<numbers.length;j++){
                if(numbers[i]+ numbers[j] == target)
                {
                    two[0] = i+1;
                    two[1] = j+1;
                    return two;
                }
            }
        }
        return two;

    }

    public static void main(String[] args){
        int [] array = {2,7,11,15};
        int target=9;
        int[] two = new Two_Sum().twoSum(array,target);
        System.out.println(two[0]);
        System.out.println(two[1]);

    }
}
