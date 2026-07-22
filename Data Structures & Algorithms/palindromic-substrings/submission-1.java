class Solution {
    public int countSubstrings(String s) {

        if(s.length()==1){
            return 1;
        }
        int result = 0; 
        for(int i= 0; i<s.length(); i++){ //aabaa [ aa, b, aba, aa, aabaa, a]
             
            result += checkIfPalindrome(s, i, i);
            result +=checkIfPalindrome(s, i, i+1);

        }
        return result;
    }

    public int checkIfPalindrome(String s, int start, int end){ // aba
       int palindromeCount = 0;
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            start--; 
            end++;
            palindromeCount++;
        }

        return palindromeCount;
    }
}
