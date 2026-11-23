// Prefix sum;
class ProductOfNumbers {
    List<Integer> list = new ArrayList<>();
    public ProductOfNumbers() {
     // null    
    }
    
    public void add(int num) {
        if(num == 0)list.clear();
        else if(list.size() == 0)list.add(num);
        else list.add(num*list.get(list.size()-1));
    }
    
    public int getProduct(int k) {
        if(k > list.size())return 0; // here we have omitted zero, by clearing the list, In constraint, the size of the array will be >= k, so the if the k < size, we should be seen a zero and cleared the list so the result would be 0
        int remPart = (list.size() - k)-1;
        if(remPart < 0)return list.get(list.size()-1);
        else return list.get(list.size()-1)/list.get(remPart);
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */