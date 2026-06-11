class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        // attach elements
        List<Element> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();
        Stack<Element> stack = new Stack<>();
        for(int i=0;i<positions.length;i++){
            list.add(new Element(positions[i], healths[i], directions.charAt(i), i));
        }

        Collections.sort(list,(a,b) -> a.p - b.p);

        for(Element elem : list){
            int pick = 1;
            while(!stack.isEmpty() && elem.d == 'L' && stack.peek().d == 'R'){
                if(elem.h == stack.peek().h){
                    stack.pop();
                    pick = 0;
                    break;
                }
                else if(elem.h > stack.peek().h){
                    stack.pop();
                    elem.h--;
                    // System.out.println(elem.p+" "+elem.h+" "+elem.d);
                }
                else{
                    stack.peek().h--;
                    pick = 0;
                    break;
                }
            }
            if(pick == 1)stack.push(elem);
        }

        list.clear();
        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        Collections.sort(list, (a,b) -> a.idx-b.idx);

        for(int i=0;i<list.size();i++){
            ans.add(list.get(i).h);
        }

        return ans;
    }
}
class Element{
    int p;
    int h;
    char d;
    int idx;

    Element(int p, int h, char d, int idx){
        this.p = p;
        this.h = h;
        this.d = d;
        this.idx = idx;
    }
}