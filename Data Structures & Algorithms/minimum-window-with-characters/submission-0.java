class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0)+1);
        System.out.println(map);

        int start = 0;
        int end = 0;
        int len = Integer.MAX_VALUE;
        int bestStart = 0; 
        Map<Character, Integer> m = new HashMap<>();
        while (end < s.length()){
            char c = s.charAt(end);
            if (map.containsKey(c)){
                m.put(c, m.getOrDefault(c, 0)+1);
                while(checkMapsEquality(m, map)){
                    if (end - start + 1 < len) {
                        len = end - start + 1;
                        bestStart = start;
                    }
                    char ch = s.charAt(start);
                    if (m.containsKey(ch)){
                        m.put(ch, m.get(ch)-1);
                        if (m.get(ch) == 0)
                            m.remove(ch);
                    }
                    start++;
                }
            }
            end++;
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + len);
    }
    boolean checkMapsEquality(Map<Character, Integer> window, Map<Character, Integer> target){
        for (char c : target.keySet()) {
            if (window.getOrDefault(c, 0) < target.get(c)) {
                return false;
            }
        }
        return true;
    }
}
