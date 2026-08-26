class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int previousDay = stack.pop();
                result[previousDay] = i - previousDay;
            }
            stack.push(i);
        }
        return result;
    }
}
