class Solution {
    public boolean isPalindrome(String s) {
       int head = 0; 
       int tail = s.length() - 1; 
        
       if(s.length() == 0){
        return true;
       } 
       while(head < tail){
        char cHead = s.charAt(head);
        char cTail = s.charAt(tail);
        if(!Character.isLetterOrDigit(cHead)){
            head++;
        } else if(!Character.isLetterOrDigit(cTail)){
            tail--;
        } else {

            if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
        			return false;
        		}
                head ++;
                tail --;
        }


       }
       return true;
    }

}
