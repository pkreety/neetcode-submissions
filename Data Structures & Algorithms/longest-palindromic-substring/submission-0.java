class Solution {
    public String longestPalindrome(String s) {

        if(s.length() == 1){
            return s;
        }

        int start =0; 
        int end = 0;
      for(int i =0; i < s.length(); i++){

         int len1 = expandFromMiddle(s, i , i+ 1);
         int len2 = expandFromMiddle(s, i , i);

         int len = Math.max(len1, len2);

          if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
      }


        return s.substring(start, end + 1);
        
    }

    public int expandFromMiddle(String s, int start, int end){
        
        while(start>=0 && end < s.length() && s.charAt(start) == s.charAt(end)){
          
               start--; // this is expanding from middle so go to left not otherway round
               end++;
           }      
        return end - start -1; //if i do end - start +1 might get value longer than length array index out of bound
    }
}
