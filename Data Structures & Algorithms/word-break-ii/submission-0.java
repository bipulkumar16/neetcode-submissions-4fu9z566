class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        Map<String, List<String>> memo = new HashMap<>();
        return backtrack(s, set, memo);
    }
    private List<String> backtrack(String s, Set<String> set, Map<String, List<String>> memo) {
        if(memo.containsKey(s)) return memo.get(s);
        List<String> result = new ArrayList<>();
        if(s.isEmpty()){
            result.add("");
            return result;
        }
        for(int i = 0; i <= s.length(); i++){
            String prefix = s.substring(0, i);
            if(set.contains(prefix)){
                List<String> suffixList = backtrack(s.substring(i), set, memo);
                for(String suffix : suffixList){
                    if(suffix.isEmpty()) {
                        result.add(prefix);
                    } else {
                        result.add(prefix + " " + suffix);
                    }
                }
            }
        }
        memo.put(s, result);
        return result;
    }
}