class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1, leftMax = 0, max = 0, rightMax = 0;
        while(left < right){
            if(height[left] < height[right]){
                leftMax = Math.max(leftMax, height[left]);
                max += leftMax - height[left];
                left++;
            } else {
                rightMax = Math.max(rightMax, height[right]);
                max += rightMax - height[right];
                right--;
            }
        }
        return max;
    }
}
