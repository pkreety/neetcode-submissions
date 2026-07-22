class Solution {
    public int lengthOfLongestSubstring(String s) {

        int start = 0; 
        int end = 0; 

        Map<Character, Integer> map = new HashMap<>();
        int counter = 0;
        while(end<s.length()){
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0) + 1);
            
            while(map.get(c)> 1){
                char leftChar = s.charAt(start);
                map.put(leftChar, map.get(leftChar) - 1); 
                start++;

            }
            counter = Math.max(counter, end - start + 1);

            end++;



        }

        return counter;
        
    }
}
