// stack
class Solution {
    public int countCollisions(String directions) {
        int collison = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<directions.length();i++){
            char curr = directions.charAt(i);
            if(stack.isEmpty())stack.push(curr);
            else if(curr == 'L'){
                boolean push = true;
                if(!stack.isEmpty() && stack.peek() == 'S'){
                   collison += 1;
                   push = false;
                }
                if (!stack.isEmpty() && stack.peek() == 'R') {
                    collison += 2;
                    stack.pop();

                    while (!stack.isEmpty() && stack.peek() == 'R') {
                        collison++;
                        stack.pop();
                    }

                    push = false;
                    stack.push('S');
                }
                if(push)stack.push(curr); // stack.peek() will be 'L'
            }
            else if(curr == 'R'){
                stack.push(curr);
            }
            else{
                boolean push = true, addS = false;
                if (!stack.isEmpty() && stack.peek() == 'R') {
                    collison += 1;
                    stack.pop();

                    while (!stack.isEmpty() && stack.peek() == 'R') {
                        collison++;
                        stack.pop();
                    }

                    push = false;
                    stack.push('S');
                }
                if(push)stack.push(curr); // stack.peek() will be 'S'
            }
        }
        return collison;
    }
}