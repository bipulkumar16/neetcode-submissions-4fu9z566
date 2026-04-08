class Solution {
    public boolean makesquare(int[] matchsticks) {
        int sum = 0;
        for(int i = 0; i < matchsticks.length; i++){
            sum += matchsticks[i];
        }
        if(sum % 4 != 0) return false;
        int target = sum / 4;
        Arrays.sort(matchsticks);
        reverse(matchsticks);
        int[] sides = new int[4];
        return backtrack(matchsticks, 0, sides, target);
    }
    private boolean backtrack(int[] sticks, int index, int[] sides, int target) {
        if(index == sticks.length) return true;
        int stick = sticks[index];
        for(int i = 0; i < 4; i++){
            if(sides[i] + stick > target) continue;
            sides[i] += stick;
            if(backtrack(sticks, index + 1, sides, target)) return true;
            sides[i] -= stick;
            if(sides[i] == 0) break;
        }
        return false;
    }
    private void reverse(int[] arr){
        int left = 0, right = arr.length - 1;
        while(left < right){
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}