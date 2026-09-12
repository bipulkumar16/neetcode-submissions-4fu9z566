class Solution {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1, maxLeft = 0, maxRight = 0, max = 0;
        while(left < right){
            if(height[left] < height[right]){
                maxLeft = Math.max(maxLeft, height[left]);
                max += maxLeft - height[left];
                left++;
            } else {
                maxRight = Math.max(maxRight, height[right]);
                max += maxRight - height[right];
                right--;
            }
        }
        return max;
    }
}
