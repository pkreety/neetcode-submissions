class Solution {
    public boolean isValid(String s) {

        Map<Character, Character> map = Map.of('{', '}', '[', ']', '(', ')');
        Stack<Character> stack = new Stack(); 

        for(char ch: s.toCharArray()){
            if(ch == ('{') || ch == ('[') || ch == ('(')){
                stack.push(ch);
            }
            else {
                if(stack.isEmpty()){
                    return false;
                }
                char charFromStack = stack.pop(); 
                if(map.containsKey(charFromStack)){
                   if(ch != (map.get(charFromStack))){
                        return false;
                   }
                }
            }
        }
         return stack.isEmpty() ? true : false;
        
    }
}
