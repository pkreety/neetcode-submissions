class Solution {
    public int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<Integer>();
        String[] operators = new String[]{"+","-", "*","/"};
        for(int i = 0; i<tokens.length;i++){
            if(!Arrays.asList(operators).contains(tokens[i])) {
                stack.push(Integer.parseInt(tokens[i]));
            } else {
                int firstNumber = stack.pop();
                int secondNumber = stack.pop();
                int val = 0;
                switch(tokens[i]) {
                    case "+":
                    val = firstNumber + secondNumber;
                    break;
                    case "-":
                    val = secondNumber - firstNumber;
                    break;
                    case "*":
                    val = firstNumber * secondNumber;
                    break;
                    case "/":
                    val = secondNumber/firstNumber;
                    break;
                }
                
                stack.push(val);
            }
        }
        return stack.pop();
    }
}
