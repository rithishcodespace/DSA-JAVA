// HashSet -> Insert, Delete -> Average O(1)
//         -> but get() won't work

// HashMap -> insert, delete -> Average O(1)
// getRandom -> ArrayList with random.nextInt(n) -> returns a number between 1,n
// delete -> swap it with last element, and delete the swapped last idx

class RandomizedSet {

    HashMap<Integer,Integer> hmap;
    List<Integer> list;
    Random random;

    public RandomizedSet() {
        hmap = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
        if(hmap.containsKey(val))return false;
        hmap.put(val, list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(!hmap.containsKey(val))return false;
        // swap idx with lastidx
        int temp = list.get(list.size()-1);
        list.set(list.size()-1, list.get(hmap.get(val)));
        list.set(hmap.get(val), temp);
        // update the index
        hmap.put(temp, hmap.get(val));
        // remove from hashmap
        hmap.remove(val);
        // remove the last index
        list.remove(list.size()-1);
        return true;
    }
    
    public int getRandom() {
        int idx = random.nextInt(list.size());
        return list.get(idx);
    }
}