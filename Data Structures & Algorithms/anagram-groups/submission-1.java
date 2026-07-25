class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> map = new HashMap();
        List<List<String>> result = new ArrayList(); 

        for(int i =0; i< strs.length; i++){
            String current = strs[i]; 
            char[] words = current.toCharArray();
            Arrays.sort(words);
            String sortedCurrent = String.valueOf(words);
            if(!map.containsKey(sortedCurrent)){
                 map.put(sortedCurrent, new ArrayList());
            } 
               
                map.get(sortedCurrent).add(current);
            
        } 

        for(String key: map.keySet()){
            List<String> values = map.get(key);

            result.add(values);
        }
        return result;
    }
}
