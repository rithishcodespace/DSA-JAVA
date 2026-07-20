// when you encounter '-', you need to remember that the next integer is neg

class Solution {
    public int calculate(String s) {
        int ans = 0;
        int num = 0;
        int sign = 1;

        Stack<Integer> stack = new Stack<>();

        for(char ch : s.toCharArray()){
            if(Character.isDigit(ch)){
                num = num * 10 + (ch-'0');
            }
            else if(ch == '+'){
                ans = ans + sign*num;

                num=0;
                sign=1; // + is saved for next creating num
            }
            else if(ch == '-'){
                ans = ans + sign*num;

                num=0;
                sign=-1; // - is saved for next creating num
            }
            else if(ch == '('){
                // save info had before '('
                stack.push(ans);
                stack.push(sign);

                // start from fresh inside ()
                num=0;
                ans=0;
                sign=1;
            }
            else if(ch == ')'){
                ans = ans + sign*num;

                int prevSign = stack.pop();
                int prevAns = stack.pop();

                ans = prevAns + prevSign*ans;

                num=0;
                sign=1;
            }
        }

        ans = ans + sign*num; // remaining (no bracket case)

        return ans;
    }
}