class Solution {
    public String getHint(String secret, String guess) {
        int bulls = 0, cows = 0;
        HashMap<Character,Integer> map = new HashMap<>();

        // count bulls
        for(int i=0;i<secret.length();i++){
            char num1 = secret.charAt(i);
            char num2 = guess.charAt(i);

            map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i),0)+1);

            if(num1 == num2){ 
                bulls++;
                map.put(num1, map.getOrDefault(num1,0)-1); // cows should not be counted as bulls
            }
        }

        // count cows
        for(int i=0;i<guess.length();i++){
            char num1 = secret.charAt(i);
            char num2 = guess.charAt(i);

            if(num1 == num2){ 
                continue;
            }
            else if(map.containsKey(num2) && map.get(num2) > 0){
                cows++;
                map.put(num2, map.getOrDefault(num2,0)-1);
            }
        }

        return bulls + "A" + cows + "B";
    }
}