class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for(String s: strs){
               char[] words = s.toCharArray();
               Arrays.sort(words);
               String word = String.valueOf(words);
               if(!map.containsKey(word)){
                 map.put(word, new ArrayList());
               }
               map.get(word).add(s);

        }
        return new ArrayList<>(map.values());
    }
}
