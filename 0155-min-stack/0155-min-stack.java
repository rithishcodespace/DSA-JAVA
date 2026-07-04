// Instead of: "What is min of full stack?" (expensive)
// You store: "min till here" at every step (cheap) in a seperate a stack
// actual stack: [5, 2, 8, 1]
// min stack:    [5, 2, 2, 1]
// during pop, if popped is the top of minstack, pop also it from minstack

// tc: O(1)
// sc: O(n)

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int value) {
        stack.push(value);
        if(minStack.isEmpty()){
            minStack.push(value);
        }
        else{
            minStack.push(Math.min(value,minStack.peek()));
        }
    }
    
    public void pop() {
        stack.pop();
        // to maintain correct min - i always push so i always remove
        minStack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */