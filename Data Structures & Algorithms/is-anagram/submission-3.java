class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap();
        if(s.length() !=  t.length()){
            return false;
        }
        for(char c: s.toCharArray()){
            map.putIfAbsent(c,0);
            map.put(c,map.get(c) + 1);
        }

        for(char c: t.toCharArray()){
            if(!map.containsKey(c)){
                return false;
            }
            map.put(c,map.get(c) - 1);
            if(map.get(c)<0){
                return false;
            }
        }
        return true;
    }
}
