class Solution {
    public int minAddToMakeValid(String s) {
        int count = 0;
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            char br = s.charAt(i);

            if(br == '('){
                stack.push(br);
            }
            else{
                if(stack.isEmpty() || stack.peek() != '('){
                    if(stack.isEmpty())count++;
                    else{
                        count += stack.size();
                        stack.clear();
                    }
                }
                else stack.pop();
            }
        }

        return count + stack.size();
    }
}