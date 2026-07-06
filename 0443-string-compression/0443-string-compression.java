class Solution {
    public int compress(char[] chars) {
        int count = 1;
        List<Character> list = new ArrayList<>();

        if(chars.length == 1)return 1;

        for(int i=1;i<chars.length;i++){
            char prev = chars[i-1];
            char curr = chars[i];

            if(curr == prev){
                count++;
            }
            if(curr != prev){
                if(count == 1){
                    list.add(prev);
                }
                else if(count >= 10){
                    list.add(prev);
                    String str = String.valueOf(count);
                    for(int j=0;j<str.length();j++){
                        list.add(str.charAt(j));
                    }
                }
                else{
                    list.add(prev);
                    list.add((char)(count+'0'));
                }

                count = 1;
            }
        }

        // fill remaining
        if(count >= 1){
            if(count == 1){
                list.add(chars[chars.length-1]);
            }
            else if(count >= 10){
                list.add(chars[chars.length-1]);
                String str = String.valueOf(count);
                for(int j=0;j<str.length();j++){
                    list.add(str.charAt(j));
                }
            }
            else{
                list.add(chars[chars.length-1]);
                list.add((char)(count+'0'));
            }
        }

        for(int i=0;i<list.size();i++){
            chars[i] = list.get(i);
        }

        return list.size();
    }
}