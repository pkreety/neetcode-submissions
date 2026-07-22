class Solution {
    public int characterReplacement(String s, int k) {

        Map<Character, Integer> map = new HashMap();
        int start = 0;
        int end = 0 ; 
        int mostFreqCount = 0; 
        int max = 0; 

        while(end < s.length()){
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c,0)+ 1);

            mostFreqCount = Math.max(mostFreqCount, map.get(c));
            int numOfOtherCharacters = (end - start + 1) - mostFreqCount;

            if(numOfOtherCharacters > k){

                // count replacement

                char charAtStart = s.charAt(start);
                map.put(charAtStart, map.get(charAtStart) - 1);
                start++;
            }

            max = Math.max(max, end - start+ 1);
            end++;





        }
        return max;
    }
}
