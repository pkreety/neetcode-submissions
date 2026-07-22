class Solution {
    public int minEatingSpeed(int[] piles, int h) {
         Arrays.sort(piles); 
         return binarySearch(piles, h, 1, piles[piles.length - 1]);
         
    }

    public int binarySearch(int[] piles, int h, int low, int high){
        if(low > high){
            return low;
        }
        System.out.println("high "+high);
        System.out.println("low "+low);
        int mid = low + (high - low)/2;
        System.out.println("mid "+mid);
        System.out.println(mid);
        int hrs = hoursTakeToEatmidBananas(mid, piles);
        // if(hrs == h){
        //     return piles[mid];
        // }
        if(hrs > h){
            System.out.println("higher");
            return binarySearch(piles, h, mid + 1, high);
        } else {
            return binarySearch(piles, h, low, mid - 1);
        }

      //return piles[high];
    }


    public int hoursTakeToEatmidBananas(int noOFbananas, int[] piles){
        int result = 0;
        for(int i =0; i < piles.length;i++){
                result+=piles[i]/noOFbananas;
                if(piles[i]%noOFbananas > 0){
                    result = result + 1;
                }
        }
        System.out.println("hrs to eat bananas "+result);
        return result;

    }
}
