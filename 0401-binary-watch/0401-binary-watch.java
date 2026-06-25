// 0000:000000

class Solution {

    List<String> list = new ArrayList<>();

    public List<String> readBinaryWatch(int turnedOn) {
        solve(0, 0, 0, turnedOn);
        return list;
    }

    public void solve(int h, int m, int idx, int left){
        if(idx >= 10){
            if(left == 0 && h <= 11 && m < 60){
                StringBuilder hr = new StringBuilder(String.valueOf(h));
                StringBuilder min = new StringBuilder(String.valueOf(m));
                if(min.length() == 1)min.insert(0,'0');
                String time = hr.toString()+":"+min.toString();
                list.add(time);
            }
            return;
        }

        // pick
        if(idx <= 5){ // min
            solve(h, m|(1<<idx), idx+1, left-1);
        }
        else{ // hr
            solve(h|(1<<(idx%6)), m, idx+1, left-1);
        }

        // not-pick
        solve(h, m, idx+1, left);
    }
}