class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int x: asteroids){
            boolean destroyed = false;
            while (!stack.isEmpty() && x < 0 && stack.peek() > 0) {
                if(Math.abs(stack.peek()) < Math.abs(x)){
                    stack.pop();
                    continue;
                } else if(Math.abs(stack.peek()) == Math.abs(x)){
                    stack.pop();
                    destroyed = true;
                    break;
                } else {
                    destroyed = true;
                    break;
                }
            }
            if(!destroyed){
                stack.push(x);
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}