class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet(); 
        int maxLength = 0; 
        int left = 0; 
        int right = 0;

        while(right < s.length()){
            while(right < s.length() && set.add(s.charAt(right))){
               right++;
            }

            int size = right - left;
            maxLength = Math.max(maxLength, size);
            set.remove(s.charAt(left));
            left++;


        }   
        return maxLength;
    }
}
