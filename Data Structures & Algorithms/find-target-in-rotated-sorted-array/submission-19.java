class Solution {
    public int search(int[] nums, int target) {

        int low = findMin(nums);
        System.out.println(low);
        if(nums[low] == target){
            return low;
        }
        if(target > nums[nums.length - 1]){
           return  search(nums, 0, low, target);
        } else {
           return  search(nums, low, nums.length - 1, target);
        } // 0, 0
       // return 1;
    }

    public int findMin(int[] nums){

        int low = 0; 
        int high = nums.length - 1;

        while(low <= high){

            int mid = low + (high - low)/2;

            if(nums[mid] < nums[high]){
                high = mid;

            } else {
                low = mid + 1;
            }

        }
        return high;

    }

    public int search(int[] nums,int lo, int hi, int target){
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            System.out.println("mid "+ mid);
            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid]<  target){
                lo = mid + 1; 
            } else {
                hi = mid - 1;
            }
        }

        return -1;
    }
}
