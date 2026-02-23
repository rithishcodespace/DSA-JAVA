class Solution {
    public int clumsy(int n) {
        int op = 0, sum = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(n);
        // evaluate *,/
        for(int i=n-1;i>=1;i--){
            op = op%4;
            if(op == 0){ // '*'
                stack.push(i*stack.pop());
            }
            else if(op == 1){ // '/'
                stack.push(stack.pop()/i);
            }
            else if(op == 2){ // '+'
                stack.push(i);
            }
            else{ // '-'
                stack.push(-i);
            }
            op++;
        }
        // evaluate +,-
        while(!stack.isEmpty()){
            sum += stack.pop();
        }
        return sum;
    }
}