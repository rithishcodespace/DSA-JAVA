class TimeMap {

    HashMap<String,List<Pair>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key, new ArrayList<>());
        }
        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {

        if(!map.containsKey(key))return "";

        int l=0, r=map.get(key).size()-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            Pair p = map.get(key).get(mid);

            if(p.timestamp == timestamp)return p.value;
            else if(p.timestamp < timestamp){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }

        return (r >= 0) ? map.get(key).get(r).value : "";
    }
}

class Pair{
    String value;
    int timestamp;

    Pair(String value, int timestamp){
        this.value = value;
        this.timestamp = timestamp;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */