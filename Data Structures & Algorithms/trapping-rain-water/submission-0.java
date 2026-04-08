class Solution {
    public int trap(int[] height) {
        if(height == null || height.length == 0) {
            return 0;
        }
        int left = 0, right = height.length - 1, max = 0, leftMax = 0, rightMax = 0;
        while(left < right){
            if(height[left] < height[right]){
                if(height[left] >= leftMax){
                    leftMax = height[left];
                } else {
                    max += leftMax - height[left];
                }
                left++;
            } else {
                if(height[right] >= rightMax){
                    rightMax = height[right];
                } else {
                    max += rightMax - height[right];
                }
                right--;
            }
        }
        return max;
    }
}
