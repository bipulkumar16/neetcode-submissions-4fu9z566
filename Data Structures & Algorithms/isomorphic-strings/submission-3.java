class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;
        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if(mapS.containsKey(cs)){
                if(mapS.get(cs) != ct) return false;
            } else mapS.put(cs, ct);
            if(mapT.containsKey(ct)){
                if(mapT.get(ct) != cs) return false;
            } else mapT.put(ct, cs);
        }
        return true;
    }
}