this is really old but classic question:

| scenario                                 | target                                   |
| ---------------------------------------- | ---------------------------------------- |
| There are two sorted arrays **nums1** and **nums2** of size m and n respectively. | Find the median of the two **sorted** arrays. |



only key word is**"Sorted"**

this means when you separate one array into two parts and two parts are still sorted.

If you separate nums1 and nums2 then combine the smaller parts and bigger parts:

{ nums1_small , nums2_small }

{ nums1_big, nums2_big }