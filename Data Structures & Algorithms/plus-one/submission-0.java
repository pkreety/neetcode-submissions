class Solution {
    public int[] plusOne(int[] digits) {

        int carry = 1; 
        List<Integer> result = new ArrayList();

        for(int i=digits.length - 1; i >=0; i--){

            int sum = digits[i] + carry;
            if(sum >= 10){ 
               carry = sum/10;
               int current = sum % 10; 
               result.add(current);
            } else {
                result.add(sum);
                carry = 0;
            }


        }
        if (carry !=0) {
            result.add(carry);
        }
        Collections.reverse(result); 
        int[] array = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            array[i] = result.get(i); // Automatically unboxes Integer to int
        }
        return array;

        
    }
}
