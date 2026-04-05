class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()){
            tMap.put(c, tMap.getOrDefault(c, 0)+1);
        }

        Map<Character, Integer> sMap = new HashMap<>();
        int start = 0;
        int minLen = s.length()+1;
        String bestStr = "";
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (tMap.containsKey(c)){
                sMap.put(c, sMap.getOrDefault(c, 0)+1); 
                while(checkMapsEquality(sMap, tMap)){
                    if (minLen > i - start + 1){
                        minLen = i - start + 1;
                        bestStr = s.substring(start, i +1);
                    }
                    char d = s.charAt(start);
                    if (sMap.containsKey(d)){
                        sMap.put(d, sMap.get(d)-1); 
                        if (sMap.get(d) == 0)
                            sMap.remove(d);
                    }
                    start++;
                }
            }
               
        }
        return minLen > s.length() ? "" : bestStr ;
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
