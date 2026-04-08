class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0, left = 0, maxf = 0;

        for(int right = 0; right < s.length(); right++){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);
            maxf = Math.max(maxf, map.get(s.charAt(right)));

            while((right - left + 1) - maxf > k){
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
