class Solution {
    public boolean judgeCircle(String moves) {
        int x=0,y=0;
        for(int i=0;i<moves.length();i++){
            char ch = moves.charAt(i);
            if(ch == 'U'){
                x++;
            }
            else if(ch == 'D'){
                x--;
            }
            else if(ch == 'L'){
                y--;
            }
            else{
                y++;
            }
        }
        return (x==0 && y==0) ? true : false;
    }
}