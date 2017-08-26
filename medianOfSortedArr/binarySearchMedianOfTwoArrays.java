class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //log(min(m, n))
        if(nums1.length > nums2.length){
            int[] tmp = nums2;
            nums2 = nums1;
            nums1 = tmp;
        }
        int m = nums1.length;//smaller length, binary search base
        int n = nums2.length;
        
        int leftLength = (m + n)/2;
        
        int start = 0, end = m;
        int mid1, mid2;
        while(start <= end){
            mid1 = (start + end)/2 - 1;
            mid2 = (leftLength - (start + end)/2) -1;
            
            int leftMax = Integer.MIN_VALUE;
            if(mid1>=0){ leftMax = Math.max(nums1[mid1], leftMax);}
            if(mid2>=0){ leftMax = Math.max(nums2[mid2], leftMax);}
            int rightMin = Integer.MAX_VALUE;
            if(mid1+1 < m){ rightMin = Math.min(nums1[mid1+1], rightMin);}
            if(mid2+1 < n){ rightMin = Math.min(nums2[mid2+1], rightMin);}
            if(leftMax <= rightMin){
                if((m+n) % 2 == 1){
                    //odd
                    return (double)rightMin;
                }else{
                    //even 
                    return (double)(rightMin+leftMax)/2.0;
                 }
            }
            
            if(mid1 >= 0 && nums1[mid1] > nums2[mid2+1]){
                end = (start + end)/2-1; 
            }else if(mid2 >= 0 && nums2[mid2] > nums1[mid1+1]){
                start = (start + end)/2+1;
            }   
        }
        return -1.0;//target not found, but in this case never happen, just for compile
        
    }
}