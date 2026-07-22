class Solution {
    public int trap(int[] height) {

        int[] prefix = new int[height.length];
        int[] suffix = new int[height.length];
        int[] weight = new int[height.length];
        int maxPre = 0;
        int maxSuf = 0;
        int result = 0;
        for(int i =0; i<height.length; i++){
            prefix[i] = maxPre;
            maxPre = Math.max(height[i], maxPre);

        } 

        for(int i = height.length -1; i >=0; i--){
            suffix[i] = maxSuf;
            maxSuf = Math.max(height[i], maxSuf);

        }

        for(int i =0; i <height.length-1; i++){
            weight[i] = Math.min(prefix[i], suffix[i]) - height[i];

        }

        for(int i = 0; i < weight.length; i++){
            if(weight[i]> 0 ){
                result +=weight[i];
            }
        }

        return result;
        
    }
}
