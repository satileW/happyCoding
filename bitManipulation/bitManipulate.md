Bit manipulation

| and  | or   | xor  | not  | shift                                    |
| ---- | ---- | ---- | ---- | ---------------------------------------- |
| &    | \|   | ^    | ~    | << >>(arithmetic shift, most left bit keep original) >>>(logical shift, most left bit replace with 0) |

- Remove last bit A&(A-1)

- Is power of four (actually map-checking, iterative and recursive methods can do the same)

  bool isPowerOfFour(int n) {
  ​    return !(n&(n-1)) && (n&0x55555555);
  ​    //check the 1-bit location;
  }

- ##### Missing Number

  Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array. For example, Given nums = [0, 1, 3] return 2. (Of course, you can do this by math.)

  int missingNumber(vector<int>& nums) {
  ​    int ret = 0;
  ​    for(int i = 0; i < nums.size(); ++i) {
  ​        ret ^= i;
  ​        ret ^= nums[i];
  ​    }
  ​    return ret^=nums.size();
  }

- Find the largest power of 2 (most significant bit in binary form), which is less than or equal to the given number N.

  long largest_power(long N) {
  ​    //changing all right side bits to 1.
  ​    N = N | (N>>1);
  ​    N = N | (N>>2);
  ​    N = N | (N>>4);
  ​    N = N | (N>>8);
  ​    N = N | (N>>16);
  ​    return (N+1)>>1;
  }

- ##### Majority Element

  Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

  int majorityElement(vector<int>& nums) {
  ​    int len = sizeof(int)*8, size = nums.size();
  ​    int count = 0, mask = 1, ret = 0;
  ​    for(int i = 0; i < len; ++i) {
  ​        count = 0;
  ​        for(int j = 0; j < size; ++j)
  ​            if(mask & nums[j]) count++;//think clear and prove this is right
  ​        if(count > size/2) ret |= mask;
  ​        mask <<= 1;
  ​    }
  ​    return ret;
  }