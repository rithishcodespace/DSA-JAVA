class Solution {
    public int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while(head != null){
            sb.append((char)(head.val+48));
            head = head.next;
        }
        return binaryToDecimal(sb);
    }
    public int binaryToDecimal(StringBuilder sb){
        int num = 0, power = 0;
        for(int i=sb.length()-1;i>=0;i--){
            num += (char)(sb.charAt(i)-48)*(int)(Math.pow(2,power++));
        }
        return num;
    }
}