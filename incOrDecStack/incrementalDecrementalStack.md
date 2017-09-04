##trapping water solution##
1. brutal force
O(n2) time ->
scan array for every element and get the water need to add in this index 
O(1) space ->
no need to store anything

2. dp 
O(n) time -> calculate left max array from 0->end and right max array from end->0, use the two array to get the water need to add in certain index
three pass

O(n) space ->left max array and right max array

3. stack
O(n) time one pass
O(n) space use stack to store indices of bar

Use stack to store the indices of the bars.

Iterate the array:

While stack is not empty and height[current] > height[st.top()]:
    It means that the stack element can be popped. Pop the top element as top.

    Find the distance between the current element and the element at top of stack, which is to be filled. distance = current - st.top() - 1 

    Find the bounded height bounded_height=min(height[current],height[st.top()])−height[top]

    Add resulting trapped water to answer ans+=distance∗bounded_height

Push current index to top of the stack

Move current to the next position

4. two pointer
left/right pointer
O(n) time one pass
O(1) space