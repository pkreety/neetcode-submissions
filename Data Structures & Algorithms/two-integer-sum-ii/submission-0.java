class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int[] result = new int[2];
        int j = numbers.length - 1;
        int i = 0; 
        while(i<j){
            System.out.println("i "+i);
            System.out.println("j "+j);
            int current = target - numbers[i]; 
            System.out.println(current);
            // binarySearch(current, i+1);
            if(current == numbers[j]){
                System.out.println("same");
                return new int[]{i + 1 , j + 1};
            } 
            if(current < numbers[j]){ // 50, [1, 2...51 , ...10000]
                j--; 
            } else {
                i++;
            }
            

        }
        return new int[]{i + 1, j + 1};
        
    }


}
