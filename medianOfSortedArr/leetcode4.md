this is really old but classic question:

| scenario                                 | target                                   |
| ---------------------------------------- | ---------------------------------------- |
| There are two sorted arrays **nums1** and **nums2** of size m and n respectively. | Find the median of the two **sorted** arrays. |



only key word is**"Sorted"**

this means when you separate one array into two parts and two parts are still sorted.

If you separate nums1 and nums2 then combine the smaller parts and bigger parts:

{ nums1_small , nums2_small } ---> get max of this set by compare last number of nums1_small with last number of nums2_small 

{ nums1_big, nums2_big } --> get min of this set by compare first number of nums1_big with first number of nums2_big



if we can divide the two arrays and get new two mixed array  with the latter fulfill two conditions:

   	1. newSet1.size == newSet2.size || newSet1.size == newSet2.size-1
     2. max of newSet1 < min of newSet2

then we can locate the median number is (mean of last number of small set and first number of big set) or first number of big set

**review about binary search**

1. model 0：

   start, end// index for numbers range

   while(start + 1 < end){

   ​	mid = start + (end - start)/2

   ​	if(target found) return mid

   ​	if(need search larger part) start = mid

   ​	if(need search smaller part) end = mid

   }

   //check start and end again

   if(numbers[start] == target) return start

   else return end

2. model 1:

   start, end

   while(start <= end){

   ​	mid = start + (end - start)/2

   ​	if(target found) return mid

   ​	if(need search larger part) start = mid+1

   ​	if(need search smaller part) end = mid-1

   }

   return -1

   ​