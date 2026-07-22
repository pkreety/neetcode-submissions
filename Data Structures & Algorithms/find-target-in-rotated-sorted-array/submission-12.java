class Solution {
    public int search(int[] nums, int target) {
        if(nums.length == 1){
            if(nums[0]== target){
                return 0; 
            }else {
                return -1;
            }
        }

      int index = findRotationIndex(nums, 0, nums.length-1);
      System.out.println("rotated index "+index);
      int result  = findTarget(nums, index, nums.length - 1, target );
      if(result == -1){
        return findTarget(nums, 0, index - 1, target ); 
      } else {
        return result;
      }
      
    }

    public int findTarget(int[] nums, int lo, int high, int target){
        if(lo == high && nums[lo] == target){
            return lo;
        }
        if(lo >= high){
            return - 1;
        }
        int mid = lo + (high - lo)/2;
        System.out.println("mid target search "+mid);
        if(nums[mid] == target){
            return mid;
        }  
        if(nums[mid]<target){
         return findTarget(nums, mid+1, high, target); 
        }   else {
          return findTarget(nums, lo, mid -1 , target );     
        }

    }

    public int findRotationIndex(int[] nums, int lo, int hi){
       while(lo <= hi){

          int mid = lo + (hi - lo)/2; 

          if(nums[mid]<nums[hi]){
             hi = hi - 1;
          } else {
             lo = lo + 1;
          }
          


        }
       return hi;
    
    }



}
