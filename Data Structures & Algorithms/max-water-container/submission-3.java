class Solution {
    public int maxArea(int[] heights) {

        int left = 0; 
        int right = heights.length - 1;
        int maxArea = 0;

        while(left <= right){
            int area = 1;
            if(heights[left]> heights[right]){
                 area = heights[right] * (right - left);
                 right--;
            }else {
                 area = heights[left] * (right - left);    
                 left ++; 
            }

            maxArea = Math.max(maxArea, area);

        }

        return maxArea;
        
    }
}
