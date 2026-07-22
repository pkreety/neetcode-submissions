class MinStack {
    Stack<Integer> min; 
    Stack<Integer> stack;

    public MinStack() {
       min = new Stack<Integer>();
       stack = new Stack<Integer>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(!min.isEmpty()){
            int topVal = min.peek();
            if(val <= topVal){
                min.push(val);
            }
        }else {
            min.push(val);
        }
    }
    
    public void pop() {
        int topStack = stack.pop();
        int minStackTop = min.peek();
        if(topStack == minStackTop){
            min.pop();
        }
    }
    
    public int top() {
        return stack.peek();
        
    }
    
    public int getMin() {
        return min.peek();
    }
}
