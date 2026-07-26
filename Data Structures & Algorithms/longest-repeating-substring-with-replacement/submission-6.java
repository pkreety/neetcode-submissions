class Solution {
    public int characterReplacement(String s, int k) {

        int left = 0; 
        int right = 0; 
        int maxRepeatingChar = 0; 

        int maxFreq = 0; 
        
        Map<Character, Integer> map = new HashMap(); 
        while(right < s.length()){
            if(map.containsKey(s.charAt(right))){
                map.put(s.charAt(right), map.get(s.charAt(right)) + 1);
            } else {
                map.put(s.charAt(right), 1);
            }
          maxFreq = Math.max(maxFreq, map.get(s.charAt(right)));

          int otherCharacters = (right - left + 1) - maxFreq;
          if(otherCharacters > k){
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1); 
                left++;
            
          }
          maxRepeatingChar = Math.max(maxRepeatingChar, right - left + 1);
          right++;
        }

        return maxRepeatingChar;
        
    }
}
