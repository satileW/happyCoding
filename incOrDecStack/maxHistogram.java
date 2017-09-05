class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> incrementalStack = new Stack<Integer>();
        incrementalStack.push(-1);//mark for left point of first height
        int i = 0;
        int area = 0;
        while(i < heights.length){
            while(incrementalStack.peek()!=-1 && heights[i] < heights[incrementalStack.peek()] ){
                int li = incrementalStack.pop();
                area = Math.max(area, heights[li] * (i - incrementalStack.peek() - 1 ) );
            }
            incrementalStack.push(i);
            i++;
        }
        
        while(incrementalStack.peek()!=-1 ){
            int li = incrementalStack.pop();
            area = Math.max(area, heights[li] * (i - incrementalStack.peek() - 1) );
        }
        return area;
    }
}