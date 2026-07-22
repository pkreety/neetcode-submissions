class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
         int len1 = s1.length(); 
        int len2 = s2.length();
        if(len1> len2){
            return false;
        }
        
        int[] charCountForS1 = new int[26]; 
        int [] charCountForS2 = new int[26];
        
        for(int i= 0; i < s1.length(); i++){
            charCountForS1[s1.charAt(i) - 'a']++;
            charCountForS2[s2.charAt(i) - 'a']++;     
        }
        
        for(int i = 0; i < s2.length() - s1.length(); i++){
            if(matches(charCountForS1, charCountForS2)){
                return true;
            }
            charCountForS2[s2.charAt(i+ s1.length()) - 'a']++;
            charCountForS2[s2.charAt(i) - 'a']--;
            
        }
        
        return matches(charCountForS1, charCountForS2);
        
    }
    
    public boolean matches(int[] charCountForS1, int[] charCountForS2) {
        for (int i = 0; i < 26; i++) {
            if (charCountForS1[i] != charCountForS2[i])
                return false;
        }
        return true;
    }
}