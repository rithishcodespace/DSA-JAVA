// we track the parent level using integers inside stack
// if the current value is >= 1 -> val*2 -> pop the parent (remove parent bracket) and add it to score and push to stack

class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            char br = s.charAt(i);

            if(br == '('){
                stack.push(0);
            }
            else{
                int inside = stack.pop();

                int value = 1;

                if(inside >= 1){
                    value = value*2;
                }

                int parent=0;

                if(!stack.isEmpty()){
                    parent = stack.pop();
                }

                stack.push(value+parent);
            }
        }

        return stack.pop();
    }
}