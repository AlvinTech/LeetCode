/**
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 14-9-18
 * Time: 下午4:52
 Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

 Note: You may not slant the container.
 */
public class Container_With_Most_Water {
    public int maxArea(int[] height) {
        int mostWater = 0;

        int length = height.length;
        int left  = 0;
        int right = length -1;
        while(left < right){
            int h = (height[left] < height[right])? height[left]: height[right];
            int var = (right - left) * h;
            mostWater = mostWater > var ? mostWater: var ;
            if(height[left] < height[right]){
                left ++;
            }
            else
                right--;
        }

        return mostWater;
    }
}
