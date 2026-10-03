class Solution {
    public int calculate(String s) {
        int res = 0;
        int num = 0;
        int sign = 1;

        Stack<Integer> stack = new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(ch >= '0' && ch <= '9'){ // construct number
                num = num*10 + (ch-48);
            }
            else if(ch == '+'){
                res += num*sign; // if prev sign is (-), the current num be added as -num

                num = 0; // reset to build new number
                sign = 1; // save sign to add
            }
            else if(ch == '-'){
                res += num*sign; // if prev sign is (-), the current num be added as -num

                num = 0; // reset to build new number
                sign = -1; // save sign to add
            }
            else if(ch == '('){
                // save the available result and sign 
                stack.push(res);
                stack.push(sign);

                // start a fresh result within the ()
                res = 0;
                num = 0;
                sign = 1;
            }
            else if(ch == ')'){
                res += num*sign;

                // add existing result to the current result
                int prevSign = stack.pop(), prevRes = stack.pop();

                res = prevRes + (res*prevSign);

                num=0;
                sign=1;
            }
        }

        res += num*sign;

        return res;
    }
}