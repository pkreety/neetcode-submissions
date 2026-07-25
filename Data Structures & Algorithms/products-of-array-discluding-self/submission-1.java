class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftProduct = new int[nums.length]; 
        int[] rightProduct = new int[nums.length]; 
        int[] result = new int[nums.length];
         int productUntilNow = 1;
        for(int i =0; i < nums.length; i++){
            leftProduct[i] = nums[i]*productUntilNow;
            productUntilNow = leftProduct[i];

        }
        productUntilNow = 1;
         for(int i =nums.length -1; i >=0; i--){
            rightProduct[i] = nums[i]*productUntilNow;
            productUntilNow = rightProduct[i];

         }
         result[0] = rightProduct[1];
         for(int i=1; i <nums.length - 1; i++){
            System.out.println("leftProduct"+leftProduct[i - 1]);
             System.out.println("rightProduct"+rightProduct[i + 1]);
            result[i] = rightProduct[i + 1] * leftProduct[i - 1];

         }
         result[nums.length -1] = leftProduct[nums.length -2];
         return result;
        
    }
}  
