// 8 states can be made with a string
// BFS is choosen, since we need to find the min moves with each moves gives 1 point

class Solution {
    public int openLock(String[] deadends, String target) {
      // save deadends
      HashSet<String> set = new HashSet<>();
      for(String d : deadends){
        set.add(d);
      }

      // visited set
      HashSet<String> visited = new HashSet<>();
      visited.add("0000");

      Queue<Element> queue = new LinkedList<>();
      queue.add(new Element(0, "0000"));

      while(!queue.isEmpty()){ 
        Element e = queue.poll();

        if(set.contains(e.wheels))continue;

        if(e.wheels.equals(target))return e.moves;

        // wheel 1
        StringBuilder wheel1 = new StringBuilder(e.wheels);
        int num1 = (wheel1.charAt(0) - '0' + 1) % 10;
        wheel1.setCharAt(0, (char)(num1 + '0')); // +1
        if(!visited.contains(wheel1.toString())){
            visited.add(wheel1.toString());
            queue.add(new Element(e.moves+1, wheel1.toString()));
        }

        num1 = (wheel1.charAt(0) - '0' - 2 + 10) % 10;
        wheel1.setCharAt(0, (char)(num1 + '0')); // -1
        if(!visited.contains(wheel1.toString())){
            visited.add(wheel1.toString());
            queue.add(new Element(e.moves+1, wheel1.toString()));
        }


        // wheel 2
        StringBuilder wheel2 = new StringBuilder(e.wheels);
        int num2 = (wheel2.charAt(1) - '0' + 1) % 10;
        wheel2.setCharAt(1, (char)(num2 + '0')); // 1
        if(!visited.contains(wheel2.toString())){
            visited.add(wheel2.toString());
            queue.add(new Element(e.moves+1, wheel2.toString()));
        }

        num2 = (wheel2.charAt(1) - '0' - 2 + 10) % 10;
        wheel2.setCharAt(1, (char)(num2 + '0')); // -1
        if(!visited.contains(wheel2.toString())){
            visited.add(wheel2.toString());
            queue.add(new Element(e.moves+1, wheel2.toString()));
        }


        // wheel 3
        StringBuilder wheel3 = new StringBuilder(e.wheels);
        int num3 = (wheel3.charAt(2) - '0' + 1) % 10;
        wheel3.setCharAt(2, (char)(num3 + '0')); // 1
        if(!visited.contains(wheel3.toString())){
            visited.add(wheel3.toString());
            queue.add(new Element(e.moves+1, wheel3.toString()));
        }

        num3 = (wheel3.charAt(2) - '0' - 2 + 10) % 10;
        wheel3.setCharAt(2, (char)(num3 + '0')); // -1
        if(!visited.contains(wheel3.toString())){
            visited.add(wheel3.toString());
            queue.add(new Element(e.moves+1, wheel3.toString()));
        }


        // wheel 4
        StringBuilder wheel4 = new StringBuilder(e.wheels);
        int num4 = (wheel4.charAt(3) - '0' + 1) % 10;
        wheel4.setCharAt(3, (char)(num4 + '0')); // +1
        if(!visited.contains(wheel4.toString())){
            visited.add(wheel4.toString());
            queue.add(new Element(e.moves+1, wheel4.toString()));
        }

        num4 = (wheel4.charAt(3) - '0' - 2 + 10) % 10;
        wheel4.setCharAt(3, (char)(num4 + '0')); // -1
        if(!visited.contains(wheel4.toString())){
            visited.add(wheel4.toString());
            queue.add(new Element(e.moves+1, wheel4.toString()));
        }
      }

      return -1;
    }
}
class Element{
    int moves;
    String wheels;

    Element(int moves, String wheels){
        this.moves = moves;
        this.wheels = wheels;
    }
}