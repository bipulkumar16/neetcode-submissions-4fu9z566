class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
        for(char c : t.toCharArray()) map.put(c, map.getOrDefault(c, 0) - 1);
        for(int value : map.values()){
            if(value != 0) return false;
        }
        return true;
    }
}
