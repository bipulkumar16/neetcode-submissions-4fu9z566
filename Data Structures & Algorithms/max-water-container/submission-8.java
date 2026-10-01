class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0, left = 0, right = heights.length - 1;
        while(left < right){
            int area = (right - left) * Math.min(heights[left], heights[right]);
            maxArea = Math.max(maxArea, area);
            if(heights[left] < heights[right]) left++;
            else right--;
        }
        return maxArea;
    }
}
