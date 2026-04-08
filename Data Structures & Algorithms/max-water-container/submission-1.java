class Solution {
    public int maxArea(int[] heights) {
        int left = 0, max = 0, right = heights.length - 1;
        while(left < right){
            int area = (right - left) * Math.min(heights[left], heights[right]);
            max = Math.max(area, max);
            if(heights[left] <= heights[right]){
                left++;
            } else {
                right--;
            }
        }
        return max;
        // while(left < right){
        //     int area = (right - left) * Math.min(heights[left], heights[right]);
        //      max = Math.max(area, max);
        //      if(heights[left] <= heights[right]){
        //         left++;
        //      } else {
        //         right--;
        //      }
        // }
        // return max;
    }
}
