// stack
class Solution {
    public int calculate(String s) {
        int num = 0;
        char prev_operator = '+';
        Stack<Integer> stack = new Stack<>();
        // remove the spaces in the given string
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) != ' ')sb.append(s.charAt(i));
        }
        // core logic
        for(int i=0;i<sb.length();i++){
            if(Character.isDigit(sb.charAt(i))){
                num = num * 10 + (sb.charAt(i) - 48); // build full digit
            }
            if(!Character.isDigit(sb.charAt(i)) || i == sb.length()-1){
                if(prev_operator == '+')stack.push(num);
                else if(prev_operator == '-')stack.push(num*-1);
                else if(prev_operator == '*')stack.push(stack.pop()*num);
                else if(prev_operator == '/')stack.push(stack.pop()/num);
                num = 0;
                prev_operator = sb.charAt(i);
            }
        }
        // add the whole stack to get the answer
        int ans = 0;
        while(!stack.isEmpty())ans += stack.pop();
        return ans;
    }
}