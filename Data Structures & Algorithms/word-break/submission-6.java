class Solution {
    Map<String, Boolean> map = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.isEmpty())
            return true;
        if (map.containsKey(s))
            return map.get(s);
        boolean flag = false;
        for (String each : wordDict){
            if (s.startsWith(each)){
                flag = wordBreak(s.substring(each.length()), wordDict);
                if (flag){
                    map.put(s, true);
                    return true;
                }
            }
        }
        map.put(s, false);
        return false;
    }
}
