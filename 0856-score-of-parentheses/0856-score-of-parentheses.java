// we remember the parent level using the integers inside stack

class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i=0;i<s.length();i++){
            char br = s.charAt(i);

            if(br == '('){
                stack.push(0);
            }
            else{
                int inside = stack.pop();

                int value = 0;

                if(inside == 0){ // ()
                    value = 1;
                }
                else if(inside >= 1){ // (A)
                    value = inside*2;
                }

                // add this score to parent level
                int parent = stack.pop();
                stack.push(parent+value);
            }
        }

        return stack.pop();
    }
}