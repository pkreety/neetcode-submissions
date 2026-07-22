class Solution {
    public int search(int[] nums, int target) {
        int l = 0; 
        int high = nums.length - 1; 
        
        return binarySearch(nums, l, high, target);
        
    }


    public int binarySearch(int[] nums, int low, int high, int target){
         if(nums[low] == target){
            return low;
        }
        if(low >=high){
            return -1;
        }
       

        int mid = low + (high - low)/2;
    
        if(nums[mid] == target){
            return mid;
        }

        if(nums[mid]> target){
            return binarySearch(nums, low, mid, target);
        } else {
             return binarySearch(nums, mid + 1 , high, target); //
        }


    }
}
