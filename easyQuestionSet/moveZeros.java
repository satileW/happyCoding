//Given an array nums, write a function to move all 0's
// to the end of it
// while maintaining the relative order of the non-zero elements.
class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length <= 1) return;
        int positiveIndex = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0 ){
                if(i > positiveIndex){//judgement may increase time use
                    nums[positiveIndex] = nums[i];
                    nums[i] = 0;
                }
                positiveIndex ++;
            }
        }
    }


    // Shift non-zero values as far forward as possible
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;
        for (int num: nums) {
            if (num != 0) nums[insertPos++] = num;
        }
        // Fill remaining space with zeros
        while (insertPos < nums.length) {// looks like 1.5 pass
            nums[insertPos++] = 0;
        }
    }

    //shortest solution, but still use O(1) temp space
    public void moveZeroes(int[] nums) {

        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }
    }
}