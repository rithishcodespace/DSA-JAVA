// pick every even
// if odd (pick even length)
// pick exactly one char in left over odds -> (odd-1)

// tc: O(n)
// sc: O(n)

class Solution {
    public int longestPalindrome(String s) {
        int even = 0, odd = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }

        for(char key : map.keySet()){
            if(map.get(key)%2 == 0)even += map.get(key);
            else{
                odd = 1;
                even += map.get(key)-1;
            }
        }

        return even+odd;
    }
}