//leetcode42

class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length-1;
        int trap = 0;
        int leftMax = 0, rightMax = 0;
        while(left < right){
            //meet at one position with global max value, so left < right or left <= right is both ok
            int diff = 0;
            if(height[left] <= height[right]){
                leftMax = Math.max(leftMax, height[left]);
                diff = leftMax - height[left];
                left ++;
            }else{
                rightMax = Math.max(rightMax, height[right]);
                diff = rightMax - height[right];
                right --;
            }
            trap += diff;
        }
        return trap;
    }
}