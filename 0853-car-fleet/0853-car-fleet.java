// it is basically a linear equation (neetcode yt video)
// two cars form a fleet, when the car behind reaches the target at time lesser than the car at front reaches the target
// when i identified two cars form a fleet, the car behind continue with car at front with same speed (eventually both cars position becomes same - pop the behind car from stack)

// test case 1:
// time = [12, 3, 7, 1, 1] -> fleeted -> [12, 7, 1] (will be on stack) -> monotonically increasing stack

// sort the (position, speed) according to positions\

// time = distance / speed
//      = (target-position) / speed

// tc: O(nlogn)
// sc: O(n)

class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Pair[] cars = new Pair[position.length];
        Stack<Double> stack = new Stack<>();

        // sort the cars to place in the number line
        for(int i=0;i<position.length;i++){
            cars[i] = new Pair(position[i], speed[i]);
        }
        Arrays.sort(cars,(a,b) -> a.position-b.position);

        // find the time each car reaches the target, and group them(fleet) when car behind reaches the target faster than front car
        for(int i=cars.length-1;i>=0;i--){
            double time = (double)(target - cars[i].position) / cars[i].speed;
            if(stack.isEmpty() || stack.peek() < time){ // no need while
                stack.push(time); // leave invalid ones
            }
        }

        return stack.size();
    }
}
class Pair{
    int position;
    int speed;

    Pair(int position, int speed){
        this.position = position;
        this.speed = speed;
    }
}