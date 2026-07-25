class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for(int pile : piles) right = Math.max(right, pile);
        while(left <= right){
            int speed = left + (right - left)/2;
            long hours = 0;
            for(int pile : piles) hours += (speed + pile - 1)/speed;
            if(hours <= h) right = speed - 1;
            else left = speed + 1;
        }
        return left;
    }
}
