class Solution {
    public String minWindow(String s, String t) {
        
        Map<Character, Integer> map = new HashMap();
        for(char ch: t.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        int globalStart = 0; 
        int globalEnd = s.length() -1;

        int left = 0; 
        int right = 0; 

        int count = t.length();
        int min = s.length();

        boolean flag = false;

        while(right < s.length()) {
           
            char c = s.charAt(right); 
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1); 
                if(map.get(c)>=0){
                    count--;
                }
            }

            while(count == 0 && left <=right){
                 flag = true;
                int currentLen = right - left + 1; 
                if(currentLen < min){
                    min = currentLen; 
                    globalStart = left; 
                    globalEnd = right;
                }

                if(map.containsKey(s.charAt(left))){
                    map.put(s.charAt(left), map.get(s.charAt(left)) + 1);
                    if(map.get(s.charAt(left)) >= 1){
                        count++;
                    }
                }
                left++;

            }
                right++;


        }
        return flag ? s.substring(globalStart, globalEnd + 1): "";
        
    }
}
