class Solution {
    public int countSubstrings(String s) {

        if(s.length()==1){
            return 1;
        }
        int result = s.length(); 
        for(int i= 1; i<s.length(); i++){ //aabaa [ aa, b, aba, aa, aabaa, a]
             
            result += checkIfPalindrome(s, i-1, i+1);
            result +=checkIfPalindrome(s, i-1, i);

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
