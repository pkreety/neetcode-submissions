class Solution {
    int max = 0; 
    public int maxArea(int[] heights) {
        int i = 0; 
        int j = heights.length - 1; 

        while(i < j){
            int height = Math.min(heights[i], heights[j]);        
            max = Math.max(max, (j - i) * height); 
            if(heights[i]> heights[j]){
                j--;
            } else {
                i++;
            }

        }
        return max;
        
    }
}
