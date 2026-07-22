class Solution {
    String[] list = new String[]{"","", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    public List<String> letterCombinations(String digits) {

      List<String> result = new ArrayList(); 
      if(digits.length() == 0 || digits == ""){
        return new ArrayList();
      }
      
      backTrack(result, digits, new StringBuilder(""), 0);

      return result;

        
    }


    public void backTrack(List<String> result, String digits, StringBuilder current, int index){ // 34
            if(digits.length() == current.length()){
                result.add(current.toString());
                return;
            }

            char firstDigit = digits.charAt(index); // 3 , 345
            String characterAtfirstDigit = list[firstDigit - '0']; // DEF // GHI
            for(char c: characterAtfirstDigit.toCharArray()){
                current.append(c); // DG
                backTrack(result, digits, current, index + 1);
                current.setLength(current.length() - 1);
            }
            

            
    }
}
