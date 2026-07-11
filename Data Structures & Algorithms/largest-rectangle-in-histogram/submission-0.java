class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();

        int maxArea = 0, currentHeight;

        for(int i = 0; i <= heights.length; i++) {
            if(i == heights.length)
                currentHeight = 0;
            else
                currentHeight = heights[i]; 

            while(!st.isEmpty() && heights[st.peek()] > currentHeight) {
                int height = heights[st.pop()];
                int width;

                if(st.isEmpty())
                    width = i;
                else
                    width = i - st.peek() - 1;  

                maxArea = Math.max(maxArea, height * width);  
            }
            st.push(i);   
        }

        return maxArea;
    }
}
