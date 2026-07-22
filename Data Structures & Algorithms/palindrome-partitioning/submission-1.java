class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result= new ArrayList();
        backTrack(s, result, 0, new ArrayList());
        return result;
        
    }

    public void backTrack(String s, List<List<String>> result, int index, List<String> current){
        if(index == s.length()){
            result.add(new ArrayList(current));
            return;
        }
        
        for(int i = index; i < s.length(); i++){ // [aab],   - 0 , 1, a
            String currentString = s.substring(index, i + 1);// a, a, b
            if(!checkIfPalindrome(currentString)){
                continue; //aabaac
            } else {
                current.add(currentString);
                backTrack(s, result, i+1, current);
                current.remove(current.size() - 1);
            }
            
        }
    }

    public boolean checkIfPalindrome(String s){
        if(s.length() == 0){
            return false;
        }
        int i = 0; 
        int j = s.length() - 1; 
        while(j > i){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++; 
            j--; 
        }
        return true;
    }
}
