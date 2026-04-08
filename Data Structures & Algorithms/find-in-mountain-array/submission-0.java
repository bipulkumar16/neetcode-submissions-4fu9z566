/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        //Find Peak
        int left = 0, right = n -1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(mountainArr.get(mid) < mountainArr.get(mid + 1)){
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        int peak = left;
        // Search in ascending part
        int index = binarySearchAsc(mountainArr, target, 0, peak);
            if(index != -1) return index;
        // Search in descending part
        return binarySearchDesc(mountainArr, target, peak + 1, n - 1);
    }

    private int binarySearchAsc(MountainArray arr, int target, int left, int right){
        while(left <= right){
            int mid = left + (right - left)/2;
            int val = arr.get(mid);
            if(val == target) return mid;
            else if(val < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
    private int binarySearchDesc(MountainArray arr, int target, int left, int right){
        while(left <= right){
            int mid = left + (right - left)/2;
            int val = arr.get(mid);
            if(val == target) return mid;
            else if(val > target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
}