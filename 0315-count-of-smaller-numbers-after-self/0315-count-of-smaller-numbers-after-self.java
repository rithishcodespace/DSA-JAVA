// merge sort
// similar to count inversion problem's idea

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        // save each elements index
        int[] result = new int[nums.length]; // to store result
        ArrayWithOrgIdx[] newArray = new ArrayWithOrgIdx[nums.length]; //  to sort
        for(int i=0;i<nums.length;i++){
            newArray[i] = new ArrayWithOrgIdx(i, nums[i]);
        }
        // sort the elements
        merge_sort(0, nums.length-1, newArray, result); // [6,5,2,1]
        // convert array to list
        List<Integer> list = new ArrayList<>();
        for(int r : result){
            list.add(r);
        }

        return list;
    }
    public void merge_sort(int low, int high, ArrayWithOrgIdx[] newArray, int[] result){
        if(low >= high){ // single element
            return;
        }

        // split and merge
        int mid = (low+high)/2;
        merge_sort(low, mid, newArray, result);
        merge_sort(mid+1, high, newArray, result);

        merge(low, mid, high, newArray, result);
    }
    public void merge(int low, int mid, int high, ArrayWithOrgIdx[] newArray, int[] result){

        // merge them via 2 pointers
        List<ArrayWithOrgIdx> merged = new ArrayList<>();
        int i=low, j=mid+1, org=low, numElemsRightArrayLessThanLeftArray=0;

        while(i < mid+1 && j < high+1){
            if(newArray[i].val <= newArray[j].val){ // when i am out, i count how many ones are lost from right side
                result[newArray[i].org] += numElemsRightArrayLessThanLeftArray;
                merged.add(newArray[i++]);
            }
            else{
                ++numElemsRightArrayLessThanLeftArray;
                merged.add(newArray[j++]);
            }
        }
        // fill the left out
        while(i < mid+1){
            result[newArray[i].org] += numElemsRightArrayLessThanLeftArray;
            merged.add(newArray[i++]);
        }
        while(j < high+1){
            ++numElemsRightArrayLessThanLeftArray;
            merged.add(newArray[j++]);
        }

        int pos = low;
        for(ArrayWithOrgIdx m : merged){
            newArray[pos++] = m;
        }
    }
}
class ArrayWithOrgIdx{
    int org, val;

    ArrayWithOrgIdx(int org, int val){
        this.org = org;
        this.val = val;
    }
}