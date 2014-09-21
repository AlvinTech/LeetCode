/**
 * Created with IntelliJ IDEA.
 * User: Alvin
 * Date: 14-9-18
 * Time: 下午4:52
 Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

 Note: You may not slant the container.
 */
package com.alvin.java;
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
/**
 * 思路：
 * 左边从头开始，右边从末尾开始。
 * 每次循环选择低的一边往里面移动就可以。
 * 为什么可以这样做：
 * 1。假设左边的比右边的高，那么只需要右边的往里面移动，以为现在决定容器高度的是右边，如果左边往里面移动
 *    两个x左边的差值越来越小，无论左边的高度比右边的高还是低，都会比没有移动时的小，所以只需要将低得一端
 *    向中间移动；
 * 2、低的一端想中间移动之后，另一端为什么不需要重头开始，而是再原来的位置继续；
 * a ,b，....... c,d,e,f,g,h......i,j,k,l
 * 某一时刻 c 和h 比较， 此时刚从c-1 移动到c，h并没有冲l从新开始，但是c 和i 构成的区域容积可能更大。
 * 为什么不需要从新比较。
 * 答：  右侧冲l-->h 的过程中会经过 i，此时于i形成容器的做出值假如是b；
 *      如果H(b) > H(i) --->   b 和i 形成的容器可定比 c 和i 形成的容器大。
 *      如果H(b) < H(i) ---->  先将b 和i 形成的容器面积和最大值比较。
 *      考虑 刚从c-1 移动到c。 此时 右侧位于h。
 *      左侧最后一次和i比较是c-m 的位置。
 *      此时H（c-m）> H(i) . 此时 c-m 和 i 形成的区域肯定比 H(c) 和 i形成的区域大。
 *      因为不关H(c) 是不是大于 H（i） ，他们两个个左边的差值已经越来越小。
 *基于上面的原因，所以不需要进行 左侧为c 和 右侧为i 的比较。就是右侧不需要回退到最右端。
 * */
