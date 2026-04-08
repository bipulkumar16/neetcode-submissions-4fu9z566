class Solution {
    public int[] dailyTemperatures(int[] temperatures) {

        //Using Stack
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];
        for(int i = 0; i < n; i++){
            while(!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int prev = stack.pop();
                result[prev] = i - prev;
            }
            stack.push(i);
        }
    return result;   
    //Brute Force
    //     
    //     int n = temperatures.length;
    //     int[] res = new int[n];
    //     for(int i = 0; i < n; i++){
    //         int count = 1;
    //         int left = i + 1;
    //         while(left < n){
    //             if(temperatures[left] > temperatures[i]){
    //             break;
    //         }
    //             left++;
    //             count++;
    //         }
    //         count = (left == n) ? 0 : count;
    //         res[i] = count;
    //     }
    //   return res;
    }
}
